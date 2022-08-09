package computing;

import model.Cell;
import model.Sudoku;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SudokuGeneratorTest {

    /*==================================================*
     *==       generateEmptyAndNonEditableSudoku()    ==*
     *==================================================*/

    @Test
    public void generateEmptyAndNonEditableSudoku_ReturnEmptyAndNonEditableSudoku() {

        // create sudoku
        Sudoku sudoku = SudokuGenerator.generateEmptyAndNonEditableSudoku();

        // check if every board cell is empty (value == 0) and not editable
        Cell currentCell;
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                currentCell = sudoku.getBoard()[row][col];
                Assertions.assertFalse(currentCell.isEditable());
                Assertions.assertEquals(0, currentCell.getValue());
            }
        }

    }

    /*==================================================*
     *==        generateEmptyAndEditableSudoku()      ==*
     *==================================================*/

    @Test
    public void generateEmptyAndEditableSudoku_ReturnEmptyAndEditableSudoku() {

        // create sudoku
        Sudoku sudoku = SudokuGenerator.generateEmptyAndEditableSudoku();

        // check if every board cell is empty (value == 0) and editable
        Cell currentCell;
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                currentCell = sudoku.getBoard()[row][col];
                Assertions.assertTrue(currentCell.isEditable());
                Assertions.assertEquals(0, currentCell.getValue());
            }
        }

    }
}
