class Solution {
    public int[] rotateElements(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        for(int num : nums) {
            if(num >= 0) {
                list.add(num);
            }
        }

        int m = list.size();
        if(m == 0 || m == 1) return nums;

        k = k % m;

        List<Integer> rotated = new ArrayList<>();
        for(int i=k; i<m; i++) {
            rotated.add(list.get(i));
        }

        for(int i=0; i<k; i++) {
            rotated.add(list.get(i));
        }

        int idx = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] >= 0) {
                nums[i] = rotated.get(idx++);
            }
        }

        return nums;
    }
} 