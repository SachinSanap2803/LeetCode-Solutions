class Solution {
    public int minOperations(int[][] grid, int x) {
        List<Integer> values = new ArrayList<>();
        int m = grid.length, n = grid[0].length;
        
        // Flatten grid into a list
        for (int[] row : grid) {
            for (int num : row) {
                values.add(num);
            }
        }
        
        // Sort the list to find the median
        Collections.sort(values);
        int median = values.get(values.size() / 2);
        
        int operations = 0;
        for (int num : values) {
            int diff = Math.abs(num - median);
            
            // If the difference is not a multiple of x, return -1
            if (diff % x != 0) {
                return -1;
            }
            
            operations += diff / x;
        }
        
        return operations;
    } 
} 