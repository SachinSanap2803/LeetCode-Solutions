// class Solution {
//     public int shipWithinDays(int[] weights, int days) {
//         int max = Integer.MIN_VALUE;
//         int sum = 0;

//         for(int num : weights) {
//             if(num > max) {
//                 max = num;
//             }
//             sum += num;
//         }

//         for(int cap=max; cap<=sum; cap++) {
//             if(daysRequired(weights, cap, days)) {
//                 return cap;
//             }
//         }

//         return -1;
//     }

//     public boolean daysRequired(int[] weights, int cap, int days) {
//         int load = 0;
//         int calDay = 1;
//         for(int i=0; i<weights.length; i++) {
//             if(load + weights[i] > cap) {
//                 calDay++;
//                 load = 0;
//             }

//             load += weights[i];

//             if(calDay > days) {
//                 return false;
//             }
//         }

//         return calDay <= days;
//     }
// } 









class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for(int num : weights) {
            if(num > max) {
                max = num;
            }
            sum += num;
        }

        int left = max, right = sum;

        while(left <= right) {
            int mid = left + (right-left)/2;
            if(canShip(weights, mid, days)) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }

        return left;
    }

    public boolean canShip(int[] weights, int cap, int days) {
        int load = 0;
        int calDay = 1;
        for(int i=0; i<weights.length; i++) {
            if(load + weights[i] > cap) {
                calDay++;
                load = 0;
            }

            load += weights[i];

            if(calDay > days) {
                return false;
            }
        }

        return calDay <= days;
    }
} 