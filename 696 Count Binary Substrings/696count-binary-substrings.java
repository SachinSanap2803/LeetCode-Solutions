// Brute force

// class Solution {
//     public int countBinarySubstrings(String s) {
//         int n = s.length();
//         int count = 0;

//         for(int i=0; i<n; i++) {
//             int zeroCnt = 0, oneCnt = 0;
//             int changes = 0;

//             for(int j=i; j<n; j++) {
//                 if(j > i && s.charAt(j) != s.charAt(j-1)) changes++;

//                 if(changes > 1) break;

//                 if(s.charAt(j) == '0') zeroCnt++;
//                 else oneCnt++;

//                 if(zeroCnt == oneCnt) count++;
//             }
//         }

//         return count;
//     }
// } 







// Optimal Solution

class Solution {
    public int countBinarySubstrings(String s) {
        int n = s.length();
        int count = 0;
        int prev = 0, curr = 1;

        for(int i=1; i<n; i++) {
            if(s.charAt(i) == s.charAt(i-1)) {
                curr++;
            } else {
                count += Math.min(prev, curr);
                prev = curr;
                curr = 1;
            }
        }

        count += Math.min(prev, curr);
        return count;
    }
} 