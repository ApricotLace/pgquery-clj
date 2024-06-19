.PHONY: clean

JAVA_HOME = $(shell java -XshowSettings:properties 2>&1 -version | grep 'java.home' | cut -d '=' -f 2- | sed 's/^\s*//g')
CFLAGS = -I$(JAVA_HOME)/include -I$(JAVA_HOME)/include/linux -I$(JAVA_HOME)/include/darwin -I../libs/libpg_query
LDFLAGS = -L../libs/libpg_query -lpg_query

all:
	$(CC) $(CFLAGS) $(LDFLAGS) -shared -fPIC -o libpg_query_jni.so PgQueryWrapper.c

clean:
	rm -f *.o *.so

