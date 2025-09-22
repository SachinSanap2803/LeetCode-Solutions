class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++) {
            if(map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i])+1);
            } else {
                map.put(nums[i], 1);
            }
        }

        int maxFreq = 0;
        int count = 1;

        for(HashMap.Entry<Integer, Integer> entry : map.entrySet()) {
            int currFreq = entry.getValue();

            if(currFreq > maxFreq) {
                maxFreq = currFreq;
                count = 1;
            } else if(currFreq == maxFreq) {
                count++;
            }
        }

        return count*maxFreq;
    }
} 