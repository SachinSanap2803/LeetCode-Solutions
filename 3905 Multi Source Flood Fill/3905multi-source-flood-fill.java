class Solution {
    public int[][] colorGrid(int n, int m, int[][] sources) {
        int[][] grid = new int[n][m];
        int[][] time = new int[n][m];

        for(int[] row : time) {
            Arrays.fill(row, -1);
        }

        Queue<int[]> q = new LinkedList<>();

        for(int[] s : sources) {
            int r = s[0], c = s[1], color = s[2];
            grid[r][c] = color;
            time[r][c] = 0;
            q.offer(new int[] {r, c});
        }

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0], c = curr[1];

            for(int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];

                if(nr < 0 || nc < 0 || nr >= n || nc >= m) continue;

                if(time[nr][nc] == -1) {
                    time[nr][nc] = time[r][c] + 1;
                    grid[nr][nc] = grid[r][c];
                    q.offer(new int[] {nr, nc}); 
                } else if(time[nr][nc] == time[r][c] + 1) {
                    grid[nr][nc] = Math.max(grid[nr][nc], grid[r][c]);
                }
            }
        }

        return grid;
    }
} 