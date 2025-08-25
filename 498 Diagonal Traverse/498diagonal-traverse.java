class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] arr = new int[m * n];
        int row = 0, col = 0;
        int idx = 0;

        while (idx < m * n) {
            while (row >= 0 && col < n && idx < m * n) {
                arr[idx++] = mat[row--][col++];
            }
            row++;

            if (col >= n) {
                col = n - 1;
                row++;
            }

            while (row < m && col >= 0 && idx < m * n) {
                arr[idx++] = mat[row++][col--];
            }
            col++;

            if (row >= m) {
                row = m - 1;
                col++;
            }
        }

        return arr;
    }
} 