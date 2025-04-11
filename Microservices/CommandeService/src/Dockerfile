# Étape 1 : Utiliser une image JDK officielle
FROM openjdk:17-jdk-slim

# Étape 2 : Créer un répertoire pour l’application
WORKDIR /app

# Étape 3 : Copier le JAR généré dans le conteneur
ADD target/commande-service.jar commande-service.jar

# Étape 4 : Exposer le port du microservice
EXPOSE 8093

# Étape 5 : Commande pour exécuter le microservice
ENTRYPOINT ["java", "-jar", "commande-service.jar"]
