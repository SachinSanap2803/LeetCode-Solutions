class Solution {
    public String reverseParentheses(String s) {
        int n = s.length();
        Stack<String> st = new Stack<>();
        
        for(int i=0; i<n; i++) {
            char ch = s.charAt(i);

            if(ch == '(') {
                st.push(String.valueOf(ch));
            } else if(ch >= 'a' && ch <= 'z') {
                st.push(String.valueOf(ch));
            } else {
                StringBuilder temp = new StringBuilder();

                while(!st.peek().equals("(")) {
                    temp.append(st.pop());
                }

                st.pop();
                
                temp.reverse();
                st.push(temp.toString());
            }
        }

        StringBuilder sb = new StringBuilder();

        while(!st.isEmpty()) {
            sb.append(st.pop());
        }

        return sb.reverse().toString();
    }
} 