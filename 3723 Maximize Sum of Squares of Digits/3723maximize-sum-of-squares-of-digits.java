class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if(sum > 9*num || sum < 0) return "";

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<num; i++) {
            for(int d=9; d>=0; d--) {
                if(sum-d >= 0 && (sum-d) <= 9 * (num-i-1)) {
                    sb.append(d);
                    sum -= d;
                    break;
                }
            }
        }

        if(sum != 0) return "";
        return sb.toString();
    }
} 