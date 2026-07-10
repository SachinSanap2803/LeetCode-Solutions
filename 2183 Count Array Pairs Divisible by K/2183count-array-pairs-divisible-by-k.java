// Brute force

// class Solution {
//     public long countPairs(int[] nums, int k) {
//         int n = nums.length;
//         int pairs = 0;

//         for(int i=0; i<n-1; i++) {
//             for(int j=i+1; j<n; j++) {
//                 if((nums[i] * nums[j]) % k == 0) {
//                     pairs++;
//                 }
//             }
//         }

//         return pairs;
//     }
// } 





// Optimal Solution

class Solution {
    int gcd(int a, int b) {
        if(b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }

    public long countPairs(int[] nums, int k) {
        int n = nums.length;
        long pairs = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int num : nums) {
            int currGcd = gcd(num, k);

            for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int prevGcd = entry.getKey();
                int freq = entry.getValue();

                if((long) currGcd * prevGcd % k == 0) {
                    pairs += freq;
                }
            }

            map.put(currGcd, map.getOrDefault(currGcd, 0) + 1);
        }

        return pairs;
    }
} 