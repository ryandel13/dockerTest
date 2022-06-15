FROM openjdk:17.0.1-jdk-slim

RUN jlink --no-header-files --no-man-pages --compress=2 --strip-debug --add-modules java.logging --output /usr/lib/jvm/spring-boot-runtime

FROM debian:stretch-slim

COPY --from=0 /usr/lib/jvm/spring-boot-runtime /usr/lib/jvm/spring-boot-runtime
RUN ln -s /usr/lib/jvm/spring-boot-runtime/bin/java /usr/bin/java