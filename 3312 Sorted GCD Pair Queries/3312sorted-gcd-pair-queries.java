// Brute force

// class Solution {

//     int gcd(int a, int b) {
//         if(b == 0) return a;
//         return gcd(b, a % b);
//     }

//     public int[] gcdValues(int[] nums, long[] queries) {
//         int n = nums.length;
//         int m = queries.length;

//         int[] gcdPairs = new int[(n * (n-1)) / 2];
//         int k = 0;

//         for(int i=0; i<n-1; i++) {
//             for(int j=i+1; j<n; j++) {
//                 gcdPairs[k++] = gcd(nums[i], nums[j]);
//             }
//         }

//         Arrays.sort(gcdPairs);

//         int[] ans = new int[m];

//         for(int i=0; i<m; i++) {
//             int idx = (int) queries[i];
//             ans[i] = gcdPairs[idx];
//         }

//         return ans;
//     }
// } 





// Optimal Solution

class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int max = 0;
        for(int num : nums) {
            max = Math.max(max, num);
        }

        // freq[i] = freq of number i
        int[] freq = new int[max + 1];
        for(int num : nums) {
            freq[num]++;
        }

        // exactPairs[g] = number of pairs having gcd exactly g
        long[] exactPairs = new long[max + 1];

        for(int g=max; g>=1; g--) {
            long count = 0;

            // count numbers divisible by g
            for(int multiple=g; multiple<=max; multiple+=g) {
                count += freq[multiple];
            }

            // total possible pairs
            long pairs = (count * (count - 1)) / 2;

            // remove the pairs already assigned to larger gcds
            for(int multiple=2*g; multiple<=max; multiple+=g) {
                pairs -= exactPairs[multiple];
            }

            exactPairs[g] = pairs;
        }

        // prefix sum of pair counts
        long[] prefix = new long[max+1];
        
        for(int i=1; i<=max; i++) {
            prefix[i] = prefix[i-1] + exactPairs[i];
        }

        int[] ans = new int[queries.length];
        
        for(int i=0; i<queries.length; i++) {
            long q = queries[i] + 1;    // coverting 0 based to 1 based indexing

            int low = 1;
            int high = max;
            
            while(low < high) {
                int mid = low + (high - low) / 2;

                if(prefix[mid] >= q) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }

            ans[i] = low;
        }

        return ans;
    }
} 