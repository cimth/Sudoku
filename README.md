Sudoku
======

## Introduction

This application lets the user create and solve 9x9 Sudoku puzzles interactively. 
Currently, there are given the following possibilities:

* Create 9x9 Sudoku puzzles via an algorithm
* Enter existing 9x9 Sudoku puzzles (e.g. from a puzzle magazine)
* Solve the Sudoku puzzles interactively
* Restart the current Sudoku puzzle
* Show the next solution step or the whole solution for the current Sudoku puzzle
* Print the current Sudoku puzzles
* Print multiple Sudoku puzzles with a selectable difficulty
* Adjust the font size for smaller or bigger numbers in the Sudoku puzzle
* Compare the current state of the Sudoku puzzle with the solution
* Import and export Sudoku puzzles (e.g. to continue playing later)

## Screenshot

![Screenshot](Screenshot.png)

__Notes to the GUI:__

* Predefined cells are printed bold.
* The value selector popup opens when clicking on an editable cell to choose or remove the value inside this cell.
* Red fields show that a value is used two times in a row, column or box and marks the affected cells as duplicates.
* Yellow fields show that the chosen value is not the correct one compared to the solution. 
  This behavior can be unchecked via the checkbox 
  _"Compare With Solution"_ below the board.
* Green printed values are inserted by the application after clicking on _"Solve Completely"_ or _"Next Step"_.

## Included dependencies

| Dependency            | Version |
|-----------------------|---------|
| Java                  | 17      |
| JUnit                 | 5.9.0   |
| Log4j                 | 2.18.0  |
| JAXB API              | 2.3.1   |
| JAXB Runtime          | 4.0.0   |
| Maven Compiler Plugin | 3.10.1  |
| Exec Maven Plugin     | 3.1.0   |
| Maven Assembly Plugin | 3.4.2   |
| Versions Maven Plugin | 2.11.0  |

## Structure:

The package `main` includes the `Start` class which is the entry point of the application.

The main logic of the application is handled inside the `controller` package. 
The single controllers create the GUI elements (which are placed in the `view` package) 
and the model elements (which are placed in the `model` packages). 
They also perform the synchronization between view and model so that view and model do not need to know each other.

To structure the logic when handling user inputs, separate classes are placed in the `eventHandling` package.
Those classes are used for the logical behaviors of the GUI elements and can be seen as part of the controllers.
Their separation from the `controller` package should make the responsibility of the different application elements 
more clear.
Thus, the modification of the Sudoku board is handled through the `CtrlBoard` in collaboration with the single affected
event handling classes.

The `computing` package contains classes e.g. for solving and creating the Sudoku puzzles.

Some helpful classes which may not be strictly limited to the logic of a Sudoku puzzle are placed inside the `utils` 
package. This package also includes the class `LanguageBundle` which is needed for supporting different languages for 
the user interface (right now the GUI is available in German and English).

## Build and start with Maven:

Run `mvn clean package exec:java`

## Build and start JAR:

1. Run `mvn clean package`
2. Run `java -jar ./target/Sudoku.jar`