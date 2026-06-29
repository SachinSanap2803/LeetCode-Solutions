class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int n = patterns.length;
        int m = word.length();
        int count = 0;

        for(int i=0; i<n; i++) {
            if(patterns[i].length() <= m) {
                if(word.contains(patterns[i])) {
                    count++;
                }
            }
        }

        return count;
    }
} 