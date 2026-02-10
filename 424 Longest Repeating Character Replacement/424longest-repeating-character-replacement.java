// Brute force

// class Solution {
//     public int characterReplacement(String s, int k) {
//         int n = s.length();
//         int maxi = 0;

//         for(int i=0; i<n; i++) {
//             int[] freq = new int[26];
//             int maxFreq = 0;
//             for(int j=i; j<n; j++) {
//                 freq[s.charAt(j) - 'A']++;
//                 maxFreq = Math.max(maxFreq, freq[s.charAt(j) - 'A']);

//                 int changes = (j-i+1) - maxFreq;
//                 if(changes <= k) {
//                     maxi = Math.max(maxi, j-i+1);
//                 } else {
//                     break;
//                 }
//             }
//         }

//         return maxi;
//     }
// } 






// Optimal Solution

class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int maxi = 0;
        int l=0, r=0;
        int[] freq = new int[26];
        int maxFreq = 0;

        while(r < n) {
            freq[s.charAt(r) - 'A']++;
            maxFreq = Math.max(maxFreq, freq[s.charAt(r) - 'A']);

            int changes = (r-l+1) - maxFreq;
            if(changes > k) {
                freq[s.charAt(l) - 'A']--;
                l++;
            }

            if(changes <= k) {
                maxi = Math.max(maxi, r-l+1);
            }

            r++;
        }

        return maxi;
    }
} 