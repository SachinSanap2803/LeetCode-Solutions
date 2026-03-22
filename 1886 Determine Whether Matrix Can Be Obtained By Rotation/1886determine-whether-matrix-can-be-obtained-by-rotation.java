// Brute force

// class Solution {
//     public boolean findRotation(int[][] mat, int[][] target) {
//         for(int k=0; k<4; k++) {
//             if(isEqual(mat, target)) return true;
//             mat = rotate(mat);
//         }

//         return false;
//     }

//     private int[][] rotate(int[][] mat) {
//         int m = mat.length;
//         int[][] newMat = new int[m][m];

//         for(int i=0; i<m; i++) {
//             for(int j=0; j<m; j++) {
//                 newMat[j][m-i-1] = mat[i][j]; 
//             }
//         }

//         return newMat;
//     }

//     private boolean isEqual(int[][] a, int[][] b) {
//         int m = a.length;

//         for(int i=0; i<m; i++) {
//             for(int j=0; j<m; j++) {
//                 if(a[i][j] != b[i][j]) return false;
//             }
//         }

//         return true;
//     }
// } 





// Better Solution

// class Solution {
//     public boolean findRotation(int[][] mat, int[][] target) {
//         for(int k=0; k<4; k++) {
//             if(isEqual(mat, target)) return true;
//             rotateInPlace(mat);
//         }

//         return false;
//     }  
    
//     private void rotateInPlace(int[][] mat) {
//         int m = mat.length;

//         // transpose
//         for(int i=0; i<m; i++) {
//             for(int j=i; j<m; j++) {
//                 int temp = mat[i][j];
//                 mat[i][j] = mat[j][i];
//                 mat[j][i] = temp;
//             }
//         }

//         // reverse each rows
//         for(int i=0; i<m; i++) {
//             for(int j=0; j<m/2; j++) {
//                 int temp = mat[i][j];
//                 mat[i][j] = mat[i][m-j-1];
//                 mat[i][m-j-1] = temp;
//             }
//         }
//     }

//     private boolean isEqual(int[][] a, int[][] b) {
//         int m = a.length;

//         for(int i=0; i<m; i++) {
//             for(int j=0; j<m; j++) {
//                 if(a[i][j] != b[i][j]) {
//                     return false;
//                 }
//             }
//         }

//         return true;
//     }
// } 





// Optimal Solution

class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length;

        boolean r0 = true, r90 = true, r180 = true, r270 = true;

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(mat[i][j] != target[i][j]) r0 = false;
                
                if(mat[i][j] != target[j][n-i-1]) r90 = false;

                if(mat[i][j] != target[n-i-1][n-j-1]) r180 = false;

                if(mat[i][j] != target[n-j-1][i]) r270 = false;
            }
        }

        return r0 | r90 | r180 | r270;
    }  
} 