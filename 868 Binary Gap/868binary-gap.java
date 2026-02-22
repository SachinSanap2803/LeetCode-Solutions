class Solution {
    public int binaryGap(int n) {
        int maxDiff = 0;
        int lastPositionOfOne = -1;
        int position = 0;

        while(n > 0) {
            if((n & 1) == 1) {
                if(lastPositionOfOne != -1) {
                    maxDiff = Math.max(maxDiff, position - lastPositionOfOne);
                } 

                lastPositionOfOne = position;
            }
            
            n >>= 1;
            position++;
        }

        return maxDiff;
    }
} 