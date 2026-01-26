class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        int mini = Integer.MAX_VALUE;

        for(int i=1; i<n; i++) {
            int diff = arr[i] - arr[i-1];
            mini = Math.min(mini, diff);
        }

        List<List<Integer>> res = new ArrayList<>();
        for(int i=1; i<n; i++) {
            if(arr[i] - arr[i-1] == mini) {
                List<Integer> temp = new ArrayList<>();
                temp.add(arr[i-1]);
                temp.add(arr[i]);
                res.add(temp);
            }
        }

        return res;
    }
} 