
package Model;


public class Valida {
    public static boolean isSolvableSudoku(int[][] sudoku) {
    for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
            if (sudoku[i][j] == 0) {
                boolean[] possibilities = new boolean[9];

                // check row
                for (int k = 0; k < 9; k++) {
                    if (sudoku[i][k] != 0) {
                        possibilities[sudoku[i][k] - 1] = true;
                    }
                }

                // check column
                for (int k = 0; k < 9; k++) {
                    if (sudoku[k][j] != 0) {
                        possibilities[sudoku[k][j] - 1] = true;
                    }
                }

                // check box
                int boxRow = i / 3 * 3;
                int boxCol = j / 3 * 3;
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        if (sudoku[boxRow + k][boxCol + l] != 0) {
                            possibilities[sudoku[boxRow + k][boxCol + l] - 1] = true;
                        }
                    }
                }

                boolean isSolvable = false;
                for (int k = 0; k < 9; k++) {
                    if (!possibilities[k]) {
                        isSolvable = true;
                        break;
                    }
                }

                if (!isSolvable) {
                    return false;
                }
            }
        }
    }

    return true;
}
}
