class Solution {
    public int countSpecialIntegers(int[] nums) {
        int n = nums.length;
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i=0; i<n; i++) {
            if(map.containsKey(nums[i])) {
                List<Integer> list = map.get(nums[i]);
                
                list.set(1, i);
                list.set(2, list.get(2) + 1);
            } else {
                List<Integer> list = new ArrayList<>();

                list.add(i);
                list.add(i);
                list.add(1);

                map.put(nums[i], list);
            }
        }

        int special = 0;

        for(int key : map.keySet()) {
            int start = map.get(key).get(0);
            int end = map.get(key).get(1);
            int freq = map.get(key).get(2);

            if(end - start + 1 == freq) {
                special++;
            }
        }

        return special;
    }
} 