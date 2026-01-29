class Solution {
    public List<String> summaryRanges(int[] nums) {
        int n = nums.length;
        List<String> res = new ArrayList<>();
        
        if(n == 0) return res;
        
        int start = nums[0];
        int end = nums[0];

        for(int i=1; i<n; i++) {
            if(end+1 != nums[i]) {
                if(start == end) {
                    res.add(start + "");
                } else {
                    res.add(start + "->" + end);
                }

                start = nums[i];
            }
            
            end = nums[i];
        }

        if(start == end) {
            res.add(start + "");
        } else {
            res.add(start + "->" + end);
        }

        return res;
    }
} 