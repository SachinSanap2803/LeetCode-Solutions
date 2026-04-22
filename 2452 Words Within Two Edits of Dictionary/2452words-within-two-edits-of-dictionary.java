class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> res = new ArrayList<>();
        int n = queries.length;
        int m = dictionary.length;

        for(int i=0; i<n; i++) {
            String s1 = queries[i];
            for(int j=0; j<m; j++) {
                int count = 0;
                String s2 = dictionary[j];
                int k = 0;
                while(k < s2.length()) {
                    if(s1.charAt(k) != s2.charAt(k)) {
                        count++;

                        if(count > 2) {
                            break;
                        }
                    }

                    k++;
                }
                if(count <= 2) {
                    res.add(s1);
                    break;
                }
            }
        }

        return res;
    }
} 