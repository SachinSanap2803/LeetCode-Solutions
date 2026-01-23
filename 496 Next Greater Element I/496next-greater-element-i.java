// Brute force

// class Solution {
//     public int[] nextGreaterElement(int[] nums1, int[] nums2) {
//         int n1 = nums1.length;
//         int n2 = nums2.length;

//         int[] ans = new int[n1];

//         for(int i=0; i<n1; i++) {
//             int num = nums1[i];
//             ans[i] = -1;

//             for(int j=0; j<n2; j++) {
//                 if(nums2[j] == num) {
//                     for(int k=j+1; k<n2; k++) {
//                         if(nums2[k] > num) {
//                             ans[i] = nums2[k];
//                             break;
//                         }
//                     }
//                     break;
//                 }
//             }
//         }

//         return ans;
//     }
// } 






// Optimal Solution

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> st = new Stack<>();

        for(int num : nums2) {
            while(!st.isEmpty() && st.peek() < num) {
                map.put(st.pop(), num);
            }
            st.push(num);
        }

        while(!st.isEmpty()) {
            map.put(st.pop(), -1);
        }

        int[] ans = new int[nums1.length];
        for(int i=0; i<nums1.length; i++) {
            ans[i] = map.get(nums1[i]);
        }

        return ans;
    }
} 