// Brute force

// class Solution {
//     public int totalFruit(int[] fruits) {
//         int maxi = 0;
//         int n = fruits.length;
//         int distinct = 0;

//         for(int i=0; i<n; i++) {
//             HashSet<Integer> set = new HashSet<>();
//             for(int j=i; j<n; j++) {
//                 set.add(fruits[j]);
//                 if(set.size() > 2) {
//                     break;
//                 }
                
//                 maxi = Math.max(maxi, j-i+1);
//             }
//         }

//         return maxi;
//     }
// } 






// Optimal Solution

class Solution {
    public int totalFruit(int[] fruits) {
        int maxi = 0;
        int n = fruits.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int l=0, r=0;

        while(r < n) {
            map.put(fruits[r], map.getOrDefault(fruits[r], 0) + 1);

            if(map.size() > 2) {
                map.put(fruits[l], map.get(fruits[l])-1);
                if(map.get(fruits[l]) == 0) {
                    map.remove(fruits[l]);
                }
                l++;
            }

            if(map.size() <= 2) {
                maxi = Math.max(maxi, r-l+1);
            }
            
            r++;
        }

        return maxi;
    }
} 