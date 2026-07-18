class Solution {
    public String rearrangeString(String s, char x, char y) {
        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray()) {
            if(ch == y) {
                sb.insert(0, ch);
            } else {
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}