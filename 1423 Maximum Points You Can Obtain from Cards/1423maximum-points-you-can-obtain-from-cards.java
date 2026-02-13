class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int maxSum = 0;
        int lSum = 0, rSum = 0;

        for(int i=0; i<k; i++) {
            lSum += cardPoints[i];
        }

        maxSum = lSum;
        int rightIdx = n-1;

        for(int i=k-1; i>=0; i--) {
            lSum -= cardPoints[i];
            rSum += cardPoints[rightIdx--];

            maxSum = Math.max(maxSum, lSum + rSum);
        }

        return maxSum;
    }
} 