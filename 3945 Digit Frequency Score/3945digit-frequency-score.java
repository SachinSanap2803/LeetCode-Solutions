class Solution {
    public int digitFrequencyScore(int n) {
        HashMap<Integer, Integer> map = new HashMap<>();

        while(n > 0) {
            map.put(n % 10, map.getOrDefault(n % 10, 0) + 1);

            n /= 10;
        }

        int score = 0;

        for(int key : map.keySet()) {
            score += (key * map.get(key));
        }

        return score;
    }
} 