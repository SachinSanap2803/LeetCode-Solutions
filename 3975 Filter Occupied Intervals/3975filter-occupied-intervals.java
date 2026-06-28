class Solution {
    public List<List<Integer>> filterOccupiedIntervals(int[][] occupiedIntervals, int freeStart, int freeEnd) {
        Arrays.sort(occupiedIntervals, (a, b) -> {
            if(a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        List<int[]> merged = new ArrayList<>();
        for(int[] curr : occupiedIntervals) {
            if(merged.isEmpty()) {
                merged.add(new int[]{curr[0], curr[1]});
            } else {
                int[] last = merged.get(merged.size()-1);
                if(curr[0] <= (long) last[1] + 1) {
                    last[1] = Math.max(last[1], curr[1]);
                } else {
                    merged.add(new int[]{curr[0], curr[1]});
                }
            }
        }

        List<List<Integer>> ans = new ArrayList<>();

        for(int[] in : merged) {
            int l = in[0], r = in[1];

            if(r < freeStart || l > freeEnd) {
                ans.add(Arrays.asList(l, r));
            } else {
                if(l < freeStart) {
                    ans.add(Arrays.asList(l, freeStart-1));
                }
            
                if(r > freeEnd) {
                    ans.add(Arrays.asList(freeEnd+1, r));
                }
            }
        }

        return ans;
    }
}