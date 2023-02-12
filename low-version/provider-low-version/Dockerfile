FROM registry.cn-beijing.aliyuncs.com/xixitime/openjdk:11-jdk

ARG DEPENDENCY=target/dist
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /app

WORKDIR /app

ENV JAVA_MAIN_CLASS "org.example.LowVersionProvider"
ENTRYPOINT exec java $JAVA_OPTS -cp /app:/app/lib/* $JAVA_MAIN_CLASS "$@"