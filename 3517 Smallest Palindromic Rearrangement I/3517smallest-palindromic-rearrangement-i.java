class Solution {
    public String smallestPalindrome(String s) {
        int[] freq = new int[26];

        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            freq[ch - 'a']++;
        }

        StringBuilder left = new StringBuilder();
        char middle = '\0';

        for(int i=0; i<26; i++) {
            if(freq[i] > 0) {
                char ch = (char) ('a' + i);

                for(int j=0; j<freq[i]/2; j++) {
                    left.append(ch);
                }

                if(freq[i] % 2 != 0) {
                    middle = ch;
                }
            }
        }

        String right = new StringBuilder(left).reverse().toString();

        if(middle != '\0') {
            left.append(middle);
        }

        left.append(right);

        return left.toString();
    }
} 