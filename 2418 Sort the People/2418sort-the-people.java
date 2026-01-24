// Brute force

// class Solution {
//     public String[] sortPeople(String[] names, int[] heights) {
//         TreeMap<Integer, String> map = new TreeMap<>(Collections.reverseOrder());
//         int n = names.length;

//         for(int i=0; i<n; i++) {
//             map.put(heights[i], names[i]);
//         }

//         int idx = 0;
//         for(String name : map.values()) {
//             names[idx++] = name;
//         }

//         return names;
//     }
// } 






// Optimal Solution

class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        Integer[] idx = new Integer[n];

        for(int i=0; i<n; i++) {
            idx[i] = i;
        }

        Arrays.sort(idx, (a, b) -> heights[b] - heights[a]);

        String[] res = new String[n];
        for(int i=0; i<n; i++) {
            res[i] = names[idx[i]];
        }

        return res;
    }
} 