class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.isEmpty()) {
            return 0;
        }

        int nl = needle.length();
        int hl = haystack.length();

        if(nl > hl) {
            return -1;
        }

        for(int i=0; i<=hl-nl; i++) {
            if(haystack.substring(i, i+nl).equals(needle)) {
                return i;
            }
        }

        return -1;
    } 
}



// class Solution {
//     public int strStr(String haystack, String needle) {
//         if(needle.isEmpty()) {
//             return 0;
//         }

//         int nl = needle.length();
//         int hl = haystack.length();

//         if(nl > hl) {
//             return -1;
//         }

//         for(int i=0; i<=hl-nl; i++) {
//             int j=0;  // for traversing on needle
//             StringBuilder sb = new StringBuilder();

//             while(j<nl && haystack.charAt(i+j) == needle.charAt(j)) {
//                 sb.append(haystack.charAt(i+j));
//                 j++;
//             }

//             if(sb.toString().equals(needle)) {
//                 return i;
//             }
//         }

//         return -1;
//     } 
// }