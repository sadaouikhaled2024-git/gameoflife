# Jeu de la Vie de Conway

Une implémentation Java du Jeu de la Vie de Conway, un automate cellulaire conçu par le mathématicien britannique John Horton Conway en 1970. Ce jeu sans joueur simule l'évolution des cellules sur une grille basée sur des règles simples, démontrant comment des motifs complexes peuvent émerger d'interactions basiques.

## Fonctionnalités

- Interface utilisateur graphique interactive construite avec JavaFX
- Simulation en temps réel de l'évolution de l'automate cellulaire
- Configurations initiales personnalisables
- Modes de simulation pas à pas ou continus
- Implémentation basée sur des matrices pour un calcul efficace
- Suite de tests complète

## Règles du Jeu

L'univers du Jeu de la Vie est une grille orthogonale infinie, bidimensionnelle, de cellules carrées, chacune étant dans l'un des deux états possibles : vivante ou morte.

Chaque cellule interagit avec ses huit voisins, qui sont les cellules adjacentes horizontalement, verticalement ou diagonalement. À chaque étape temporelle, les transitions suivantes se produisent :

1. **Sous-population** : Toute cellule vivante avec moins de deux voisins vivants meurt.
2. **Survie** : Toute cellule vivante avec deux ou trois voisins vivants survit à la génération suivante.
3. **Surpopulation** : Toute cellule vivante avec plus de trois voisins vivants meurt.
4. **Reproduction** : Toute cellule morte avec exactement trois voisins vivants devient une cellule vivante.

## Pour Commencer

### Prérequis

- Java 11 ou supérieur
- Gradle 6.0 ou supérieur

### Exécution de l'Application

1. Cloner le dépôt
2. Naviguer vers le répertoire du projet
3. Exécuter l'application en utilisant Gradle :

```bash
./gradlew run
```

Sur Windows :
```bash
gradlew.bat run
```

### Construction du Projet

Pour construire le projet :

```bash
./gradlew build
```

### Exécution des Tests

Pour exécuter la suite de tests :

```bash
./gradlew test
```

## Structure du Projet

- `src/main/java/controller/` - Contrôleurs d'application et logique de simulation
- `src/main/java/model/` - Logique de jeu principale et implémentation de l'automate cellulaire
- `src/main/java/matrix/` - Structures de données matricielles et opérations
- `src/main/java/view/` - Composants d'interface utilisateur JavaFX
- `src/test/java/` - Tests unitaires

## Technologies Utilisées

- **Java** : Langage de programmation principal
- **JavaFX** : Framework d'interface graphique
- **Gradle** : Outil d'automatisation de construction
- **JUnit** : Framework de test

## Contribution

N'hésitez pas à soumettre des problèmes et des demandes d'amélioration !
