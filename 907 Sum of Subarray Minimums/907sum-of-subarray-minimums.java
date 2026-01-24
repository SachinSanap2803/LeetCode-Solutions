// Brute force

// class Solution {
//     public int sumSubarrayMins(int[] arr) {
//         int n = arr.length;
//         int sum = 0;
//         int mod = (int)1e9+7;

//         for(int i=0; i<n; i++) {
//             int mini = arr[i];
//             for(int j=i; j<n; j++) {
//                 mini = Math.min(mini, arr[j]);
//                 sum = (sum + mini) % mod;
//             }
//         }

//         return sum;
//     }
// } 







// Optimal Solution

class Solution {

    private int[] findNSE(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i=n-1; i>=0; i--) {
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            ans[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        return ans;
    }

    private int[] findPSEE(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<n; i++) {
            while(!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }

            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        
        return ans;
    }

    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;

        int[] nse = findNSE(arr);
        int[] psee = findPSEE(arr);  

        int mod = (int)1e9+7;
        int sum = 0;

        for(int i=0; i<n; i++) {
            int left = i - psee[i];
            int right = nse[i] - i;

            int freq = (int) ((left * right * 1L * arr[i]) % mod);
            sum = (sum + freq) % mod;
        }

        return sum;
    }
} 