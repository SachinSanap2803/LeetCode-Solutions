class Solution {
    public boolean isPalindromic(String s) {
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            int n = (int) (ch);

            for(int j=7; j>=0; j--) {
                sb.append((n >> j) & 1);
            }
        }

        int start = 0, end = sb.length()-1;

        while(start < end) {
            if(sb.charAt(start) != sb.charAt(end)) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }
} 