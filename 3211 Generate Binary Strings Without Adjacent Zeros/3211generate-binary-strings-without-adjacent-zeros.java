class Solution {

    public void generate(int n, String curr, List<String> res) {
        if(curr.length() == n) {
            res.add(curr);
            return;
        }

        if(curr.isEmpty() || curr.charAt(curr.length()-1) != '0') {
            generate(n, curr + "0", res);
        }

        generate(n, curr + "1", res);
    }

    public List<String> validStrings(int n) {
        List<String> res = new ArrayList<>();
        generate(n, "", res);

        return res;
    }
} 