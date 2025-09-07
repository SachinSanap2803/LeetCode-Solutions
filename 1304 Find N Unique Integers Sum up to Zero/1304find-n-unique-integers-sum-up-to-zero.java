class Solution {
    public int[] sumZero(int n) {
        int[] arr = new int[n];
        int idx = 0;

        for(int i=1; i<=n/2; i++) {
            arr[idx++] = i;
            arr[idx++] = -i;
        }

        if(n % 2 != 0) {
            arr[idx] = 0;
        }

        return arr;
    }
} 