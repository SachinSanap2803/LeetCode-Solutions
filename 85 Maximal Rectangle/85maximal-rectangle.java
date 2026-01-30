class Solution {

    public int largHisto(int[] arr) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int maxi = 0;

        for(int i=0; i<n; i++) {
            while(!st.isEmpty() && arr[st.peek()] > arr[i]) {
                int ele = st.pop();
                int nse = i;
                int pse = st.isEmpty() ? -1 : st.peek();

                maxi = Math.max(maxi, arr[ele] * (nse - pse - 1));
            }
            st.push(i);
        } 

        while(!st.isEmpty()) {
            int ele = st.pop();
            int nse = n;
            int pse = st.isEmpty() ? -1 : st.peek();

            maxi = Math.max(maxi, arr[ele] * (nse - pse - 1));
        }

        return maxi;
    }

    public int maximalRectangle(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] preSum = new int[rows][cols];

        for(int i=0; i<cols; i++) {
            int sum = 0;
            for(int j=0; j<rows; j++) {
                if(matrix[j][i] == '1') {
                    sum++;
                } else {
                    sum = 0;
                }
                preSum[j][i] = sum;
            }
        }

        int maxArea = 0;

        for(int i=0; i<rows; i++) {
            maxArea = Math.max(maxArea, largHisto(preSum[i]));
        }

        return maxArea;
    }

} 