# This Dockerfile defines how to containerize this service.
FROM identifiersorg/linux-java8
LABEL maintainer="Manuel Bernal Llinares <mbdebian@gmail.com>"

# Environment - defaults
ENV HQ_WS_MIR_ID_CONTROLLER_JVM_MEMORY_MAX 768m

# Prepare the application folder
RUN mkdir -p /home/app

# Add the application structure
ADD target/app/. /home/app
