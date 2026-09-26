class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        int n = s.length();
        int m = knowledge.size();
        StringBuilder sb = new StringBuilder();
        Map<String, String> map = new HashMap<>();

        for(int i=0; i<m; i++) {
            map.put(knowledge.get(i).get(0), knowledge.get(i).get(1));
        }

        int i = 0;

        while(i < n) {
            if(i<n && s.charAt(i) != '(') {
                sb.append(s.charAt(i));
                i++;
            } else {
                i++;

                StringBuilder key = new StringBuilder();
                while(i<n && s.charAt(i) != ')') {
                    key.append(s.charAt(i));
                    i++;
                }

                i++;

                String val = map.get(key.toString()) != null ? map.get(key.toString()) : "?";
                sb.append(val);
            }
        }

        return sb.toString();
    }
} 