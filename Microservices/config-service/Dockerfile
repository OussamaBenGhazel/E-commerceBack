FROM openjdk:17
#utilise le meme port que le fichier application.properties
EXPOSE 8888
ADD target/config-service-0.0.1-SNAPSHOT.jar config-service.jar
ENTRYPOINT ["java", "-jar","config-service.jar"]