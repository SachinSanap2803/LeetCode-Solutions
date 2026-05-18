// Using DFS

// class Solution {
//     public boolean canReach(int[] arr, int start) {
//         boolean[] visited = new boolean[arr.length];
//         return dfs(arr, start, visited);
//     }

//     public boolean dfs(int[] arr, int idx, boolean[] visited) {
//         if(idx < 0 || idx >=arr.length || visited[idx]) {
//             return false;
//         }

//         if(arr[idx] == 0) {
//             return true;
//         }

//         visited[idx] = true;

//         return dfs(arr, idx + arr[idx], visited) || dfs(arr, idx - arr[idx], visited);
//     }
// } 







// Using BFS

class Solution {
    public boolean canReach(int[] arr, int start) {
        return bfs(arr, start);
    }

    public boolean bfs(int[] arr, int start) {
        int n = arr.length;

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];

        q.offer(start);
        visited[start] = true;

        while(!q.isEmpty()) {
            int idx = q.poll();

            if(arr[idx] == 0) {
                return true;
            }

            int forward = idx + arr[idx];
            int backward = idx - arr[idx];

            if(forward < n && !visited[forward]) {
                visited[forward] = true;
                q.offer(forward);
            }

            if(backward >= 0 && !visited[backward]) {
                visited[backward] = true;
                q.offer(backward);
            }
        }

        return false;
    }
} 