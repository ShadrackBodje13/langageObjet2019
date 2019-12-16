# PROJET FINAL : BLOG

## Overview

L'objectif est de créer un **blog en JavaEE**. Les fonctionnalités classiques devront être implémentées.
Le code source devra être herbégé sur un repository git dont j'aurais l'accès (mon compte: romainsessa).
Le projet devra être déployable dans un serveur Tomcat grâce au fichier .war (téléchargeable du repository).

## Design

C'est avant tout le code Java qui sera évalué, cependant un **design moderne** (standard du web actuel) devra être mis en place.

## Fonctionnalités

> Un article se définit par : 
> - un auteur
> - un titre
> - une courte description
> - un texte
> - une date

### Consultation

L'application web permettra de :
- Consulter sur la page d'accueil les 2 derniers articles créés.
- Consulter la liste de tous les articles : affichage du titre, de l'auteur, de la courte description et de la date.
- Consulter un article de façon unitaire.
- Consulter la liste des auteurs avec pour chaque auteur la liste des titres des articles écrits.

### Edition

L'application web permettre de :
- Ajouter un nouvel article (la date sera générée automatiquement).
- Modifier un article (la date sera générée automatiquement).
- Supprimer un article.

## Bonus

**Système de connexion**
Mise en place d'une connexion utilisateur via les fonctionnalités suivantes :
- Créer un compte (username / password).
- Se connecter.
- Se déconnecter.
- Lors de la création de l'article, l'auteur est automatiquement récupéré grâce à l'utilisateur connecté.

**Système de commentaire**
Lors de la visualisation d'un article de façon unitaire, des commentaires peuvent être ajoutés, supprimés et visualisés.
Il faut être connecté pour ajouter un commentaire ou supprimer un commentaire que l'on a ajouté (impossible de supprimer le commenaire d'une autre personne).


