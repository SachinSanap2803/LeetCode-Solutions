class Solution {
    public int maxDepth(String s) {
        int currCnt = 0;
        int maxCnt = 0;

        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '(') {
                currCnt++;
                if(currCnt > maxCnt) {
                    maxCnt = currCnt;
                }
            }
            if(s.charAt(i) == ')') {
                currCnt--;
            }
        }

        return maxCnt;
    }
} 