// Brute force

// class Solution {
//     public int maxCapacity(int[] costs, int[] capacity, int budget) {
//         int n = costs.length;
//         int cap = 0;

//         // choose one machine
//         for(int i=0; i<n; i++) {
//             if(costs[i] < budget) {
//                 cap = Math.max(cap, capacity[i]);
//             }
//         }

//         // choose two machine
//         for(int i=0; i<n; i++) {
//             for(int j=i+1; j<n; j++) {
//                 if(costs[i] + costs[j] < budget) {
//                     cap = Math.max(cap, capacity[i] + capacity[j]);
//                 }
//             }
//         }

//         return cap;
//     }
// } 







// Optimal 

class Solution {
    public int maxCapacity(int[] costs, int[] capacity, int budget) {
        int n = costs.length;
        int[][] machine = new int[n][2];

        for(int i=0; i<n; i++) {
            machine[i][0] = costs[i];
            machine[i][1] = capacity[i];
        }

        Arrays.sort(machine, (a, b) -> a[0] - b[0]);

        // prefix max capacity
        int[] prefixMax = new int[n];
        prefixMax[0] = machine[0][1];
        for(int i=1; i<n; i++) {
            prefixMax[i] = Math.max(prefixMax[i-1], machine[i][1]);
        }
        
        int ans = 0;

        // single machine
        for(int i=0; i<n; i++) {
            if(machine[i][0] < budget) {
                ans = Math.max(ans, machine[i][1]);
            }
        }

        // two machine
        for(int j=1; j<n; j++) {
            int rem = budget - machine[j][0];
            if(rem <= 0) continue;

            int idx = upperBound(machine, j-1, rem-1);
                if(idx >= 0 && idx < j) {
                    ans = Math.max(ans, prefixMax[idx] + machine[j][1]);
                }
        }

        return ans;
    }

    private int upperBound(int[][] machine, int right, int target) {
        int l = 0, r = right, ans = -1;
        while(l <= r) {
            int mid = (l+r)/2;
            if(machine[mid][0] <= target) {
                ans = mid;
                l = mid+1;
            } else {
                r = mid-1;
            }
        }

        return ans;
    }
} 