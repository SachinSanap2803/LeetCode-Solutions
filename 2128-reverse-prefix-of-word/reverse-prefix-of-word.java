class Solution {
    public String reversePrefix(String word, char ch) {
        int idx = -1;
        Stack<Character> st = new Stack<>();

        for(int i=0; i<word.length(); i++) {
            char letter = word.charAt(i);

            st.add(letter);

            if(letter == ch) {
                idx = i;
                break;
            }
        }

        if(idx == -1) return word;
        
        StringBuilder sb = new StringBuilder();

        while(!st.isEmpty()) {
            sb.append(st.pop());
        }

        for(int i=idx+1; i<word.length(); i++) {
            sb.append(word.charAt(i));
        }

        return sb.toString();
    }
}