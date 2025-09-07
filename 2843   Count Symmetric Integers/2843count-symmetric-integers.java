class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int count = 0;

        for(int i=low; i<=high; i++) {
            String num = Integer.toString(i);
            int len = num.length();

            if(len % 2 != 0) continue;

            int s1 = 0, s2 = 0;

            for(int j=0; j<len/2; j++) {
                s1 += num.charAt(j) - '0';
                s2 += num.charAt(j + len/2) - '0';
            }

            if(s1 == s2) {
                count++;
            }

        }

        return count;
    }
} 