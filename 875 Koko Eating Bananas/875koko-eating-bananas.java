//1] Brute Force Solution

// class Solution {
//     public int minEatingSpeed(int[] piles, int h) {
//         int n = piles.length;

//         int max = Integer.MIN_VALUE;
//         for(int pile : piles) {
//             max = Math.max(max, pile);
//         }

//         for(int k=1; k<=max; k++) {
//             int minTime = requiredTime(piles, k);
//             if(minTime <= h) {
//                 return k;
//             }
//         }

//         return -1;
//     }

//     public int requiredTime(int[] piles, int k) {
//         int totalHrs = 0;

//         for(int pile : piles) {
//             totalHrs += (pile + k - 1)/k;
//         }

//         return totalHrs;
//     }
// } 





// 2] Optimal Solution

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;

        int max = 0;
        for(int pile : piles) {
            max = Math.max(max, pile);
        }

        int left = 1, right = max;
        long H = h;

        while(left <= right) {
            int mid = left + (right-left)/2;

            long minTime = requiredTime(piles, mid);
            if(minTime <= H) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }

        return left;
    }

    public long requiredTime(int[] piles, int k) {
        long  totalHrs = 0L;
        for(int pile : piles) {
            totalHrs += (pile + k - 1)/k;
        }

        return totalHrs;
    }
} 