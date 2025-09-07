// Brute force

// class Solution {
//     public int[] findPeakGrid(int[][] mat) {
//         int m = mat.length;
//         int n = mat[0].length;
        
//         for(int i=0; i<m; i++) {
//             for(int j=0; j<n; j++) {
//                 boolean up = (i == 0) || (mat[i][j] > mat[i-1][j]);
//                 boolean down = (i == m-1) || (mat[i][j] > mat[i+1][j]);
//                 boolean left = (j == 0) || (mat[i][j] > mat[i][j-1]);
//                 boolean right = (j == n-1) || (mat[i][j] > mat[i][j+1]);

//                 if(up && down && left && right) {
//                     return new int[]{i, j};
//                 }
//             }
//         }

//         return new int[]{-1, -1};
//     }
// } 






// Optimal Solution

class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        
        int low = 0, high = n-1;
        while(low <= high) {
            int mid = low + (high - low)/2;
            int maxRowIdx = maxElement(mat, m, n, mid);

            int left = (mid-1 >= 0) ? mat[maxRowIdx][mid-1] : -1;
            int right = (mid+1 < n) ? mat[maxRowIdx][mid+1] : -1;

            if(mat[maxRowIdx][mid] > left && mat[maxRowIdx][mid] > right) {
                return new int[] {maxRowIdx, mid};
            } else if(mat[maxRowIdx][mid] < left) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return new int[] {-1, -1};
    }

    public int maxElement(int[][] mat, int m, int n, int mid) {
        int maxVal = -1;
        int idx = -1;

        for(int i=0; i<m; i++) {
            if(mat[i][mid] > maxVal) {
                maxVal = mat[i][mid];
                idx = i;
            }
        }

        return idx;
    }
} 