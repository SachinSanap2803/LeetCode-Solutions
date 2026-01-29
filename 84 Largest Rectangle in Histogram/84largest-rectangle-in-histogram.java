// Brute force Solution

// class Solution {

//     private int[] findNSE(int[] arr) {
//         int n = arr.length;
//         int[] ans = new int[n];
//         Stack<Integer> st = new Stack<>();

//         for(int i=n-1; i>=0; i--) {
//             while(!st.isEmpty() && arr[st.peek()] >= arr[i]) {
//                 st.pop();
//             }

//             ans[i] = st.isEmpty() ? n : st.peek();
//             st.push(i);
//         }

//         return ans;
//     }

//     private int[] findPSE(int[] arr) {
//         int n = arr.length;
//         int[] ans = new int[n];
//         Stack<Integer> st = new Stack<>();

//         for(int i=0; i<n; i++) {
//             while(!st.isEmpty() && arr[st.peek()] >= arr[i]) {
//                 st.pop();
//             }

//             ans[i] = st.isEmpty() ? -1 : st.peek();
//             st.push(i);
//         }

//         return ans;
//     }

//     public int largestRectangleArea(int[] heights) {
//         int[] nse = findNSE(heights);
//         int[] pse = findPSE(heights);

//         int maxi = 0;
//         for(int i=0; i<heights.length; i++) {
//             maxi = Math.max(maxi, heights[i] * (nse[i] - pse[i] - 1));
//         }

//         return maxi;
//     }
// } 







// Optimal Solution

class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int maxi = 0;

        for(int i=0; i<n; i++) {
            while(!st.isEmpty() && heights[st.peek()] > heights[i]) {
                int ele = st.pop();
                int nse = i;
                int pse = st.isEmpty() ? -1 : st.peek();

                maxi = Math.max(maxi, heights[ele] * (nse - pse - 1));
            }
            st.push(i);
        }

        while(!st.isEmpty()) {
            int ele = st.pop();
            int nse = n;
            int pse = st.isEmpty() ? -1 : st.peek();
            
            maxi = Math.max(maxi, heights[ele] * (nse - pse - 1));
        }

        return maxi;
    }
} 