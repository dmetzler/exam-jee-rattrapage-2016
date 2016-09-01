# Examen JEE 01/02/2016

## Modalités de rendu : 1 point

Pour rendre votre travail, vous devrez :

 * Implémenter les différentes méthodes demandées
 * Modifier dans le fichier `pom.xml` le nom de l'artifactId sous la forme suivante :

 		<artifactId>rattrapage-exam-JEE-2016-NOM-PRENOM</artifactid>

 	Remplacer les espaces et tout caractère non alphanumérique dans le nom et prénom par un `-`. Par exemple : `Gérard D'Orimont de Haute Cloque` donnera :

	 	<artifactId>exam-JEE-2016-D-ORIMONT-DE-HAUTE-CLOQUE-GERARD</artifactid>

 * Zipper le répertoire de travail sans le répertoire `target` et renommer le fichier :

 		rattrapage-exam-JEE-2016-NOM-PRENOM.zip

 * Envoyer le fichier zip à `dmetzler@gmail.com` avec comme sujet `Rattrapage Exam JEE 2016 : Nom Prénom`


## Première partie : TDD sur 10 points


Dans cette première partie, on développera une librairie permettant gérer les cellules d'un tableur ainsi que d'implémenter un mécanisme simple de calcul de formule.

Une librairie de tableur doit permette de récupérer et fixer les valeurs de cellules pour un adresse donnée. Les adresse sont de type `A1`, `B4` etc...

Une cellule pouvant être parsée comme un `Integer` est une cellule de type `NUMBER`. Une cellule commençant par `=` est une cellule de type `FORMULA`, les autres sont de type `TEXT`

Pour simplifier l'évaluation des formules, on ne traitera que deux cas :

  * l'addition de deux cellules, par exemple : `=A1 + A2`
  * la soustraction de deux cellules, par exemple : `=A2 -A1`

### Tests

Vous disposez dans le projet Maven de trois classes:

 * `Grid` : le contrat que doit suivre la grille du tableur, cette interface ne doit pas être modifiée. C'est dans cette interface que vous trouverez la documentation des méthodes que vous devrez implémenter.
 * `GridImpl` : l'implémentation de l'interface précédente que vous allez coder.
 * `CellType` : une énumération pour les types de cellules
 * `GridTest` : la classe contenant des méthodes de test vides.

En prenant un test à la fois, implémenter le corps de celui-ci en fonction de la description contenue dans la javadoc des différentes fonctions de test.

Compléter ensuite `GridImpl` pour que le test passe, puis passer au test suivant.

### Indications

Un tableau à double entrées n'est pas forcément l'implémentation la plus simple pour la grille. Etant donné que l'on cherche avant tout à récupérer des valeurs pour une adresse donnée, une `Map` pourrait être plus adaptée.




## Deuxième partie : API REST sur 10 points

A l'aide d'une servlet, on exposera la librairie précédente pour pouvoir afficher les cellules d'un tableur.

Pour cet exercice, vous disposez de la classe `GridServletTest` : une classe de test déjà remplie qui doit vous aider à valider votre servlet.

Suivre les instructions présentes dans la Javadoc de chaque test. Le harnais de test (`JettyHarness`) lance toutes les servlets correctement configurées dans un micro container pendant le test.


