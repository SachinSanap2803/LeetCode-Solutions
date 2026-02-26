// Brute force

// class Solution {
//     public int numSteps(String s) {
//         int count = 0;
//         int n = 0;

//         for(int i=0; i<s.length(); i++) {
//             n = (2 * n) + (s.charAt(i) - '0');
//         }

//         while(n != 1) {
//             if((n & 1) == 1) {
//                 n += 1;
//             } else {
//                 n /= 2;
//             }

//             count++;
//         }

//         return count;
//     }
// } 






// Optimal Solution

class Solution {
    public int numSteps(String s) {
        int count = 0;
        int carry = 0;

        for(int i=s.length()-1; i>0; i--) {
            int bit = s.charAt(i) - '0';

            if(bit + carry == 1) {
                count += 2;
                carry = 1;
            } else {
                count += 1;
            }
        }

        return count + carry;
    }
} 