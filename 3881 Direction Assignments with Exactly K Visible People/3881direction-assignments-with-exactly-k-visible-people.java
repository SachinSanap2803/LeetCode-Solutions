class Solution {
    static final int MOD = 1_000_000_007;
    long[] fact, invFact;
    
    public int countVisiblePeople(int n, int pos, int k) {
        int L = pos;
        int R = n - pos - 1;

        init(n);

        long ans = 0;

        for(int i=0; i<=k; i++) {
            if(i<=L && (k-i)<=R) {
                long ways = nCr(L, i) * nCr(R, k-i) % MOD;
                ans = (ans + ways) % MOD;
            }
        }

        ans = (ans * 2) % MOD;

        return (int) ans;
    }

    void init(int n) {
        fact = new long[n+1];
        invFact = new long[n+1];

        fact[0] = 1;
        for(int i=1; i<=n; i++) {
            fact[i] = fact[i-1] * i % MOD;
        }

        invFact[n] = modInverse(fact[n]);
        for(int i=n-1; i>=0; i--) {
            invFact[i] = invFact[i+1] * (i+1) % MOD;
        }
    }

    long nCr(int n, int r) {
        if(r < 0 || r > n) return 0;
        return fact[n] * invFact[r] % MOD * invFact[n-r] % MOD;
    }

    long modInverse(long x) {
        return pow(x, MOD-2);
    }

    long pow(long base, int exp) {
        long res = 1;
        while(exp > 0) {
            if((exp & 1) == 1) {
                res = res * base % MOD;
            }

            base = base * base % MOD;
            exp >>= 1;
        }

        return res;
    }
} 