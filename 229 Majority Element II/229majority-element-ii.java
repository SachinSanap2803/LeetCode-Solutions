// Brute force

// class Solution {
//     public List<Integer> majorityElement(int[] nums) {
//         List<Integer> ans = new ArrayList<>();
//         int n = nums.length;
        
//         for(int i=0; i<n; i++) {
//             if(ans.size() == 0 || ans.get(0) != nums[i]) {
//                 int count = 0;
//                 for(int j=i; j<n; j++) {
//                     if(nums[j] == nums[i]) {
//                         count++;
//                     }
//                 }

//                 if(count > n/3) {
//                     ans.add(nums[i]);
//                 }

//                 if(ans.size() == 2) {
//                     return ans;
//                 }
//             }
//         }

//         return ans;
//     }
// }




// Better Solution

// class Solution {
//     public List<Integer> majorityElement(int[] nums) {
//         List<Integer> ans = new ArrayList<>();
//         HashMap<Integer, Integer> map = new HashMap<>();

//         int min = (nums.length / 3) + 1;

//         for(int num : nums) {
//             map.put(num, map.getOrDefault(num, 0) + 1);

//             if(map.get(num) == min) {
//                 ans.add(num);
//             }

//             if(ans.size() == 2) {
//                 return ans;
//             }
//         }
//         return ans;
//     }
// } 






// Optimal Solution

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int cnt1 = 0, cnt2 = 0;
        int ele1 = Integer.MIN_VALUE;
        int ele2 = Integer.MIN_VALUE;

        for(int num : nums) {
            if(cnt1 == 0 && num != ele2) {
                cnt1 = 1;
                ele1 = num;
            } else if(cnt2 == 0 && ele1 != num) {
                cnt2 = 1;
                ele2 = num;
            } else if(ele1 == num) {
                cnt1++;
            } else if(ele2 == num) {
                cnt2++;
            } else {
                cnt1--;
                cnt2--;
            }
        }

        cnt1 = 0; 
        cnt2 = 0;
        for(int num : nums) {
            if(ele1 == num) cnt1++;
            if(ele2 == num) cnt2++;
        }

        int min = nums.length / 3;
        if(cnt1 > min) ans.add(ele1);
        if(cnt2 > min) ans.add(ele2);

        return ans;
    }
} 