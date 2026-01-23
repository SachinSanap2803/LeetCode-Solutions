// Brute force

// class Solution {
//     public int[] nextGreaterElements(int[] nums) {
//         int n = nums.length;
//         int[] ans = new int[n];
//         Arrays.fill(ans, -1);

//         for(int i=0; i<n; i++) {
//             for(int j=i+1; j<i+n; j++) {
//                 int idx = j % n;

//                 if(nums[idx] > nums[i]) {
//                     ans[i] = nums[idx];
//                     break;
//                 }
//             }
//         }

//         return ans;
//     }
// } 






// Optimal Solution

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i=2*n-1; i>=0; i--) {
            while(!st.isEmpty() && st.peek() <= nums[i % n]) {
                st.pop();
            }

            if(i < n) {
                ans[i] = st.isEmpty() ? -1 : st.peek();
            }

            st.push(nums[i % n]);
        }

        return ans;
    }
} 