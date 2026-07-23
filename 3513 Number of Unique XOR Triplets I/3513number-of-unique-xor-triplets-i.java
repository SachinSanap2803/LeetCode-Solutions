// Brute force

// class Solution {
//     public int uniqueXorTriplets(int[] nums) {
//         int count = 0;
//         int n = nums.length;
//         HashSet<Integer> set = new HashSet<>();

//         for(int i=0; i<n; i++) {
//             for(int j=i; j<n; j++) {
//                 for(int k=j; k<n; k++) {
//                     int XOR = nums[i] ^ nums[j] ^ nums[k];
//                     if(!set.contains(XOR)) {
//                         count++;
//                         set.add(XOR);
//                     }
//                 }
//             }
//         }

//         return count;
//     }
// } 





// Better Solution

// class Solution {
//     public int uniqueXorTriplets(int[] nums) {
//         int n = nums.length;
//         if(n < 3) return n;

//         int count = 1;
//         while(count <= n) {
//             count <<= 1;
//         }

//         return count;
//     }
// } 






// Optimal Solution

class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        if(n < 3) return n;

        return Integer.highestOneBit(n) << 1;
    }
} 