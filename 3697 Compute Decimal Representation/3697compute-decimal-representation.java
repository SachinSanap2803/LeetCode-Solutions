class Solution { 
    public int[] decimalRepresentation(int n) { 
        List<Integer> result = new ArrayList<>();

        // Convert n into string
        String s = String.valueOf(n);
        int len = s.length();

        for(int i=0; i<len; i++) {
            int digit = s.charAt(i) - '0';
            if(digit != 0) {
                int power = len - i -1;
                result.add(digit * (int)Math.pow(10, power));
            }
        }

        // convert to int[]
        int[] ans = new int[result.size()];
        for(int i=0; i<result.size(); i++) {
            ans[i] = result.get(i);
        }

        return ans;
    } 
} 