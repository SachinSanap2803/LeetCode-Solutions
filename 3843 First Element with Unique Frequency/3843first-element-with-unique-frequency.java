class Solution {
    public int firstUniqueFreq(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        HashMap<Integer, Integer> freqCnt = new HashMap<>();
        for(int f : map.values()) {
            freqCnt.put(f, freqCnt.getOrDefault(f, 0) + 1);
        }

        for(int num : nums) {
            int f = map.get(num);
            if(freqCnt.get(f) == 1) {
                return num;
            }
        }

        return -1;
    }
} 