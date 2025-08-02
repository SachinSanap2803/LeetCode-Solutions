class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int minTime = Integer.MAX_VALUE;

        for(int i=0; i<landStartTime.length; i++) {
            for(int j=0; j<waterStartTime.length; j++) {
                // land ride first, then water ride
                int landFinish = landStartTime[i] + landDuration[i];
                int waterRideStart = Math.max(landFinish, waterStartTime[j]);
                int totalTime1 = waterRideStart + waterDuration[j];

                // water ride first, then land ride
                int waterFinish = waterStartTime[j] + waterDuration[j];
                int landRideStart = Math.max(waterFinish, landStartTime[i]);
                int totalTime2 = landRideStart + landDuration[i];

                // update minimum time
                minTime = Math.min(minTime, Math.min(totalTime1, totalTime2));
            }
        }

        return minTime;
    }
} 