// Brute force - O(n * m)

// class Solution {
//     public String longestCommonPrefix(String[] strs) {
//         if(strs == null || strs.length == 0) {
//             return "";
//         }

//         int maxCnt = strs[0].length();
//         int n = strs.length;

//         for(int i=1; i<n; i++) {
//             int len1 = strs[0].length();
//             int len2 = strs[i].length();
//             int currCnt = 0;
//             for(int j=0; j<Math.min(len1, len2); j++) {
//                 if(strs[i].charAt(j) != strs[0].charAt(j)) {
//                     break;
//                 }
//                 currCnt++;
//             }

//             if(currCnt < maxCnt) {
//                 maxCnt = currCnt;
//             }
//         }

//         return (maxCnt != 0) ? strs[0].substring(0, maxCnt) : "";
//     }
// } 







// Better Solution

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) {
            return "";
        }

        for(int i=0; i<strs[0].length(); i++) {
            char ch = strs[0].charAt(i);

            for(int j=1; j<strs.length; j++) {
                if(i >= strs[j].length() || strs[j].charAt(i) != ch) {
                    return strs[0].substring(0, i);
                }
            }
        }

        return strs[0];
    }
} 