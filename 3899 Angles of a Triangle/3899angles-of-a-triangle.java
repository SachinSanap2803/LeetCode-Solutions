class Solution {
    public double[] internalAngles(int[] sides) {
        double a = sides[0];
        double b = sides[1];
        double c = sides[2];

        if(a+b <= c || a+c <= b || b+c <= a) {
            return new double[0];
        }

        double B = Math.acos((b*b + c*c - a*a) / (2*b*c));
        double C = Math.acos((a*a + c*c - b*b) / (2*a*c));
        double A = Math.acos((a*a + b*b - c*c) / (2*a*b));

        A = Math.toDegrees(A);
        B = Math.toDegrees(B);
        C = Math.toDegrees(C);

        double[] ans = new double[]{A, B, C};
        Arrays.sort(ans);

        return ans;
    }
} 