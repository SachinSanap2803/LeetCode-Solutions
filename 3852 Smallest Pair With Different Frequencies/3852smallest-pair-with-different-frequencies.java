class Solution {
    public int[] minDistinctFreqPair(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer> values = new ArrayList<>(map.keySet());
        Collections.sort(values);

        int m = values.size();
        for(int i=0; i<m; i++) {
            int x = values.get(i);

            for(int j=i+1; j<m; j++) {
                int y = values.get(j);

                if(!map.get(x).equals(map.get(y))) {
                    return new int[] {x, y};
                }
            }
        }

        return new int[] {-1, -1};
    }
} 