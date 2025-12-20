class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int dupCnt = 0;
        for(int cnt : map.values()) {
            if(cnt >= 2) dupCnt++;
        }

        int count = 0;
        int idx = 0;

        while(idx < n && dupCnt > 0) {
            for(int i=0; i<3 && idx < n; i++) {
                int val = nums[idx++];
                int oldVal = map.get(val);

                map.put(val, oldVal - 1);
                if(oldVal == 2) dupCnt--;
            }
            
            count++;
        }

        return count;
    }
}