class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        int mini = Integer.MAX_VALUE;
        int cnt1 = 0, cnt2 = 0;

        for(int i=startIndex; cnt1 < n; i = (i+1) % n) {
            if(!words[i].equals(target)) {
                cnt1++;
            } else {
                break;
            }
        }

        mini = Math.min(mini, cnt1);

        for(int i=startIndex; cnt2 < n; i = (i-1+n) % n) {
            if(!words[i].equals(target)) {
                cnt2++;
            } else {
                break;
            }
        }

        mini = Math.min(mini, cnt2);

        return mini == n ? -1 : mini;
    }
} 