# TP 10 : Client REST Android Retrofit (XML & JSON)

Projet réalisé dans le cadre du cours **Architecture Microservices : Conception, Déploiement et Orchestration (Cours ID: 7)** — **Lab 164 : TP 10 : Client REST Android Retrofit (XML & JSON)**.

---

## 📌 Objectif du TP

Créer une application mobile Android native permettant de consommer un service web REST de gestion de comptes bancaires avec un cycle CRUD complet (Create, Read, Update, Delete) :
- Appels réseau asynchrones avec **Retrofit 2**.
- Prise en charge dynamique de deux formats de sérialisation : **JSON** (via `GsonConverter`) et **XML** (via `SimpleXmlConverter`).
- Basculement instantané à la volée entre les deux formats via un sélecteur `RadioGroup` dans l'interface utilisateur.
- Affichage moderne et réactif des comptes à l'aide de **RecyclerView** et **MaterialCardView**.
- Boîtes de dialogue Material Design pour l'ajout, la modification et la confirmation de suppression d'un compte.
- Configuration de la sécurité réseau Android (`network-security-config.xml`) autorisant le trafic clair vers l'adresse `10.0.2.2` (accès à l'hôte local depuis l'émulateur).

---

## 🏗️ Architecture et Structure du Projet

```text
restclient/
├── app/
│   ├── build.gradle
│   ├── proguard-rules.pro
│   └── src/
│       ├── main/
│       │   ├── AndroidManifest.xml
│       │   ├── java/ma/projet/restclient/
│       │   │   ├── MainActivity.java
│       │   │   ├── adapter/
│       │   │   │   └── CompteAdapter.java
│       │   │   ├── api/
│       │   │   │   └── CompteService.java
│       │   │   ├── config/
│       │   │   │   └── RetrofitClient.java
│       │   │   ├── entities/
│       │   │   │   ├── Compte.java
│       │   │   │   └── CompteList.java
│       │   │   └── repository/
│       │   │       └── CompteRepository.java
│       │   └── res/
│       │       ├── layout/
│       │       │   ├── activity_main.xml
│       │       │   ├── dialog_add_compte.xml
│       │       │   └── item_compte.xml
│       │       ├── values/
│       │       │   ├── colors.xml
│       │       │   ├── strings.xml
│       │       │   └── themes.xml
│       │       └── xml/
│       │           └── network-security-config.xml
│       └── test/java/ma/projet/restclient/
│           ├── CompteEntityTest.java
│           └── RetrofitClientTest.java
├── build.gradle
├── gradle.properties
├── settings.gradle
└── README.md
```

---

## 🌐 Endpoints REST Consommés (`CompteService`)

| Méthode HTTP | URL Endpoint | Format / Headers | Description |
| :--- | :--- | :--- | :--- |
| **GET** | `/banque/comptes` | `Accept: application/json` | Récupération de tous les comptes en JSON |
| **GET** | `/banque/comptes` | `Accept: application/xml` | Récupération de tous les comptes en XML |
| **GET** | `/banque/comptes/{id}` | N/A | Récupération d'un compte par son identifiant |
| **POST** | `/banque/comptes` | `Content-Type: application/json` | Création d'un nouveau compte |
| **PUT** | `/banque/comptes/{id}` | `Content-Type: application/json` | Mise à jour des informations d'un compte |
| **DELETE** | `/banque/comptes/{id}` | N/A | Suppression définitive d'un compte |

---

## ⚙️ Configuration Réseau Android (`network-security-config.xml`)

Le fichier `res/xml/network-security-config.xml` configure l'accès HTTP non chiffré vers l'adresse `10.0.2.2` (alias de l'ordinateur hôte dans l'émulateur Android) :
```xml
<?xml version="1.0" encoding="utf-8"?>
<network-security-config>
    <domain-config cleartextTrafficPermitted="true">
        <domain includeSubdomains="true">10.0.2.2</domain>
    </domain-config>
</network-security-config>
```

---

## 📱 Fonctionnalités de l'Application

1. **Sélection dynamique du format** :
   - Choix entre les boutons radio `JSON` et `XML`.
   - Changement immédiat du convertisseur Retrofit (`GsonConverterFactory` ou `SimpleXmlConverterFactory`).
2. **Ajout d'un compte** :
   - Clic sur le bouton flottant (FAB).
   - Saisie du solde et choix du type (`COURANT` ou `EPARGNE`).
   - Génération automatique de la date du jour au format `yyyy-MM-dd`.
3. **Modification d'un compte** :
   - Clic sur le bouton "Modifier" d'une carte de compte.
   - Pré-remplissage des données actuelles, mise à jour via `PUT`.
4. **Suppression d'un compte** :
   - Clic sur "Supprimer", demande de confirmation par dialogue AlertDialog, puis suppression via `DELETE`.

---

## 🛠️ Compilation & Tests

Le projet est directement importable dans **Android Studio** ou compilable en ligne de commande :
- Ouvrir dans Android Studio : `File > Open > restclient`
- Lancer l'exécution sur un émulateur ou appareil connecté.
- Les tests unitaires dans `app/src/test` valident les entités, la gestion des listes XML/JSON et la configuration du client Retrofit.

