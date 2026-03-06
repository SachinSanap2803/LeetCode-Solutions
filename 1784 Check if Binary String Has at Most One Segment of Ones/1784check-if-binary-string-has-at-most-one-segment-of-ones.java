// Brute force

// class Solution {
//     public boolean checkOnesSegment(String s) {
//         for(int i=1; i<s.length(); i++) {
//             if(s.charAt(i) == '1' && s.charAt(i-1) == '0') {
//                 return false;
//             }
//         }

//         return true;
//     }
// } 






// Optimal Solution

class Solution {
    public boolean checkOnesSegment(String s) {
        return !s.contains("01");
    }
} 