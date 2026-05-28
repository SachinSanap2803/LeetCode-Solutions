class Solution {
    public int numberOfSpecialChars(String word) {
        int count = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i=0; i<word.length(); i++) {
            char ch = word.charAt(i);

            if(map.containsKey(ch)) {
                if(ch >= 'a' && ch <= 'z') {
                    map.put(ch, i);
                }
            } else {
                map.put(ch, i);
            }
        }

        for(char ch='a'; ch<='z'; ch++) {
            if(map.containsKey(ch) && map.containsKey((char)(ch-32))) {
                if(map.get(ch) < map.get((char)(ch-32))) {
                    count++;
                }
            }
        }

        return count;
    }
} 