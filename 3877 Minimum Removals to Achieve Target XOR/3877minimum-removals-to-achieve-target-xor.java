class Solution {
    public int minRemovals(int[] nums, int target) {
        int totalXor = 0;
        for(int num : nums) {
            totalXor ^= num;
        }

        if(totalXor == target) return 0;

        int need = totalXor ^ target;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);

        for(int num : nums) {
            Map<Integer, Integer> next = new HashMap<>(map);

            for(int xor : map.keySet()) {
                int newXor = xor ^ num;
                int size = map.get(xor) + 1;

                next.put(newXor, Math.min(
                    next.getOrDefault(newXor, Integer.MAX_VALUE),
                    size
                ));
            }

            map = next;
        }

        return map.containsKey(need) ? map.get(need) : -1;
    }
} 