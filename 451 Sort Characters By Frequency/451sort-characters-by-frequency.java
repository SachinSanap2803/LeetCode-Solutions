// Brute force

// class Solution {
//     public String frequencySort(String s) {
//         int n = s.length();

//         HashMap<Character, Integer> map = new HashMap<>();
//         for(int i=0; i<n; i++) {
//             char ch = s.charAt(i);
//             if(map.containsKey(ch)) {
//                 map.put(ch, map.get(ch) + 1);
//             } else {
//                 map.put(ch, 1);
//             }
//         }

//         PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());
//         maxHeap.addAll(map.entrySet());

//         StringBuilder sb = new StringBuilder();
        
//         while(!maxHeap.isEmpty()) {
//             Map.Entry<Character, Integer> entry = maxHeap.poll();
//             char ch = entry.getKey();
//             int freq = entry.getValue();

//             for(int i=0; i<freq; i++) {
//                 sb.append(ch);
//             }
//         }

//         return sb.toString();
//     }
// } 






// Optimal Solution - Bucket Sort

class Solution {
    public String frequencySort(String s) {
        int n = s.length();

        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++) {
            char ch = s.charAt(i);
            if(map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }

        List<Character>[] bucket = new List[n+1];
        for(char ch : map.keySet()) {
            int freq = map.get(ch);
            if(bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(ch);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=n; i>=1; i--) {
            if(bucket[i] != null) {
                for(char ch : bucket[i]) {
                    for(int j=0; j<i; j++) {
                        sb.append(ch);
                    }
                }
            }
        }

        return sb.toString();
    }
} 