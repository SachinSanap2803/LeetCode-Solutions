class Solution {
    public int elevatorRequests(int n, int[] requests) {
        int floor = 0;
        int time = 0;

        for(int request : requests) {
            time += Math.abs(request - floor);
            floor = request;
        }

        return time;
    }
} 