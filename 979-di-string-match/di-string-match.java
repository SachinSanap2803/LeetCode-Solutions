class Solution {
    public int[] diStringMatch(String s) {
        int n = s.length();
        int[] ans = new int[n+1];
        int low = 0, high = n;

        for(int i=0; i<n; i++) {
            char ch = s.charAt(i);

            if(ch == 'I') {
                ans[i] = low++;
            } else {
                ans[i] = high--;
            }
        }

        ans[n] = low;

        return ans;
    }
} 