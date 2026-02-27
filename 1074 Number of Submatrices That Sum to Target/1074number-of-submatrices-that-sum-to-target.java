class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int count = 0;

        // fixed top row
        for(int top = 0; top < n; top++) {

            // keep sum of rows from top to bottom
            int[] rowsSum = new int[m];

            // expand bottom
            for(int bottom = top; bottom < n; bottom++) {

                for(int c = 0; c < m; c++) {
                    rowsSum[c] += matrix[bottom][c];
                }

                // count subarrays with sum = target
                count += subarraySum(rowsSum, target);
            }
        }

        return count;
    }

    private int subarraySum(int[] arr, int tar) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int sum = 0, count = 0;
        for(int num : arr) {
            sum += num;

            count += map.getOrDefault(sum - tar, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
} 