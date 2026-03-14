class Solution {
    public int minCost(int[] nums1, int[] nums2) {
        int n = nums1.length;

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for(int num : nums2) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for(int val : map.values()) {
            if(val % 2 != 0) {
                return -1;
            }
        }

        HashMap<Integer, Integer> cnt1 = new HashMap<>();

        for(int num : nums1) {
            cnt1.put(num, cnt1.getOrDefault(num, 0) + 1);
        }

        int swaps = 0;

        for(int key : map.keySet()) {
            int need = map.get(key) / 2;
            int have = cnt1.getOrDefault(key, 0);

            if(have > need) {
                swaps += (have - need);
            }
        }

        return swaps;
    }
} 