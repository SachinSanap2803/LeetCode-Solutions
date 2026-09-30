class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        int k = 0;

        while(res.size() != n) {
            Set<Integer> set = new HashSet<>();
            List<Integer> list = new ArrayList<>();

            for(int i=0; i<n; i++) {
                if(nums[i] != 0 && !set.contains(nums[i])) {
                    set.add(nums[i]);
                    list.add(nums[i]);
                    nums[i] = 0;
                }
            }

            Collections.sort(list);

            for(int i=0; i<list.size(); i++) {
                res.add(list.get(i));
            }
        }

        int[] arr = new int[res.size()];

        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }

        return arr;
    }
} 