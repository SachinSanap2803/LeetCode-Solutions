// Brute force

// class Solution {
//     public boolean isHappy(int n) {
//         HashSet<Integer> set = new HashSet<>();

//         while(n != 1 && !set.contains(n)) {
//             set.add(n);

//             int square = 0;
//             while(n > 0) {
//                 int rem = n % 10;
//                 square += (rem * rem);
//                 n /= 10;
//             }

//             n = square;
//         }

//         return n == 1;
//     }
// } 







// Optimal Solution

class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        do {
            slow = getSquare(slow);
            fast = getSquare(getSquare(fast));
        } while(slow != fast);

        return slow == 1;
    }

    private int getSquare(int n) {
        int square = 0;
        while(n > 0) {
            int rem = n % 10;
            square += rem * rem;
            n /= 10;
        }

        return square;
    }
} 