class Solution {
    public List<String> commonChars(String[] words) {
        int[] common = new int[26];
        Arrays.fill(common, Integer.MAX_VALUE);

        for(String word : words) {
            int[] freq = new int[26];

            for(char ch : word.toCharArray()) {
                freq[ch - 'a']++;
            }

            for(int i=0; i<26; i++) {
                common[i] = Math.min(common[i], freq[i]);
            }
        }

        List<String> res = new ArrayList<>();

        for(int i=0; i<26; i++) {
            for(int j=0; j<common[i]; j++) {
                res.add(String.valueOf((char) (i + 'a')));
            }
        }

        return res;
    }
} 