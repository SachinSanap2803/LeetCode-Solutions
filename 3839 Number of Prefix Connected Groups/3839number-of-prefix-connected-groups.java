class Solution {
    public int prefixConnected(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();

        for(String word : words) {
            if(word.length() < k) {
                continue;
            }

            String prefix = word.substring(0, k);
            map.put(prefix, map.getOrDefault(prefix, 0) + 1);
        }

        int cnt = 0;
        for(int val : map.values()) {
            if(val >= 2) {
                cnt++;
            }
        }

        return cnt;
    }
} 