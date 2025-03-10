FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAVA_OPTS
ENV JAVA_OPTS=$JAVA_OPTS
COPY target/bank-1.0-SNAPSHOT.jar gestionparking.jar
EXPOSE 8081
ENTRYPOINT exec java $JAVA_OPTS -jar gestionparking.jar
# For Spring-Boot project, use the entrypoint below to reduce Tomcat startup time.
#ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar gestionparking.jar
