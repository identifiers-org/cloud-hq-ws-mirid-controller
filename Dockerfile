# This Dockerfile defines how to containerize this service.
FROM identifiersorg/linux-java8:1.2.0
LABEL maintainer="Renato Caminha Juaçaba Neto <rjuacaba@gmail.com>"

# Environment - defaults
ENV HQ_WS_MIRID_CONTROLLER_JVM_MEMORY_MAX 768m

# Prepare the application folder
RUN mkdir -p /home/app

# Add the application structure
ADD target/app/. /home/app

# Launch information
EXPOSE 8181
WORKDIR /home/app
#CMD ["java", "-Xmx1024m", "-jar", "service.jar"]
CMD java -Xmx${HQ_WS_MIRID_CONTROLLER_JVM_MEMORY_MAX} -jar service.jar
