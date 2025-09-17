class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int count = 0;
        int n = s.length();

        for(int i=0; i<n; i++) {
            char ch = s.charAt(i);
            int currVal = map.get(ch);

            if(i<n-1 && currVal < map.get(s.charAt(i+1))) {
                count -= currVal;
            } else {
                count += currVal;
            }
        }

        return count;
    }
} 