class Solution {
    public List<Long> mergeAdjacent(int[] nums) {
        List<Long> st = new ArrayList<>();

        for(int num : nums) {
            st.add((long) num);

            while(st.size() >= 2) {
                int n = st.size();
                long a = st.get(n-1);
                long b = st.get(n-2);

                if(a != b) break;

                // merge
                st.remove(n-1);
                st.remove(n-2);
                st.add(a+b);
            }
        }

        return st;
    }
} 