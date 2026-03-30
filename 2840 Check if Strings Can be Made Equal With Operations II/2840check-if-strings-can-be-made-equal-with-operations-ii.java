class Solution {
    public boolean checkStrings(String s1, String s2) {
        int n = s1.length();

        char[] s1Even = new char[26];
        char[] s1Odd = new char[26];
        char[] s2Even = new char[26];
        char[] s2Odd = new char[26];

        for(int i=0; i<n; i++) {
            if(i % 2 == 0) {
                s1Even[s1.charAt(i) - 'a']++;
                s2Even[s2.charAt(i) - 'a']++;
            } else {
                s1Odd[s1.charAt(i) - 'a']++;
                s2Odd[s2.charAt(i) - 'a']++;
            }
        }

        for(int i=0; i<26; i++) {
            if(s1Even[i] != s2Even[i] || s1Odd[i] != s2Odd[i]) {
                return false;
            }
        }

        return true;
    }
} 