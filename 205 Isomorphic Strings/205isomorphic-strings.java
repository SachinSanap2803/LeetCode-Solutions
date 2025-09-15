// Brute force

// class Solution {
//     public boolean isIsomorphic(String s, String t) {
//         HashMap<Character, Character> sTot = new HashMap<>();
//         HashMap<Character, Character> tTos = new HashMap<>();

//         for(int i=0; i<s.length(); i++) {
//             char cs = s.charAt(i);
//             char ct = t.charAt(i);

//             if(sTot.containsKey(cs)) {
//                 if(sTot.get(cs) != ct) return false;
//             } else {
//                 sTot.put(cs, ct);
//             }

//             if(tTos.containsKey(ct)) {
//                 if(tTos.get(ct) != cs) return false;
//             } else {
//                 tTos.put(ct, cs);
//             }
//         }

//         return true;
//     }
// } 





// optimal Solution

class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] sTot = new int[256];
        int[] tTos = new int[256];

        for(int i=0; i<s.length(); i++) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);

            if(sTot[cs] == 0 && tTos[ct] == 0) {
                sTot[cs] = ct;
                tTos[ct] = cs;
            } else {
                if(sTot[cs] != ct || tTos[ct] != cs) {
                    return false;
                }
            }
        }

        return true;
    }
} 