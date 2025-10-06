package backtracking;

import java.util.Arrays;

public class Sudoku {

    public static void main(String[] args) {

        char [][] board = {{'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};

        Sudoku sudoku = new Sudoku();
        sudoku.solve(board);
        for(int i=0;i<9;i++){
            System.out.println(Arrays.toString(board[i]));
        }

    }


    public void solveSudoku(char[][] board) {
        solve(board);
    }


    public boolean solve(char [][] board){
        for(int i=0;i<9;i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char num = '1'; num <= '9'; num++) {
                        if (isSudokuValid(board, i, j, num)) {
                            board[i][j] = num;
                            if (solve(board)) {
                                return true;
                            }
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isSudokuValid(char[][] board, int row, int col, char num) {
        // row col
        for(int i=0;i<9;i++) {
            if (board[row][i] == num || board[i][col] == num) {
                return false;
            }
        }
        //3X3

        int rowBox = (row/3) *3;
        int colBox = (col/3) * 3;
        for(int k=0;k<3;k++){
            for(int j=0;j<3;j++){
                if(board[rowBox+k][colBox+j] == num){
                    return false;
                }
            }
        }
        return true;
    }
}
