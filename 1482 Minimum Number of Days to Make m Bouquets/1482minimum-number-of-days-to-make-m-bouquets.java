// class Solution {
//     public int minDays(int[] bloomDay, int m, int k) {
//         int n = bloomDay.length;
//         int min = Integer.MAX_VALUE;
//         int max = Integer.MIN_VALUE;

//         if(m * k > n) {
//             return -1;
//         }

//         for(int num : bloomDay) {
//             if(min > num) {
//                 min = num;
//             }
//             if(max < num) {
//                 max = num;
//             }
//         }

//         for(int d=min; d<=max; d++) {
//             if(isPossible(bloomDay, d, m, k)) {
//                 return d;
//             }
//         }

//         return -1;
//     }

//     public boolean isPossible(int[] bloomDay, int day, int m, int k) {
//         int count = 0;
//         int noOfBouquets = 0;
//         for(int b : bloomDay) {
//             if(b <= day) {
//                 count++;
//             } else {
//                 noOfBouquets += (count/k);
//                 count = 0;
//             }

//             if(noOfBouquets >= m) {
//                 return true;
//             }
//         }
//         noOfBouquets += (count/k);

//         return noOfBouquets >= m;
//     }
// } 






class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        if((long) m * k > n) {
            return -1;
        }

        for(int num : bloomDay) {
            if(min > num) { 
                min = num;
            }
            if(max < num) {
                max = num;
            }
        }

        int left = min, right = max;

        while(left <= right) {
            int mid = left + (right - left)/2;

            if(isPossible(bloomDay, mid, m, k)) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }

        return left;
    }

    public boolean isPossible(int[] bloomDay, int day, int m, int k) {
        int count = 0, noOfBouquets = 0;

        for(int b : bloomDay) {
            if(b <= day) {
                count++;
            } else  {
                noOfBouquets += (count/k);
                count = 0;
            }

            if(noOfBouquets >= m) {
                return true;
            }
        }
        noOfBouquets += (count/k);

        return noOfBouquets >= m;
    }
} 