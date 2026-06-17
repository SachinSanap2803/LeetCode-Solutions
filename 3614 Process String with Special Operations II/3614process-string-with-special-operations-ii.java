// Brute force

// class Solution {
//     public char processStr(String s, long k) {
//         StringBuilder sb = new StringBuilder();
        
//         for(char ch : s.toCharArray()) {
//             if(ch >= 'a' && ch <= 'z') {
//                 sb.append(ch);
//             } else if(ch == '*') {
//                 if(sb.length() > 0) {
//                     sb.deleteCharAt(sb.length()-1);
//                 }
//             } else if(ch == '#') {
//                 int n = sb.length();
//                 for(int i=0; i<n; i++) {
//                     sb.append(sb.charAt(i));
//                 }
//             } else {
//                 sb.reverse();
//             }
//         }

//         int len = sb.length();
        
//         return (k >= len) ? '.' : sb.charAt((int) k);
//     }
// } 






// Optimal Solution

class Solution {
    public char processStr(String s, long k) {
        int n = s.length();
        long[] len = new long[n+1];

        for(int i=0; i<n; i++) {
            char ch = s.charAt(i);

            if(ch >= 'a' && ch <= 'z') {
                len[i+1] = len[i] + 1;
            } else if(ch == '*') {
                len[i+1] = Math.max(0, len[i]-1);
            } else if(ch == '#') {
                len[i+1] = Math.min(Long.MAX_VALUE/2, len[i] * 2);
            } else {
                len[i+1] = len[i];
            }
        }

        if(k >= len[n]) {
            return '.';
        }

        for(int i=n-1; i>=0; i--) {
            char ch = s.charAt(i);

            if(ch >= 'a' && ch <= 'z') {
                if(k == len[i]) {
                    return ch;
                }
            } else if(ch == '*') {
                // backward : length before deletion was len[i]
            } else if(ch == '#') {
                long half = len[i];

                if(k >= half) {
                    k -= half;
                }
            } else {
                if(len[i] > 0) {
                    k = len[i]-1-k;
                }
            }
        }

        return '.';
    }
} 