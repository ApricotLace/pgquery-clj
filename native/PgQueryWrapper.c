#include <jni.h>
#include <stdio.h>
#include <stdlib.h>
#include "dev_ghrp_pgquery_PgQueryWrapper.h"
#include "pg_query.h"

JNIEXPORT jstring JNICALL Java_dev_ghrp_pgquery_PgQueryWrapper_parseSQL(JNIEnv *env, jobject obj, jstring sql) {
    const char *nativeSql = (*env)->GetStringUTFChars(env, sql, 0);
    
    PgQueryParseResult result = pg_query_parse(nativeSql);
    (*env)->ReleaseStringUTFChars(env, sql, nativeSql);

    if (result.error) {
        jstring error = (*env)->NewStringUTF(env, result.error->message);
        pg_query_free_parse_result(result);
        return error;
    }

    jstring jsonResult = (*env)->NewStringUTF(env, result.parse_tree);
    pg_query_free_parse_result(result);
    return jsonResult;
}

