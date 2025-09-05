class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int maxCnt = -1;
        int row = 0;

        for(int i=0; i<m; i++) {
            int currCnt = 0;
            for(int j=0; j<n; j++) {
                currCnt += mat[i][j];
            }
            if(currCnt > maxCnt) {
                maxCnt = currCnt;
                row = i;
            }
        }

        int[] ans = new int[2];
        ans[0] = row;   ans[1] = maxCnt;
        return ans;
    }
}