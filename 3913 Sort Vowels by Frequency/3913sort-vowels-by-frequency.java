class Solution {
    public String sortVowels(String s) {
        int n = s.length();

        String vowels = "aeiou";
        int[] freq = new int[5];
        int[] first = new int[5];
        Arrays.fill(first, -1);

        for(int i=0; i<n; i++) {
            char c = s.charAt(i);
            int index = vowels.indexOf(c);
            if(index != -1) {
                freq[index]++;
                if(first[index] == -1) {
                    first[index] = i;
                }
            }
        }

        List<Integer> order = new ArrayList<>();
        for(int i=0; i<5; i++) {
            if(freq[i] > 0) {
                order.add(i);
            }
        }

        Collections.sort(order, (a, b) -> {
            if(freq[b] != freq[a]) return freq[b] - freq[a];
            return first[a] - first[b];
        });

        List<Character> sortedVowels = new ArrayList<>();
        for(int index : order) {
            for(int k=0; k<freq[index]; k++) {
                sortedVowels.add(vowels.charAt(index));
            }
        }

        char[] res = s.toCharArray();
        int ptr = 0;

        for(int i=0; i<n; i++) {
            if(vowels.indexOf(res[i]) != -1) {
                res[i] = sortedVowels.get(ptr++);
            }
        }

        return new String(res);
    }
} 