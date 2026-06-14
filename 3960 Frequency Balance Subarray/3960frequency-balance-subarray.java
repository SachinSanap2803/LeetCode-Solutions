class Solution {
    public int getLength(int[] nums) {
        int n = nums.length;
        int ans = 1;

        for(int i=0; i<n; i++) {
            HashMap<Integer, Integer> freq = new HashMap<>();
            HashMap<Integer, Integer> freqCnt = new HashMap<>();
            int distinct = 0;

            for(int j=i; j<n; j++) {
                int x = nums[j];
                
                int oldFreq = freq.getOrDefault(x, 0);
                
                if(oldFreq == 0) {
                    distinct++;
                } else {
                    int cnt = freqCnt.get(oldFreq);
                    if(cnt == 1) {
                        freqCnt.remove(oldFreq);
                    } else {
                        freqCnt.put(oldFreq, cnt-1);
                    }
                }

                int newFreq = oldFreq+1;
                freq.put(x, newFreq);
                freqCnt.put(newFreq, freqCnt.getOrDefault(newFreq, 0) + 1);

                if(isBalanced(distinct, freqCnt)) {
                    ans = Math.max(ans, j-i+1);
                }
            }
        }

        return ans;
    }

    private boolean isBalanced(int distinct, HashMap<Integer, Integer> freqCnt) {
        if(distinct == 1) {
            return true;
        }

        if(freqCnt.size() != 2) {
            return false;
        }

        Iterator<Integer> it = freqCnt.keySet().iterator();
        int a = it.next();
        int b = it.next();

        int low = Math.min(a, b);
        int high = Math.max(a, b);

        return high == 2 * low;
    }
} 