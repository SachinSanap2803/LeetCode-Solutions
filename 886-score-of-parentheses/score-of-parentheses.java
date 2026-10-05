class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        st.push(0);

        for(char ch : s.toCharArray()) {
            if(ch == '(') {
                st.push(0);
            } else {
                int inner = st.pop();
                int score;

                if(inner == 0) {
                    score = 1;
                } else {
                    score = 2 * inner;
                }

                st.push(st.pop() + score);
            }
        }

        return st.pop();
    }
} 