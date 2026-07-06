// Brute force

// class Solution {
//     public int removeCoveredIntervals(int[][] intervals) {
//         int n = intervals.length;
//         int covered = 0;

//         for(int i=0; i<n; i++) {
//             for(int j=0; j<n; j++) {
//                 if(i != j && intervals[i][0] >= intervals[j][0] && intervals[i][1] <= intervals[j][1]) {
//                     covered++;
//                     break;
//                 }
//             }
//         }

//         return n - covered;
//     }
// } 






// Optimal Solution

class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if(a[0] == b[0]) {
                return Integer.compare(b[1], a[1]);
            }

            return Integer.compare(a[0], b[0]);
        });

        int covered = 0;
        int maxEnd = -1;

        for(int[] interval : intervals) {
            if(interval[1] <= maxEnd) {
                covered++;
            }

            maxEnd = Math.max(maxEnd, interval[1]);
        }

        return intervals.length - covered;
    }
} 