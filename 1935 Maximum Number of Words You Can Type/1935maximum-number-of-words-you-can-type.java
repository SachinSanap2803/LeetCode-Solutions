// Brute force - O(n * k)

// class Solution {
//     public int canBeTypedWords(String text, String brokenLetters) {
//         int count = 0;
        
//         String[] words = text.split(" ");
//         for(String word : words) {
//             boolean canType = true;
//             for(int i=0; i<brokenLetters.length(); i++) {
//                 char ch = brokenLetters.charAt(i);
//                 if(word.indexOf(ch) != -1) {
//                     canType = false;
//                     break;
//                 }
//             }
//             if(canType) {
//                 count++;
//             }
//         }

//         return count;
//     }
// } 





// Optimal Solution

class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        int count = 0;
        HashSet<Character> set = new HashSet<>();
        for(char ch : brokenLetters.toCharArray()) {
            set.add(ch);
        }
        
        String[] words = text.split(" ");
        for(String word : words) {
            boolean canType = true;
            for(char ch : word.toCharArray()) {
                if(set.contains(ch)) {
                    canType = false;
                    break;
                }
            }
            if(canType) {
                count++;
            }
        }

        return count;
    }
} 