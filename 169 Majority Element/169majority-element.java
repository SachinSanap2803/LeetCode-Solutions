class Solution {
    public int majorityElement(int[] nums) {
        int currMajorityEle = 0;
        int count = 0;

        for(int num : nums) {
            if(count == 0) {
                currMajorityEle = num;
            }

            if(num == currMajorityEle) {
                count++;
            } else {
                count--;
            }
        }

        return currMajorityEle;
    }
} 




// class Solution {
//     public int majorityElement(int[] nums) {
//         HashMap<Integer, Integer> map = new HashMap<>();
//         int maxCount = 0;
//         int majorityEle = 0;

//         for(int num : nums) {
//             int count = map.getOrDefault(num, 0) + 1;

//             if(count > maxCount) {
//                 maxCount = count;
//                 majorityEle = num;
//             }
//         }

//         return majorityEle;
//     } 
// }