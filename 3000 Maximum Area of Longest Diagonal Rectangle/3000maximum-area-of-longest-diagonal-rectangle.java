class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int maxDiagonal = 0;
        int maxArea = 0;

        for(int[] dimension : dimensions) {
            int a = dimension[0];
            int b = dimension[1];
            int diagonal = (a * a) + (b * b);

            if(diagonal > maxDiagonal) {
                maxDiagonal = diagonal;
                maxArea = a * b;
            } else if(diagonal == maxDiagonal) {
                maxArea = Math.max(maxArea, a * b);
            }
        }

        return maxArea;
    }
} 