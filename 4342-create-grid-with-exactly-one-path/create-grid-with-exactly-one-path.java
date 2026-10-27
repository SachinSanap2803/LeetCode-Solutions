class Solution {
    public String[] createGrid(int m, int n) {
        String[] res = new String[m];

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++) {
            sb.append(".");
        }

        res[0] = sb.toString();

        sb.delete(0, sb.length());

        for(int i=1; i<m; i++) {
            for(int j=0; j<n-1; j++) {
                sb.append("#");
            }
            sb.append(".");

            res[i] = sb.toString();

            sb.delete(0, sb.length());
        }

        return res;
    }
} 