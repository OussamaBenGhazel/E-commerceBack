 📦 Order & Invoice Management System

> Application Fullstack pour la gestion des **commandes** et **factures**, développée avec **Spring Boot (Microservices)** et **Angular**.
---

## 📁 Structure du projet

```
project-root/
├── backend/
│   ├── config-service/
│   ├── discovery-service/
│   ├── gateway-service/
│   ├── commande-service/
│   └── facture-service/
└── frontend/
    └── order-invoice-app/
```

---

## 🚀 Technologies utilisées

### 🖥️ Backend
- Java 17
- Spring Boot 3.4.2
- Spring Cloud 2023.0.1
- Spring Cloud Config Server
- Eureka Discovery
- Spring Gateway
- Spring Data JPA
- MySQL
- Docker (optionnel)

### 🌐 Frontend
- Angular 17+
- Angular Router
- Angular HttpClient
- Angular Material (optionnel)
- Bootstrap (optionnel)

---

## 🔧 Fonctionnalités

### 🧾 Commande
- Créer une commande
- Lister toutes les commandes
- Voir les détails d’une commande
- Mettre à jour ou supprimer une commande

### 📑 Facture
- Générer une facture à partir d’une commande
- Lister toutes les factures
- Voir les détails d’une facture
- Suivre le statut de paiement (payée / en attente)

---

## 🔙 Microservices Backend

| Microservice        | Description                                      |
|---------------------|--------------------------------------------------|
| config-service      | Fournit les configurations centralisées         |
| discovery-service   | Enregistre les microservices (Eureka Server)    |
| gateway-service     | Point d’entrée API via Spring Cloud Gateway     |
| commande-service    | Gestion des commandes et facture                      

---

## 🧪 Comment exécuter le projet

### ✅ Backend

```bash
cd backend/

# Lancer chaque service dans cet ordre :
1. config-service
2. discovery-service
3. gateway-service
4. commande-service

```

Commandes de lancement (par service) :
```bash
./mvnw spring-boot:run
```

### ✅ Frontend

```bash
cd frontend/order-invoice-app/
npm install
ng serve --open
```

L'application Angular sera disponible sur : `http://localhost:4200`

---

## 🔗 API - Endpoints

### 📦 Commande
- `GET    /api/commandes`
- `POST   /api/commandes`
- `GET    /api/commandes/{id}`
- `PUT    /api/commandes/{id}`
- `DELETE /api/commandes/{id}`

### 🧾 Facture
- `GET    /api/factures`
- `POST   /api/factures`
- `GET    /api/factures/{id}`

---

## 🎨 Interface Utilisateur (Frontend Angular)

L’interface propose :
- Formulaire de création de commande
- Génération de facture associée
- Visualisation des factures et de leur statut
- Navigation fluide avec routing Angular

⚠️ **Screenshots à ajouter** pour illustrer l’UI

---

## 📌 Roadmap (TODO)

- [ ] Intégration API Stripe pour les paiements
- [ ] Authentification (Keycloak / JWT)
- [ ] Export PDF de la facture
- [ ] Envoi d’email automatique avec facture

---

## 👨‍💻 Auteur

- 👤 **Mouhamed Aziz Ben Abda**
- 📧 azizbenabeda123@gmail.com
- 🌐 [GitHub](github.com/AzizBenabda1?tab=repositories) | [LinkedIn](https://www.linkedin.com/in/mouhamed-aziz-ben-abda-71a615218/))

---



---

> ✨ N'hésite pas à contribuer, proposer des améliorations ou signaler des bugs via Issues ou Pull Requests !
