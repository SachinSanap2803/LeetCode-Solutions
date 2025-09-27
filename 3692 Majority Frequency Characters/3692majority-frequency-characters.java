class Solution {
    public String majorityFrequencyGroup(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        HashMap<Integer, List<Character>> group = new HashMap<>();
        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            int count = entry.getValue();
            group.putIfAbsent(count, new ArrayList<>());
            group.get(count).add(entry.getKey());
        }

        int maxSize = 0;
        int maxK = 0;

        for(Map.Entry<Integer, List<Character>> entry : group.entrySet()) {
            int k = entry.getKey();
            int size = entry.getValue().size();

            if(size > maxSize || (size == maxSize && k > maxK)) {
                maxSize = size;
                maxK = k;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(char ch : group.get(maxK)) {
            sb.append(ch);
        }

        return sb.toString();
    }
} 