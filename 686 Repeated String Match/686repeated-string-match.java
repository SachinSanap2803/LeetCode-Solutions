class Solution {
    public int repeatedStringMatch(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int count = 0;

        while (sb.length() < b.length()) {
            sb.append(a);
            count++;
        }

        if (kmp(sb.toString(), b) != -1) {
            return count;
        }

        sb.append(a);

        if (kmp(sb.toString(), b) != -1) {
            return count + 1;
        }

        return -1;
    }

    public int kmp(String str, String pat) {
        int len1 = str.length();
        int len2 = pat.length();

        int[] lps = new int[len2];
        computeLPS(pat, len2, lps);

        int i = 0, j = 0;
        while (i < len1) {
            if (str.charAt(i) == pat.charAt(j)) {
                i++;
                j++;

                if (j == len2) {
                    return i - j;
                }
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        return -1;
    }

    public void computeLPS(String pat, int n, int[] lps) {
        int i = 1, j = 0;
        lps[0] = 0;

        while (i < n) {
            if (pat.charAt(i) == pat.charAt(j)) {
                j++;
                lps[i] = j;
                i++;
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
    }
}