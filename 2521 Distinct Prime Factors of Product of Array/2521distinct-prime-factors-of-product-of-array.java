// Solution 1 : Integer Overflow

// class Solution {
//     public int distinctPrimeFactors(int[] nums) {
//         int product = 1;
//         for(int num : nums) {
//             product *= num;
//         }

//         int count = 0;
//         for(int i=2; i*i<=product; i++) {
//             if(product % i == 0) {
//                 count++;
//             }

//             while(product % i == 0) {
//                 product /= i;
//             }
//         }

//         if(product != 1) {
//             return count+1;
//         }

//         return count;
//     }
// } 







// Solution 2

class Solution {
    public int distinctPrimeFactors(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for(int num : nums) {
            for(int i=2; i*i<=num; i++) {
                while(num % i == 0) {
                    set.add(i);
                    num /= i;
                }
            }
            if(num != 1) {
                set.add(num);
            }
        }

        return set.size();
    }
} 