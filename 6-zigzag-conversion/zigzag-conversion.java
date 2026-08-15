class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1 || numRows >= s.length()) {
            return s;
        }

        StringBuilder[] rows = new StringBuilder[numRows];

        for(int i=0; i<numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int row = 0;
        int direction = 1;

        for(char ch : s.toCharArray()) {
            rows[row].append(ch);

            if(row == numRows-1) {
                direction = -1;
            } else if(row == 0) {
                direction = 1;
            }

            row += direction;
        }

        StringBuilder ans = new StringBuilder();

        for(StringBuilder sb : rows) {
            ans.append(sb);
        }

        return ans.toString();
    }
} 