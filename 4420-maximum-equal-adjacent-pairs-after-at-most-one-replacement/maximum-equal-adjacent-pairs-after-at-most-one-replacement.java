class Solution {
    public int maxEqualAdjacentPairs(int[] nums) {
        Map<String, Integer> map = new HashMap<>();

        int base = 0;       // already matched pairs

        for(int i=0; i<nums.length-1; i++) {
            int a = nums[i];
            int b = nums[i+1];

            if(a == b) {
                base++;
            } else {
                String key1 = a + "#" + b;
                String key2 = b + "#" + a;

                map.put(key1, map.getOrDefault(key1, 0) + 1);
                map.put(key2, map.getOrDefault(key2, 0) + 1);
            }
        }

        int maxGain = 0;        // Pair with most freq

        for(int val : map.values()) {
            maxGain = Math.max(maxGain, val);
        }

        return base + maxGain;
    }
} 