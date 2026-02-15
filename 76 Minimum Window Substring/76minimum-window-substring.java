// Brute force

// class Solution {
//     public String minWindow(String s, String t) {
//         int n = s.length();
//         int m = t.length();
//         int minLen = Integer.MAX_VALUE;
//         int sIdx = -1;

//         for(int i=0; i<n; i++) {
//             int[] hash = new int[256];
//             int count = 0;

//             for(int j=0; j<m; j++) {
//                 hash[t.charAt(j)]++;
//             }

//             for(int j=i; j<n; j++) {
//                 if(hash[s.charAt(j)] > 0) {
//                     count++;
//                     hash[s.charAt(j)]--;

//                     if(count == m) {
//                         if(j-i+1 < minLen) {
//                             minLen = j-i+1;
//                             sIdx = i;
//                             break;
//                         }
//                     }
//                 }
//             }
//         }

//         if(sIdx == -1) {
//             return "";
//         }

//         return s.substring(sIdx, sIdx + minLen);
//     }
// } 








// Optimal Solution

class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        int minLen = Integer.MAX_VALUE;
        int sIdx = -1;

        int[] hash = new int[256];
        
        for(int i=0; i<m; i++) {
            hash[t.charAt(i)]++;
        }

        int l = 0, r = 0, count = 0;

        while(r < n) {
            if(hash[s.charAt(r)] > 0) {
                count++;
            }

            hash[s.charAt(r)]--;

            while(count == m) {
                if(r-l+1 < minLen) {
                    minLen = r-l+1;
                    sIdx = l;
                }

                hash[s.charAt(l)]++;
                if(hash[s.charAt(l)] > 0) {
                    count--;
                }

                l++;
            }

            r++;
        }

        return sIdx == -1 ? "" : s.substring(sIdx, sIdx + minLen);
    }
} 