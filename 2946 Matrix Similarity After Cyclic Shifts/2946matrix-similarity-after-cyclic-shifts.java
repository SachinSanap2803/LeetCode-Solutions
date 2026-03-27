// Brute force

// class Solution {
//     public boolean areSimilar(int[][] mat, int k) {
//         int m = mat.length;
//         int n = mat[0].length;

//         k = k % n;

//         int[][] grid = new int[m][n];
//         for(int i=0; i<m; i++) {
//             for(int j=0; j<n; j++) {
//                 grid[i][j] = mat[i][j];
//             }
//         }

//         int count = 0;

//         while(count < k) {
//             for(int i=0; i<m; i++) {
//                 if(i % 2 == 0) {
//                     int temp = grid[i][0];
//                     for(int j=1; j<n; j++) {
//                         grid[i][j-1] = grid[i][j];
//                     }
//                     grid[i][n-1] = temp;
//                 } else {
//                     int temp = grid[i][n-1];
//                     for(int j=0; j<n-1; j++) {
//                         grid[i][j+1] = grid[i][j];
//                     }
//                     grid[i][0] = temp;
//                 }
//             }
//             count++;
//         }

//         for(int i=0; i<m; i++) {
//             for(int j=0; j<n; j++) {
//                 if(mat[i][j] != grid[i][j]) {
//                     return false;
//                 }
//             }
//         }

//         return true;
//     }
// } 






// Optimal Solution

class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;

        k = k % n;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                int newCol;

                if(i % 2 == 0) {
                    newCol = (j + k) % n; 
                } else {
                    newCol = (j - k + n) % n;
                }

                if(mat[i][j] != mat[i][newCol]) {
                    return false;
                }
            }
        }

        return true;
    }
} 