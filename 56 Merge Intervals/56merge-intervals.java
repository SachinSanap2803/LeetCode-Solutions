// Brute force

// class Solution {
//     public int[][] merge(int[][] intervals) {
//         List<List<Integer>> ans = new ArrayList<>();
//         int n = intervals.length;
//         Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

//         int i=0;
//         while(i<n) {
//             int start = intervals[i][0];
//             int end = intervals[i][1];

//             int j=i+1;
//             while(j<n && intervals[j][0] <= end) {
//                 end = Math.max(end, intervals[j][1]);
//                 j++;
//             }

//             ans.add(Arrays.asList(start, end));
//             i=j;
//         }

//         int rows = ans.size();
//         int cols = 2;
//         int[][] arr = new int[rows][cols];

//         for(int row=0; row<rows; row++) {
//             for(int col=0; col<cols; col++) {
//                 arr[row][col] = ans.get(row).get(col);
//             }
//         }

//         return arr;
//     }
// } 






// Optimal Solution

class Solution {
    public int[][] merge(int[][] intervals) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        for(int[] interval : intervals) {
            if(ans.isEmpty() || ans.get(ans.size()-1).get(1) < interval[0]) {
                ans.add(Arrays.asList(interval[0], interval[1]));
            } else {
                int last = ans.size()-1;
                int maxEnd = Math.max(ans.get(last).get(1), interval[1]);
                ans.get(last).set(1, maxEnd);
            }
        }

        int rows = ans.size();
        int cols = 2;
        int[][] arr = new int[rows][cols];

        for(int row=0; row<rows; row++) {
            for(int col=0; col<cols; col++) {
                arr[row][col] = ans.get(row).get(col);
            }
        }

        return arr;
    }
} 