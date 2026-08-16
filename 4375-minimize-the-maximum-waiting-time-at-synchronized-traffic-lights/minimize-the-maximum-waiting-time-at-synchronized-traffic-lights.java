class Solution {
    public int minPenalty(int period, int[] lights, int[] arrivalTime) {
        int minPen = 0;
        int maxi = -1;

        for(int light : lights) {
            maxi = Math.max(maxi, light);
        }

        for(int i=0; i<arrivalTime.length; i++) {
            int r = arrivalTime[i] % period;

            if(r >= maxi) {
                int wt = period - r;
                
                minPen = Math.max(minPen, wt);
            }
        }

        return minPen;
    }
}