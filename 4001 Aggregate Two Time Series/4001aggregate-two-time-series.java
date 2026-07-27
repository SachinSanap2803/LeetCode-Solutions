class Solution {
    public List<List<Integer>> aggregateTimeSeries(int[][] series1, int[][] series2) {
        List<List<Integer>> res = new ArrayList<>();
        int m = series1.length, n = series2.length;
        int l = 0, r = 0;

        while(l < m && r < n) {
            int[] left = series1[l];
            int[] right = series2[r];
            List<Integer> temp = new ArrayList<>();

            if(left[0] < right[0]) {
                temp.add(left[0]);
                temp.add(left[1] + right[1]);

                l++;
            } else if(left[0] > right[0]) {
                temp.add(right[0]);
                temp.add(left[1] + right[1]);

                r++;
            } else {
                temp.add(left[0]);
                temp.add(left[1] + right[1]);

                l++; r++;
            }

            res.add(temp);
        }

        while(l < m) {
            res.add(Arrays.asList(series1[l][0], series1[l][1]));
            l++;
        }

        while(r < n) {
            res.add(Arrays.asList(series2[r][0], series2[r][1]));
            r++;
        }

        return res;
    }
} 