class Solution {
    public int minimumDistance(int[] nums) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for(int i=0; i<nums.length; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        int ans = Integer.MAX_VALUE;

        for(List<Integer> idxList : map.values()) {
            if(idxList.size() < 3) continue;

            for(int i=0; i+2 < idxList.size(); i++) {
                int first = idxList.get(i);
                int third = idxList.get(i+2);
                int dist = 2 * (third - first);

                ans = Math.min(ans, dist);
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
} 