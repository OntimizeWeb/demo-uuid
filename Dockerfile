FROM openjdk:11-jre-slim

ENV PORT 8080
ENV CLASSPATH /opt/lib
EXPOSE 8080

# Copy jar file
COPY ./prototypen-boot/target/prototypen-boot.jar /opt/prototypen-boot.jar
WORKDIR /opt
CMD ["/bin/bash", "-c", "case $ENVIRONMENT_PROFILE in 'production') java -jar prototypen-boot.jar --spring.profiles.active=production;; *) java -jar prototypen-boot.jar --spring.profiles.active=staging;; esac;"]
