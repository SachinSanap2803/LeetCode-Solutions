class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int n = moves.length();
        int leftMax = 0, rightMax = 0;

        for(char ch : moves.toCharArray()) {
            if(ch == 'L') {
                leftMax++;
                rightMax--;
            } else if(ch == 'R') {
                rightMax++;
                leftMax--;
            } else {
                leftMax++;
                rightMax++;
            }
        }

        return Math.max(leftMax, rightMax);
    }
}