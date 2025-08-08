class Solution {
    private static final int MAX_N = 100_000;
    private static final int MOD = 1_234_567;
    
    private int[] memo = new int[MAX_N + 1]; 

    public int solution(int n) {
        return fibo(n);
    }

    private int fibo(int n) {
        if (n <= 1) {
            return n;
        }

        if (memo[n] != 0) {
            return memo[n];
        }

        memo[n] = (fibo(n - 1) + fibo(n - 2)) % MOD;
        
        return memo[n];
    }
    
}