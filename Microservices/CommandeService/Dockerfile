FROM openjdk:17
EXPOSE 8093
ADD target/CommandeService-0.0.1-SNAPSHOT.jar commande.jar
ENTRYPOINT ["java", "-jar","commande.jar"]