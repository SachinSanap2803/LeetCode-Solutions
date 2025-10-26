class Solution {
    public long maxAlternatingSum(int[] nums) {
        Integer[] arr = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(arr, (a, b) -> Math.abs(a) - Math.abs(b));
        int n = arr.length;
        int[] res = new int[n];
        int left = 0, right = n-1;

        for(int i=0; i<n; i++) {
            if(i % 2 == 0) {
                res[i] = arr[right--];
            } else {
                res[i] = arr[left++];
            }
        } 

        long score = 0;
        for(int i=0; i<n; i++) {
            long square = (long) res[i] * res[i];
            if(i % 2 == 0) {
                score += square;
            } else {
                score -= square;
            }
        }

        return score;
    }
} 