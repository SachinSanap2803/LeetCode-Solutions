// Brute force

// class Solution {
//     public int findComplement(int num) {
//         StringBuilder sb = new StringBuilder();

//         while(num > 0) {
//             sb.append(num % 2);
//             num /= 2;
//         }

//         sb = sb.reverse();

//         for(int i=0; i<sb.length(); i++) {
//             if(sb.charAt(i) == '1') {
//                 sb.setCharAt(i, '0');
//             } else {
//                 sb.setCharAt(i, '1');
//             }
//         }

//         int ans = 0, idx = 0;

//         for(int i=sb.length()-1; i>=0; i--) {
//             ans += (sb.charAt(i) - '0') * Math.pow(2, idx++);
//         }

//         return ans;
//     }
// } 






// Optimal Solution

class Solution {
    public int findComplement(int num) {
        int mask = 1;

        while(mask < num) {
            mask = (mask << 1) | 1;
        }

        return num ^ mask;
    }
} 