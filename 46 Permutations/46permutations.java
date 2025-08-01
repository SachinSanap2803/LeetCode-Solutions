// 1] Brute force approach

// class Solution {
//     public List<List<Integer>> permute(int[] nums) {
//         List<List<Integer>> ans = new ArrayList<>();
//         List<Integer> ds = new ArrayList<>();
//         boolean[] freq = new boolean[nums.length];

//         recurPermute(nums, ans, ds, freq);
        
//         return ans;
//     }

//     private void recurPermute(int[] nums, List<List<Integer>> ans, List<Integer> ds, boolean[] freq)
//     {
//         if(ds.size() == nums.length) {
//             ans.add(new ArrayList<>(ds));
//             return;
//         }

//         for(int i=0; i<nums.length; i++) {
//             if(!freq[i]) {
//                 ds.add(nums[i]);
//                 freq[i] = true;

//                 recurPermute(nums, ans, ds, freq);
//                 ds.remove(ds.size()-1);
//                 freq[i] = false;
//             }
//         }
//     }
// } 



// 2] Optimized approach

class Solution {
    public List<List<Integer>> permute(int[] nums) {
       List<List<Integer>> ans = new ArrayList<>();
       recurPermute(0, nums, ans);

       return ans;
    }

    private void recurPermute(int idx, int[] nums, List<List<Integer>> ans) {
        if(idx == nums.length) {
            List<Integer> ds = new ArrayList<>();
            for(int i=0; i<nums.length; i++) {
                ds.add(nums[i]);
            }
            ans.add(new ArrayList<>(ds));
            return;
        }

        for(int i=idx; i<nums.length; i++) {
            swap(i, idx, nums);
            recurPermute(idx+1, nums, ans);
            swap(i, idx, nums);
        }
    }

    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
} 