class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();

        if(p.length() > s.length()) {
            return list;
        }

        int[] freq = new int[26];
        for(Character ch : p.toCharArray()) {
            freq[ch-'a']++;
        }

        int left = 0, right = 0;
        int charToMatch = p.length();

        while(right < s.length()) {
            char ch = s.charAt(right);

            if(freq[s.charAt(right)-'a']-- > 0) {
                charToMatch--;
            }

            if(right-left+1 == p.length()) {

                if(charToMatch == 0) {
                    list.add(left);
                }

                if(freq[s.charAt(left)-'a']++ >= 0) {
                    charToMatch++;
                }

                left++;
            }
            
            right++;
        }

        return list;
    }
} 