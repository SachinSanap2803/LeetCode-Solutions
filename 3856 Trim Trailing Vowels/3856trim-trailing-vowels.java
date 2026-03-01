class Solution {
    public String trimTrailingVowels(String s) {
        int n = s.length();
        int stop = -1;

        for(int i=n-1; i>=0; i--) {
            if(!isVowel(s.charAt(i))) {
                stop = i;
                break;
            }
        }

        if(stop == -1) {
            return "";
        } else {
            return s.substring(0, stop+1);
        }
    }

    private boolean isVowel(char ch) {
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
            return true;
        } else {
            return false;
        }
    }
} 