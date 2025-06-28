class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> leftPar = new Stack<>();
        Stack<Integer> stars = new Stack<>();

        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);

            if(ch == '(') {
                leftPar.push(i);
            } else if(ch == '*') {
                stars.push(i);
            } else {
                if(!leftPar.isEmpty()) {
                    leftPar.pop();
                } else if(!stars.isEmpty()) {
                    stars.pop();
                } else {
                    return false;
                }
            }
        }

        while(!leftPar.isEmpty() && !stars.isEmpty()) {
            if(leftPar.pop() > stars.pop()) {
                return false;     // * must be after '('
            }
        }

        return leftPar.isEmpty();
    }
} 