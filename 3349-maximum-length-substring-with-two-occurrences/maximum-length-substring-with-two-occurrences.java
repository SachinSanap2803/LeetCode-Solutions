class Solution {
    public int maximumLengthSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        int maxi = 0;

        for(right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);

            map.put(ch, map.getOrDefault(ch, 0) + 1);

            while(map.get(ch) > 2) {
                map.put(s.charAt(left), map.get(s.charAt(left))-1);
                left++;
            }

            maxi = Math.max(maxi, right - left + 1);
        }

        return maxi;
    }
} 