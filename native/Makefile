JAVA_HOME := /opt/homebrew/opt/openjdk
CFLAGS := -I$(JAVA_HOME)/include -I$(JAVA_HOME)/include/darwin -I../libs/libpg_query
LDFLAGS := -L../libs/libpg_query -lpg_query

libpg_query_jni.so: PgQueryWrapper.o
	@gcc -shared -o libpg_query_jni.so PgQueryWrapper.o $(LDFLAGS)

PgQueryWrapper.o: PgQueryWrapper.c
	@gcc $(CFLAGS) -fPIC -c PgQueryWrapper.c -o PgQueryWrapper.o

clean:
	@rm -f *.o *.so

