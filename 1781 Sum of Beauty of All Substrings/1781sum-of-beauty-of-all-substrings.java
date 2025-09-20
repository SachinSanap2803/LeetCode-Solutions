// Brute force

// class Solution {
//     public int beautySum(String s) {
//         int n = s.length();
//         int sum = 0;

//         for(int i=0; i<n; i++) {
//             for(int j=i; j<n; j++) {
//                 String str = s.substring(i, j+1);
//                 sum +=  calBeauty(str);
//             }
//         }

//         return sum;
//     }

//     int calBeauty(String str) {
//         HashMap<Character, Integer> map = new HashMap<>();

//         for(char ch : str.toCharArray()) {
//             map.put(ch, map.getOrDefault(ch, 0)+1);
//         }

//         int min = Integer.MAX_VALUE;
//         int max = Integer.MIN_VALUE;

//         for(int val : map.values()) {
//             if(val > max) {
//                 max = val;
//             }
//             if(val < min) {
//                 min = val;
//             }
//         }

//         return max - min;
//     }
// } 






// Optimal Solution

class Solution {
    public int beautySum(String s) {
        int n = s.length();
        int sum = 0;

        for(int i=0; i<n; i++) {
            int[] freq = new int[26];
            for(int j=i; j<n; j++) {
                freq[s.charAt(j) - 'a']++;

                int max = Integer.MIN_VALUE;
                int min = Integer.MAX_VALUE;

                for(int f : freq) {
                    if(f > 0) {
                        max = Math.max(max, f);
                        min = Math.min(min, f);
                    }
                }

                sum += (max - min);
            }
        }

        return sum;
    }
} 