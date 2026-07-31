class Solution:
    def minimumPushes(self, word: str) -> int:
        freq = [0] * 26

        for ch in word:
            freq[ord(ch) - ord('a')] += 1
        
        freq.sort()

        ans = 0
        push = 1
        cnt = 0

        for i in range(25, -1, -1):
            if freq[i] == 0:
                break
            
            ans += freq[i] * push
            cnt += 1

            if cnt == 8:
                push += 1
                cnt = 0
            
        return ans