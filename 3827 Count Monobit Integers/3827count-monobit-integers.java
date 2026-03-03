// Brute force

// class Solution {
//     public int countMonobit(int n) {
//         int count = 0;
//         for(int i=0; i<=n; i++) {
//             if(isMonobit(i)) {
//                 count++;
//             }
//         }

//         return count;
//     }

//     private boolean isMonobit(int n) {
//         int zero = 0, one = 0;

//         if(n == 0) return true;

//         while(n != 0) {
//             if((n & 1) == 1) {
//                 one++;
//             } else {
//                 zero++;
//             }

//             n >>= 1;
//         }

//         return zero == 0 || one == 0;
//     }
// } 






// Optimal Solution

class Solution {
    public int countMonobit(int n) {
        int count = 0;

        for(int i=0; i<=n; i++) {
            if((i & (i+1)) == 0) {
                count++;
            }
        }

        return count;
    }
} 