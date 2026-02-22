class Solution {
    public boolean isDigitorialPermutation(int n) {
        int[] freq = getFreq(n);

        int[] digitorials = {1, 2, 145, 40585};

        for(int num : digitorials) {
            if(sameDigits(freq, getFreq(num))) {
                return true;
            }
        }

        return false;
    }

    private int[] getFreq(int n) {
        int[] f = new int[10];
        while(n > 0) {
            f[n % 10]++;
            n /= 10;
        }

        return f;
    }

    private boolean sameDigits(int[] a, int[] b) {
        for(int i=0; i<10; i++) {
            if(a[i] != b[i]) {
                return false;
            }
        }

        return true;
    }
} 