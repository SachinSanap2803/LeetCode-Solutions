class Solution {
    public int countRotations(String s, int k) {
        int n = s.length();
        int cnt = 0;

        for(int i=0; i<n; i++) {
            int score = 0;

            for(int j=i; (j+1) % n != i; j++) {
                if(s.charAt(j % n) == s.charAt((j+1) % n)) {
                    score++;
                }
            }

            if(score == k) {
                cnt++;
            }
        }

        return cnt;
    }
} 