package dev.ghrp.pgquery;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class PgQueryWrapper {
    static {
        try {
            loadNativeLibrary();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load native library");
        }
    }

    private static void loadNativeLibrary() throws Exception {
        String libName = "libpg_query_jni.so";
        String libPath = "/native/" + libName;

        InputStream in = PgQueryWrapper.class.getResourceAsStream(libPath);
        if (in == null) {
            throw new Exception("Native library not found inside JAR: " + libPath);
        }

        File tempFile = File.createTempFile("pg_query_jni", ".so");
        tempFile.deleteOnExit();

        try (OutputStream out = new FileOutputStream(tempFile)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
        }

        System.load(tempFile.getAbsolutePath());
    }

    public native String parseSQL(String sql);

    public static void main(String[] args) {
        PgQueryWrapper wrapper = new PgQueryWrapper();
        String result = wrapper.parseSQL("SELECT * FROM users;");
        System.out.println(result);
    }
}

