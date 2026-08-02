// Brute force

// class Solution {
//     public int countValidPrefixes(String s) {
//         int n = s.length();
//         int[] cnt1 = new int[n];
//         int[] cnt0 = new int[n];

//         if(s.charAt(0) - '0' == 0) cnt0[0] = 1;
//         else cnt1[0] = 1;

//         for(int i=1; i<n; i++) {
//             int num = s.charAt(i) - '0';

//             if(num == 0) {
//                 cnt0[i] = cnt0[i-1] + 1;
//                 cnt1[i] = cnt1[i-1];
//             } else {
//                 cnt1[i] = cnt1[i-1] + 1;
//                 cnt0[i] = cnt0[i-1];
//             }
//         }

//         int ans = 0;

//         for(int i=0; i<n; i++) {
//             if(cnt0[i] == cnt1[i]) {
//                 ans++;
//             } else if(Math.abs(cnt0[i] - cnt1[i]) == 1) {
//                 ans++;
//             }
//         }

//         return ans;
//     }
// } 





// Optimal Solution

class Solution {
    public int countValidPrefixes(String s) {
        int zero = 0, one = 0;
        int ans = 0;

        for(char ch : s.toCharArray()) {
            if(ch == '0') zero++;
            else one++;

            if(Math.abs(one - zero) <= 1) {
                ans++;
            }
        }

        return ans;
    }
} 