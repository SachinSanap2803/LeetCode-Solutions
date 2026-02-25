// Brute force

// class Solution {
//     public int[] sortByBits(int[] arr) {
//         int n = arr.length;

//         List<Integer> list = new ArrayList<>();
//         for(int num : arr) {
//             list.add(num);
//         }

//         Collections.sort(list, (a, b) -> {
//             int bitsA = countSetBits(a);
//             int bitsB = countSetBits(b);

//             if(bitsA == bitsB) {
//                 return a - b;
//             }

//             return bitsA - bitsB;
//         });

//         for(int i=0; i<n; i++) {
//             arr[i] = list.get(i);
//         }

//         return arr;
//     }

//     private int countSetBits(int n) {
//         int count = 0;

//         while(n > 0) {
//             count += (n & 1);
//             n >>= 1;
//         }

//         return count;
//     }
// } 







// Optimal Solution

class Solution {
    public int[] sortByBits(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            int bitsA = Integer.bitCount(a);
            int bitsB = Integer.bitCount(b);

            if(bitsA == bitsB) {
                return a - b;
            }

            return bitsA - bitsB;
        });

        for(int num : arr) {
            pq.add(num);
        }

        int i = 0;
        while(!pq.isEmpty()) {
            arr[i++] = pq.poll();
        }

        return arr;
    }
} 