// 1] Brute force

// class Solution {

//     private void findCombinations(int idx, int[] arr, int target, HashSet<List<Integer>> set, List<Integer> ds) {
//         if(target == 0) {
//             List<Integer> comb = new ArrayList<>(ds);
//             Collections.sort(comb);
//             set.add(new ArrayList<>(comb));
//             return;
//         }

//         if(idx == arr.length || target < 0) return;

//         ds.add(arr[idx]);
//         findCombinations(idx+1, arr, target - arr[idx], set, ds);
//         ds.remove(ds.size()-1);

//         findCombinations(idx+1, arr, target, set, ds);
//     }

//     public List<List<Integer>> combinationSum2(int[] candidates, int target) {
//         HashSet<List<Integer>> set = new HashSet<>();
//         Arrays.sort(candidates);
//         findCombinations(0, candidates, target, set, new ArrayList<>());

//         List<List<Integer>> list = new ArrayList<>(set);

//         return list;
//     }
// }






class Solution {

    private void findCombinations(int idx, int[] arr, int target, List<List<Integer>> ans, List<Integer> ds) {
        if(target == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for(int i=idx; i<arr.length; i++) {
            if(i > idx && arr[i] == arr[i-1]) continue;
            if(arr[i] > target) break;

            ds.add(arr[i]);
            findCombinations(i+1, arr, target - arr[i], ans, ds);
            ds.remove(ds.size()-1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        findCombinations(0, candidates, target, ans, new ArrayList<>());

        return ans;
    }
} 