class Solution {
    public int digitSum(int num) {
        int sum = 0;

        while(num > 0) {
            sum += num % 10;
            num /= 10;
        }

        return sum;
    }

    public int minSwaps(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<n; i++) {
            map.put(nums[i], i);
        }

        Integer[] sorted = Arrays.stream(nums).boxed().toArray(Integer[]::new);

        Arrays.sort(sorted, (a, b) -> {
            int sumA = digitSum(a);
            int sumB = digitSum(b);

            if(sumA != sumB) {
                return sumA - sumB;
            }

            return a - b;
        });

        boolean[] visited = new boolean[n];
        int swaps = 0;

        for(int i=0; i<n; i++) {
            if(visited[i]) {
                continue;
            }

            int j = i;
            int cycleSize = 0;

            while(!visited[j]) {
                visited[j] = true;
                cycleSize++;

                j = map.get(sorted[j]);
            }

            swaps += Math.max(0, cycleSize - 1);
        }

        return swaps;
    }
} 