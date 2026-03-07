class Solution {
    public int minFlips(String s) {
        int n = s.length();
        String t = s + s;

        int flip1 = 0;     // flips needed considering string started with 0
        int flip2 = 0;     // flips needed considering string started with 1
        int ans = Integer.MAX_VALUE;

        for(int i=0; i<t.length(); i++) {
            char ch = t.charAt(i);

            if(ch != (i % 2 == 0 ? '0' : '1')) flip1++;
            if(ch != (i % 2 == 0 ? '1' : '0')) flip2++;

            if(i >= n) {
                char prev = t.charAt(i-n);

                if(prev != ((i-n) % 2 == 0 ? '0' : '1')) flip1--;
                if(prev != ((i-n) % 2 == 0 ? '1' : '0')) flip2--;
            }

            if(i >= n-1) {
                ans = Math.min(ans, Math.min(flip1, flip2));
            }
        }

        return ans;
    }
} 