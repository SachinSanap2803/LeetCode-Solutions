class Solution {
    public boolean scoreBalance(String s) {
        int totalSum = 0;
        for(char ch : s.toCharArray()) {
            totalSum += (ch - 'a' + 1);
        }

        int leftSum = 0;
        for(int i=0; i<s.length(); i++) {
            leftSum += s.charAt(i) - 'a' + 1;
            int rightSum = totalSum - leftSum;

            if(leftSum == rightSum) return true;
        }

        return false;
    }
} 