class Solution {
    public int minInsertions(String s) {
        int closing = 0;
        int ans = 0;

        for(char ch : s.toCharArray()) {
            if(ch == '(') {
                closing += 2;

                if(closing % 2 != 0) {
                    closing--;
                    ans++;
                }
            } else {
                closing--;

                if(closing < 0) {
                    ans++;
                    closing = 1;
                }
            }
        }

        return ans + closing;
    }
} 