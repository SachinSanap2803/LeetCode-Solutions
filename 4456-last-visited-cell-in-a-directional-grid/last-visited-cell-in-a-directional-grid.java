class Solution {
    public int[] lastVisitedCell(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];

        int row = 0, col = 0;
        visited[row][col] = true;

        while(true) {
            int newRow = row;
            int newCol = col;

            char dir = grid[newRow][newCol];

            if(dir == 'R') {
                newCol++;
            } else if(dir == 'L') {
                newCol--;
            } else if(dir == 'U') {
                newRow--;
            } else {
                newRow++;
            }

            if(newRow < 0 || newRow >= m || newCol < 0 || newCol >= n) {
                break;
            }

            if(visited[newRow][newCol]) {
                break;
            }

            row = newRow;
            col = newCol;
            visited[row][col] = true;
        }

        return new int[] {row, col};
    }
} 