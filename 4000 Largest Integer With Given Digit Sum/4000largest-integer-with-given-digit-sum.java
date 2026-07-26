class Solution {
    public int largestInteger(int n, int s) {
        if(s > 9 * n) return -1;
        if(s == 0) return 0;

        int remSum = s;
        StringBuilder sb = new StringBuilder();

        while(sb.length() < n) {
            int digit = Math.min(9, remSum);
            sb.append(digit);
            remSum -= digit;
        }

        return Integer.parseInt(sb.toString());
    }
} 