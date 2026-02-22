// class Solution {
//     public int leastInterval(char[] tasks, int n) {
//         int[] freq = new int[26];

//         for(char task : tasks) {
//             freq[task - 'A']++;
//         }

//         int maxFreq = 0;
//         for(int f : freq) {
//             maxFreq = Math.max(maxFreq, f);
//         }

//         int maxCnt = 0;
//         for(int f : freq) {
//             if(f == maxFreq) {
//                 maxCnt++;
//             }
//         }

//         int frameSize = (maxFreq - 1) * (n + 1) + maxCnt;
        
//         return Math.max(frameSize, tasks.length);
//     }
// } 





// Max-Heap Solution

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(char t : tasks) {
            freq[t - 'A']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int f : freq) {
            if(f > 0) {
                maxHeap.add(f);
            }
        }

        int count = 0;

        while(!maxHeap.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int cycle = n + 1;   // Because after running a task, we must wait n time before running it again.
            
            int workDone = 0;   // how much tasks I'm able to schedule in each cycle

            for(int i=0; i<cycle; i++) {
                if(!maxHeap.isEmpty()) {
                    int curr = maxHeap.poll();
                    if(curr - 1 > 0) {
                        temp.add(curr - 1);
                    }

                    workDone++;
                }
            }

            for(int rem : temp) {
                maxHeap.add(rem);
            }

            count += maxHeap.isEmpty() ? workDone : cycle;
        }

        return count;
    }
} 