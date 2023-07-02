class Solution {
    public int commonFactors(int a, int b) {
        int cnt = 0;
        HashSet<Integer> set = new HashSet<>();
        
        for(int i = 1; i<=a; i++){
            if(a%i == 0) set.add(i);
        }
         
        for(int i = 1; i<=b; i++){
            if(b%i == 0){
                if(set.contains(i)) cnt += 1;
                
            }
        }
        return cnt;
    }
}