// class Solution {
//     public List<List<String>> solveNQueens(int n) {
//         List<List<String>> result = new ArrayList<>();

//         char[][] board = new char[n][n];

//         for(int i=0; i<n; i++) {
//             Arrays.fill(board[i], '.');
//         }

//         buildBoard(board, 0, n, result);

//         return result;
//     }

//     public void buildBoard(char[][] board, int row, int size, List<List<String>> result) {
//         if(row == size) {
//             result.add(construct(board));
//             return;
//         }

//         for(int col=0; col<size; col++) {
//             if(isSafe(board, row, col)) {
//                 board[row][col] = 'Q';
//                 buildBoard(board, row+1, size, result);
//                 board[row][col] = '.';
//             }
//         }
//     }

//     public boolean isSafe(char[][] board, int row, int col) {
//         // Upper Left Check
//         for(int i=row-1, j=col-1; i>=0 && j>=0; i--, j--) {
//             if(board[i][j] == 'Q') {
//                 return false;
//             }
//         }

//         // Upper Check
//         for(int i=row-1; i>=0; i--) {
//             if(board[i][col] == 'Q') {
//                 return false;
//             }
//         }

//         // Upper Right Check
//         for(int i=row-1, j=col+1; i>=0 && j<board.length; i--, j++) {
//             if(board[i][j] == 'Q') {
//                 return false;
//             }
//         }

//         return true;
//     }

//     private List<String> construct(char[][] board) {
//         List<String> res = new ArrayList<>();
//         for(char[] row: board) {
//             res.add(new String(row));
//         }

//         return res;
//     }
// } 






class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();

        char[][] board = new char[n][n];
        int[] upperRow = new int[n];
        int[] diagonalUpperRight = new int[2*n-1];
        int[] diagonalUpperLeft = new int[2*n-1];

        for(int i=0; i<n; i++) {
            Arrays.fill(board[i], '.');
        }

        buildBoard(board, 0, n, result, upperRow, diagonalUpperRight, diagonalUpperLeft);

        return result;
    }

    public void buildBoard(char[][] board, int row, int size, List<List<String>> result, int[] upperRow, int[] diagonalUpperRight, int[] diagonalUpperLeft) {
        if(row == size) {
            result.add(construct(board));
            return;
        }

        for(int col=0; col<size; col++) {
            if(upperRow[col] == 0 && diagonalUpperRight[row+col] == 0 && diagonalUpperLeft[size-1+col-row] == 0) {
                board[row][col] = 'Q';
                upperRow[col] = 1;
                diagonalUpperRight[row+col] = 1;
                diagonalUpperLeft[size-1+col-row] = 1;

                buildBoard(board, row+1, size, result, upperRow, diagonalUpperRight, diagonalUpperLeft);

                board[row][col] = '.';
                upperRow[col] = 0;
                diagonalUpperRight[row+col] = 0;
                diagonalUpperLeft[size-1+col-row] = 0;
            }
        }
    }

    private List<String> construct(char[][] board) {
        List<String> res = new ArrayList<>();
        for(char[] row: board) {
            res.add(new String(row));
        }

        return res;
    }
} 