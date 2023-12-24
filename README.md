# JAVA API_POO tp avec SPRING BOOT 
## TP3
### etape 5

Technologies et Leur Utilité
Spring Web : Propose des outils essentiels pour développer des applications web, intégrant des fonctionnalités telles que le modèle MVC de Spring, la prise en charge des requêtes REST, et la sérialisation des données.

Spring Data JPA : Facilite la gestion des données en proposant une interface simplifiée pour réaliser des opérations CRUD, tout en assurant une intégration fluide avec JPA.

H2 Database : Base de données légère et en mémoire, idéale pour les phases de développement et de test, ne nécessitant aucune installation séparée.

Thymeleaf : Un moteur de rendu de templates pour générer des vues HTML dynamiques, permettant d'intégrer des données côté serveur dans les interfaces utilisateur.

Spring Boot DevTools : Offre un ensemble d'outils destinés à optimiser le développement sous Spring Boot, notamment via le rechargement automatique du code et des ressources.


### Étape 13 - Fonctionnement du Contrôleur HelloWorldController
Configuration de l'URL : Avec @GetMapping("/greeting"), cette annotation spécifie que la méthode greeting répond à l'URL /greeting.

Sélection du Template HTML : La méthode greeting renvoie "greeting", indiquant à Thymeleaf de charger greeting.html.

Transmission de Données aux Vues : L'utilisation de @RequestParam permet de capter le paramètre nameGET de la requête, qui est ensuite passé au modèle et affiché dans greeting.html.


### Étape 17 - Observation dans la Console H2
Création Automatique de Table : La présence de la table ADDRESS dans la base de données H2 est une conséquence directe de l'annotation @Entity dans la classe Address.

### Etape 18 - Logique de Création de Table par Hibernate
Mécanisme d'Hibernate : Exploitant les annotations JPA dans Address, Hibernate configure et crée automatiquement la table correspondante.


### Étape 20 - Validation des Données dans H2
Confirmation des Insertions : Les données de data.sql ont été correctement insérées dans la table Address, comme le démontre la requête SELECT effectuée dans la console H2.

### Étape 22 - Explication de @Autowired
Injection de Dépendances : @Autowired facilite l'injection de AddressRepository dans AddressController, démontrant l'efficacité de Spring en matière de gestion des dépendances.

### Étape 27 - Intégration d'une Barre de Navigation
Utilisation de Bootstrap et Thymeleaf : La navbar ajoutée améliore la navigation et l'esthétique du site grâce à l'intégration de Bootstrap et Thymeleaf.

### Étape 30 - Ajout de Bootstrap via Maven
<dependency>
<groupId>org.webjars</groupId>
<artifactId>bootstrap</artifactId>
<version>5.3.0</version> <!-- Adjust the version to the latest available -->
</dependency>




