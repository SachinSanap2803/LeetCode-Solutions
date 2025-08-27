class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>(numRows);

        for(int row=1; row<=numRows; row++) {
            List<Integer> temp = new ArrayList<>();
            int val = 1;
            temp.add(val);

            for(int col=1; col<row; col++) {
                val = val * (row-col);
                val = val / col;
                temp.add(val);
            }

            ans.add(temp);
        }

        return ans;
    }
} 