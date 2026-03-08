// Cantor's diagonalization argument 

class Solution {
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<nums.length; i++) {
            
            // Flip the ith bit of the ith string
            sb.append(nums[i].charAt(i) == '0' ? '1' : '0');
        }

        return sb.toString();
    }
} 