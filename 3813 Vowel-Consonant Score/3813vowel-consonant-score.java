class Solution {
    public int vowelConsonantScore(String s) {
        int vowel = 0, consonant = 0;
        for(char ch : s.toCharArray()) {
            if(ch >= 'a' && ch <= 'z') {
                if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    vowel++;
                } else {
                    consonant++;
                }
            }
        }

        if(consonant == 0) {
            return 0;
        } else {
            return (int) Math.floor(vowel/consonant);
        }
    }
} 