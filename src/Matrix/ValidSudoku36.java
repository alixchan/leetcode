package Matrix;

public class ValidSudoku36 {

    public static boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            boolean[] rowCheck = new boolean[9];
            boolean[] colCheck = new boolean[9];
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    if (rowCheck[num]) {
                        return false;
                    }
                    rowCheck[num] = true;
                }
                if (board[j][i] != '.') {
                    int num = board[j][i] - '1';
                    if (colCheck[num]) {
                        return false;
                    }
                    colCheck[num] = true;
                }
            }
        }

        for (int block = 0; block < 9; block++) {
            boolean[] subgridCheck = new boolean[9];
            int startRow = (block / 3) * 3;
            int startCol = (block % 3) * 3;
            for (int i = startRow; i < startRow + 3; i++) {
                for (int j = startCol; j < startCol + 3; j++) {
                    if (board[i][j] != '.') {
                        int num = board[i][j] - '1';
                        if (subgridCheck[num]) {
                            return false;
                        }
                        subgridCheck[num] = true;
                    }
                }
            }
        }

        return true;
    }
}
