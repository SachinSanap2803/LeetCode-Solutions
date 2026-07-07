// Brute force

// class Solution {
//     public long sumAndMultiply(int n) {
//         StringBuilder sb = new StringBuilder();
        
//         while(n > 0) {
//             char rem = (char) ((n % 10) + '0');

//             if(rem != '0') {
//                 sb.insert(0, rem);
//             }

//             n /= 10;
//         }

//         long sum = 0;

//         for(int i=0; i<sb.length(); i++) {
//             sum += sb.charAt(i) - '0';
//         }

//         if(sb.length() == 0) return 0;

//         Long num = Long.parseLong(sb.toString());

//         return sum * num;
//     }
// } 





// Optimal Solution

class Solution {
    public long sumAndMultiply(int n) {
        long num = 0;
        long sum = 0;
        long place = 1;

        while(n > 0) {
            int digit = n % 10;

            if(digit != 0) {
                num += digit * place;
                place *= 10;
                sum += digit;
            }

            n /= 10;
        }

        return num * sum;
    }
} 