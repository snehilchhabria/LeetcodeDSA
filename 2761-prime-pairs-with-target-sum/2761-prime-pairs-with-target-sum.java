class Solution {
    public List<List<Integer>> findPrimePairs(int n) {
        
        List<List<Integer>> ans = new ArrayList<>();
        boolean [] isPrime = new boolean [n+1];
        int [] vis = new int[n+1];
        
        isPrime[1] = false;
        for(int i = 2; i<=n; i++){
            isPrime[i] = true;
        }
        
        for(int i =2; i*i<n; i++){
            if(isPrime[i] == true){
                for(int j=  i*i; j<n; j += i){
                    isPrime[j] = false;
                }
            }
        }
        for(int i=1;i<isPrime.length/2 +1; i++){
            if(n-i >= i && isPrime[i] && isPrime[n-i] && vis[i] == 0 && vis[n-i] ==  0){
                ans.add(List.of(i, n-i));
                vis[i] = 1;
                vis[n-i] = 1;
            }
        }
        return ans;
    }
}