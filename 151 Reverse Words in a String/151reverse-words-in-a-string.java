// Brute force

// class Solution {
//     public String reverseWords(String s) {
//         Stack<String> st = new Stack<>();
//         int n = s.length();
//         int i = 0;

//         while (i < n) {
//             while (i < n && s.charAt(i) == ' ') {
//                 i++;
//             }

//             if (i >= n)
//                 break;

//             int start = i;
//             while (i < n && s.charAt(i) != ' ') {
//                 i++;
//             }

//             String str = s.substring(start, i);
//             st.push(str);
//         }

//         StringBuilder sb = new StringBuilder("");
//         while (!st.isEmpty()) {
//             sb.append(st.pop());
//             if (!st.isEmpty()) {
//                 sb.append(' ');
//             }
//         }

//         return sb.toString();
//     }
// }







// Optimal Solution

class Solution {
    public String reverseWords(String s) {
        int left = 0;
        int right = s.length() - 1;

        StringBuilder temp = new StringBuilder("");
        StringBuilder ans = new StringBuilder("");

        while (left <= right) {
            char ch = s.charAt(left);

            if (ch != ' ') {
                temp.append(ch);
            } else {
                if (temp.length() > 0) {
                    if (ans.length() > 0) {
                        ans.insert(0, ' ');
                    }
                    ans.insert(0, temp.toString());
                    temp.setLength(0);
                }
            }
            left++;
        }

        if (temp.length() > 0) {
            if (ans.length() > 0) {
                ans.insert(0, ' ');
            }
            ans.insert(0, temp.toString());
            temp.setLength(0);
        }

        return ans.toString();
    }
}