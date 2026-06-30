class Solution {
    public boolean wordPattern(String pattern, String s) {
        int n = pattern.length();

        String[] words = s.split("\\s+");

        if(pattern.length() != words.length) {
            return false;
        }

        HashMap<Character, String> pTos = new HashMap<>();
        HashMap<String, Character> sTop = new HashMap<>();

        for(int i=0; i<n; i++) {
            char ch = pattern.charAt(i);
            String word = words[i];

            if(pTos.containsKey(ch)) {
                if(!pTos.get(ch).equals(word)) {
                    return false;
                }
            } else {
                pTos.put(ch, word);
            }

            if(sTop.containsKey(word)) {
                if(!sTop.get(word).equals(ch)) {
                    return false;
                }
            } else {
                sTop.put(word, ch);
            }
        }
        
        return true;
    }
} 