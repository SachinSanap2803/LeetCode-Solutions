class Solution {
    public long removeZeros(long n) {
        String str = Long.toString(n);
        String ans = "";

        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i) != '0') {
                ans += str.charAt(i);
            }
        }

        return Long.parseLong(ans);
    }
} 