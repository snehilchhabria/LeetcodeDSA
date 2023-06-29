class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        HashSet<Integer> set = new HashSet<>();
        for(int num : banned){
            set.add(num);
        }
        int i = 1 ,sum =0, cnt =0;
        while(i <= n){
            if(!set.contains(i) && i + sum <= maxSum){
                sum += i;
                cnt+=1;
            }
            i++;
        }
        
        return cnt;
    }
}