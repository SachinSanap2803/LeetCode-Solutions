// 1] Brute force

// class Solution {
//     public void setZeroes(int[][] matrix) {
//         int m = matrix.length;
//         int n = matrix[0].length;

//         for(int i=0; i<m; i++) {
//             for(int j=0; j<n; j++) {
//                 if(matrix[i][j] == 0) {
//                     markRow(i, n, matrix);
//                     markCol(j, m, matrix);
//                 }
//             }
//         }

//         for(int i=0; i<m; i++) {
//             for(int j=0; j<n; j++) {
//                 if(matrix[i][j] == -1) {
//                     matrix[i][j] = 0;
//                 }
//             }
//         }
//     }

//     public void markRow(int i, int n, int[][] matrix) {
//         for(int j=0; j<n; j++) {
//             if(matrix[i][j] != 0) {
//                 matrix[i][j] = -1;
//             }
//         }
//     }

//     public void markCol(int j, int m, int[][] matrix) {
//         for(int i=0; i<m; i++) {
//             if(matrix[i][j] != 0) {
//                 matrix[i][j] = -1;
//             }
//         }
//     }
// } 



// 2] Better approach

// class Solution {
//     public void setZeroes(int[][] matrix) {
//         int m = matrix.length;
//         int n = matrix[0].length;

//         int[] row = new int[m];
//         int[] col = new int[n];

//         for(int i=0; i<m; i++) {
//             for(int j=0; j<n; j++) {
//                 if(matrix[i][j] == 0) {
//                     row[i] = 1;
//                     col[j] = 1;
//                 }
//             }
//         }

//         for(int i=0; i<m; i++) {
//             for(int j=0; j<n; j++) {
//                 if(row[i] == 1 || col[j] == 1) {
//                     matrix[i][j] = 0;
//                 }
//             }
//         }
//     }
// } 




// 3] Optimal approach

class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int col0 = 1;

        // int[] row = new int[m];        -> matrix[..][0]
        // int[] col = new int[n];        -> matrix[0][..]

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(matrix[i][j] == 0) {
                    // mark the i-th row
                    matrix[i][0] = 0;
                    
                    // mark the j-th col
                    if(j != 0)
                        matrix[0][j] = 0;
                    else
                        col0 = 0;
                }
            }
        }

        for(int i=1; i<m; i++) {
            for(int j=1; j<n; j++) {
                if(matrix[i][j] != 0) {
                    // check for col & row
                    if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }

        if(matrix[0][0] == 0) {
            for(int j=0; j<n; j++) {
                matrix[0][j] = 0;
            }
        }

        if(col0 == 0) {
            for(int i=0; i<m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
} 