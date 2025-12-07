class Solution {
    private final String[] map;
    
    public Solution() {
        map = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits == null || digits.length() == 0) {
            return result;
        }
        helper(0, new StringBuilder(), digits, result);

        return result;
    }

    private void helper(int idx, StringBuilder sb, String digits, List<String> result) {
        if(idx == digits.length()) {
            result.add(sb.toString());
            return;
        }

        char digit = digits.charAt(idx);
        String letters = map[digit - '0'];

        for(int i=0; i<letters.length(); i++) {
            sb.append(letters.charAt(i));
            helper(idx+1, sb, digits, result);
            sb.deleteCharAt(sb.length()-1);
        }
    }
} 