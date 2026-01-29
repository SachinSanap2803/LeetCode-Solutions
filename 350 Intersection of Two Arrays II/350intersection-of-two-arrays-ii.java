// Brute force

// class Solution {
//     public int[] intersect(int[] nums1, int[] nums2) {
//         Arrays.sort(nums1);
//         Arrays.sort(nums2);

//         int n1 = nums1.length;
//         int n2 = nums2.length;

//         int left = 0, right = 0;
//         int[] ans = new int[Math.min(n1, n2)];
//         int idx = 0;

//         while(left < n1 && right < n2) {
//             if(nums1[left] == nums2[right]) {
//                 ans[idx++] = nums1[left];
//                 left++; right++;
//             } else if(nums1[left] < nums2[right]) {
//                 left++;
//             } else {
//                 right++;
//             }
//         }

//         return Arrays.copyOf(ans, idx);
//     }
// } 








// Optimal Solution

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer> list = new ArrayList<>();
        for(int num : nums2) {
            if(map.containsKey(num) && map.get(num) > 0) {
                list.add(num);
                map.put(num, map.get(num)-1);
            }
        }

        int[] ans = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
            ans[i] = list.get(i);
        }

        return ans;
    }
} 