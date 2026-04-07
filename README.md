# TP Store API

API REST développée en **Java avec Spring Boot** permettant de gérer un catalogue d’articles.

Ce projet a été réalisé dans le cadre de ma formation afin de démontrer mes compétences en développement backend Java (architecture, API REST, persistance, sécurité, tests).

---

## 🚀 Fonctionnalités

* CRUD complet sur les articles
* API REST avec Spring Boot
* Persistance des données avec Spring Data JPA (MySQL)
* Documentation API avec Swagger (SpringDoc)
* Gestion de la sécurité avec JWT (en cours d’intégration)
* Internationalisation des messages (i18n)
* Tests unitaires avec JUnit et Mockito

---

## 🧱 Architecture

Le projet suit une architecture en couches :

```
Controller → Service → Repository → Base de données
```

* **Controller** : expose les endpoints REST
* **Service** : contient la logique métier
* **Repository** : gère l’accès aux données (JPA)

---

## 🛠️ Technologies utilisées

* Java 17
* Spring Boot
* Spring Web
* Spring Data JPA
* Spring Security
* JWT
* MySQL
* Swagger / OpenAPI
* JUnit 5 / Mockito

---

## ⚙️ Installation & Lancement

### Prérequis

* Java 17
* MySQL

### Configuration

Créer une base de données :

```sql
CREATE DATABASE store_api;
```

Configurer `application.properties` si nécessaire (user / password).

---

### Lancer le projet

```bash
./gradlew clean build
./gradlew bootRun
```

L’API sera disponible sur :

```
http://localhost:8080
```

Swagger :

```
http://localhost:8080/swagger-ui.html
```

---

## 📡 Endpoints principaux

| Méthode | Endpoint     | Description                 |
| ------- | ------------ | --------------------------- |
| GET     | /getAll      | Liste des articles          |
| GET     | /getId/{id}  | Récupérer un article        |
| POST    | /save        | Créer / modifier un article |
| DELETE  | /delete/{id} | Supprimer un article        |

---

## 🧪 Tests

* Tests d’intégration avec Spring Boot
* Tests unitaires avec Mockito

⚠️ Certains tests unitaires sont encore à améliorer

---

## 🔒 Sécurité

* Mise en place de JWT (génération et validation)
* Protection des endpoints à compléter
