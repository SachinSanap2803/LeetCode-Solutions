// class Solution {
//     int count = 0;

//     public int totalNQueens(int n) {
//         char[][] board = new char[n][n];

//         for(int i=0; i<n; i++) {
//             Arrays.fill(board[i], '.');
//         }

//         buildBoard(board, 0, n);

//         return count;
//     }

//     public void buildBoard(char[][] board, int row, int size) {
//         if(row == size) {
//             count++;
//             return;
//         }

//         for(int col=0; col<size; col++) {
//             if(isSafe(board, row, col)) {
//                 board[row][col] = 'Q';
//                 buildBoard(board, row+1, size);
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
// } 







class Solution {
    int count = 0;

    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        int[] upperRow = new int[n];
        int[] diagonalUpperRight = new int[2*n-1];
        int[] diagonalUpperLeft = new int[2*n-1];

        for(int i=0; i<n; i++) {
            Arrays.fill(board[i], '.');
        }

        buildBoard(board, 0, n, upperRow, diagonalUpperRight, diagonalUpperLeft);

        return count;
    }

    public void buildBoard(char[][] board, int row, int size, int[] upperRow, int[] diagonalUpperRight, int[] diagonalUpperLeft) {
        if(row == size) {
            count++;
            return;
        }

        for(int col=0; col<size; col++) {
            if(upperRow[col] == 0 && diagonalUpperRight[row+col] == 0 && diagonalUpperLeft[size-1+col-row] == 0) {
                board[row][col] = 'Q';
                upperRow[col] = 1;
                diagonalUpperRight[row+col] = 1;
                diagonalUpperLeft[size-1+col-row] = 1;

                buildBoard(board, row+1, size, upperRow, diagonalUpperRight, diagonalUpperLeft);

                board[row][col] = '.';
                upperRow[col] = 0;
                diagonalUpperRight[row+col] = 0;
                diagonalUpperLeft[size-1+col-row] = 0;
            }
        }
    }
} 