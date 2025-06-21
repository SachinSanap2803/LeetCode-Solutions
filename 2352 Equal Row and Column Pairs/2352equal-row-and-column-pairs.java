class Solution {
    public int equalPairs(int[][] grid) {
        HashMap<List<Integer>, Integer> rowMap = new HashMap<>();
        int n = grid.length;

        for(int i=0; i<n; i++) {
            List<Integer> rowList = new ArrayList<>();

            for(int j=0; j<n; j++) {
                rowList.add(grid[i][j]);
            }

            rowMap.put(rowList, rowMap.getOrDefault(rowList, 0) + 1);
        } 

        int count = 0;

        // for each column, check against rows in map

        for(int j=0; j<n; j++) {
            List<Integer> colList = new ArrayList<>();
            
            for(int i=0; i<n; i++) {
                colList.add(grid[i][j]);
            }

            count += rowMap.getOrDefault(colList, 0);
        } 

        return count;
    }
} 