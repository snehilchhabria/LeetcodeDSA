class Solution {
    public int countPrimes(int n) {
        
        if(n == 0 || n == 1) return 0;
        int cnt =0;
        
        boolean[] isPrime = new boolean[n+1];
        
        isPrime[1] = false;
        
        for(int i = 2; i<=n; i++){
            isPrime[i] = true;
        }
        for(int i = 2; i*i < n; i++){
            if(isPrime[i]){
                for(int j = i*i; j<=n; j += i){
                    isPrime[j] = false;
                }
            }
        }
        for(int i =1; i<= n; i++){
            if(isPrime[i] && i<n) cnt += 1;
        }
        return cnt;
        
    }
}