// Brute force

// class Solution {
//     public int numSpecial(int[][] mat) {
//         int count = 0;
//         int m = mat.length;
//         int n = mat[0].length;

//         for(int i=0; i<m; i++) {
//             for(int j=0; j<n; j++) {
//                 if(mat[i][j] == 1) {
//                     if(isRowValid(mat, i) && isColValid(mat, j)) {
//                         count++;
//                     }
//                 }
//             }
//         }

//         return count;
//     }

//     private boolean isRowValid(int[][] mat, int row) {
//         int countOne = 0;
//         for(int i=0; i<mat[0].length; i++) {
//             if(mat[row][i] == 1) {
//                 countOne++;
//             }
//         }

//         return countOne == 1;
//     }

//     private boolean isColValid(int[][] mat, int col) {
//         int countOne = 0;
//         for(int i=0; i<mat.length; i++) {
//             if(mat[i][col] == 1) {
//                 countOne++;
//             }
//         }

//         return countOne == 1;
//     }
// } 







// Optimal Solution

class Solution {
    public int numSpecial(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[] row = new int[m];
        int[] col = new int[n];

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(mat[i][j] == 1) {
                    row[i]++;
                    col[j]++;
                }
            }
        }

        int count = 0;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(mat[i][j] == 1 && row[i] == 1 && col[j] == 1) {
                    count++;
                }
            }
        }

        return count;
    }
} 