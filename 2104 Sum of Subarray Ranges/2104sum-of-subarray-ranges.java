// Brute force

// class Solution {
//     public long subArrayRanges(int[] nums) {
//         int n = nums.length;
//         long sum = 0;

//         for(int i=0; i<n; i++) {
//             int max = nums[i], min = nums[i];
//             for(int j=i; j<n; j++) {
//                 max = Math.max(max, nums[j]);
//                 min = Math.min(min, nums[j]);

//                 int diff = max - min;
//                 sum += diff;
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

    private int[] findNGE(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i=n-1; i>=0; i--) {
            while(!st.isEmpty() && arr[st.peek()] <= arr[i]) {
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

    private int[] findPGEE(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<n; i++) {
            while(!st.isEmpty() && arr[st.peek()] < arr[i]) {
                st.pop();
            }

            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        return ans;
    }

    private long sumSubarrayMin(int[] arr) {
        int n = arr.length;
        int[] nse = findNSE(arr);
        int[] psee = findPSEE(arr);

        long sum = 0;
        for(int i=0; i<n; i++) {
            int left = i - psee[i];
            int right = nse[i] - i;

            sum += (arr[i] * (1L * left * right));
        }

        return sum;
    }

    private long sumSubarrayMax(int[] arr) {
        int n = arr.length;
        int[] nge = findNGE(arr);
        int[] pgee = findPGEE(arr);

        long sum = 0;
        for(int i=0; i<n; i++) {
            int left = i - pgee[i];
            int right = nge[i] - i;

            sum += (arr[i] * (1L * left * right));
        }

        return sum;
    }

    public long subArrayRanges(int[] nums) {
        return sumSubarrayMax(nums) - sumSubarrayMin(nums);
    }

} 