class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder sb = new StringBuilder();
        int n = words.length;
        int m = weights.length;
        int sum = 0;

        for(String word : words) {
            sum = 0;

            for(char ch : word.toCharArray()) {
                sum =( sum + weights[ch - 'a']) % 26;
            }

            char mapped = (char) ('z' - sum);
            sb.append(mapped);
        }

        return sb.toString();
    }
} 