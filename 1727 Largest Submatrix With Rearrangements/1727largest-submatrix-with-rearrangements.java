class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[] heights = new int[n];
        int maxArea = 0;

        for(int row = 0; row < m; row++) {
            for(int col = 0; col < n; col++) {
                if(matrix[row][col] == 1) {
                    heights[col] += 1;
                } else {
                    heights[col] = 0;
                }
            }

            int[] sorted = heights.clone();
            Arrays.sort(sorted);

            for(int i=0; i<n; i++) {
                int height = sorted[n-1-i];
                int width = i+1;

                maxArea = Math.max(maxArea, height * width);
            }
        }

        return maxArea;
    }
} 