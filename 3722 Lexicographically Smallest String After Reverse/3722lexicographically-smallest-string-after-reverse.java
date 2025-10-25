class Solution {

    private void reverse(char[] arr, int i, int j) {
        while(i < j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
    
    public String lexSmallest(String s) {
        int n = s.length();
        String best = null;
        char[] arr = s.toCharArray();

        for(int k=1; k<=n; k++) {
            // Prefix
            reverse(arr, 0, k-1);
            String s1 = new String(arr);
            if(best == null || s1.compareTo(best) < 0) {
                best = s1;
            }
            // Revert
            reverse(arr, 0, k-1);

            // Suffix
            reverse(arr, n-k, n-1);
            String s2 = new String(arr);
            if(s2.compareTo(best) < 0) {
                best = s2;
            }
            // Revert
            reverse(arr, n-k, n-1);
        }

        return best;
    }
} 