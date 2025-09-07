// Brute force

// class Solution {
//     public boolean searchMatrix(int[][] matrix, int target) {
//         int m = matrix.length;
//         int n = matrix[0].length;

//         for(int i=0; i<m; i++) {
//             for(int j=0; j<n; j++) {
//                 if(matrix[i][j] == target) {
//                     return true;
//                 }
//             }
//         }

//         return false;
//     }
// } 




// Better Solution

// class Solution {
//     public boolean searchMatrix(int[][] matrix, int target) {
//         int m = matrix.length;
//         int n = matrix[0].length;

//         for(int i=0; i<m; i++) {
//             if(bs(matrix[i], target)) {
//                 return true;
//             }
//         }

//         return false;
//     }

//     public boolean bs(int[] mat, int target) {
//         int low = 0;
//         int high = mat.length-1;

//         while(low <= high) {
//             int mid = low + (high - low)/2;
//             if(mat[mid] == target) {
//                 return true;
//             } else if(mat[mid] < target) {
//                 low = mid + 1;
//             } else {
//                 high = mid - 1;
//             }
//         }

//         return false;
//     }
// } 






// Optimal Solution

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int row = 0, col = n-1;

        while(row < m && col >= 0) {
            if(matrix[row][col] == target) {
                return true;
            } else if(matrix[row][col] < target) {
                row++;
            } else {
                col--;
            }
        }

        return false;
    }
} 