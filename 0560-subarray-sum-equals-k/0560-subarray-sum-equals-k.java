class Solution {
    public int subarraySum(int[] nums, int k) {
        int cnt=  0;
        
        
        for(int i = 0; i< nums.length; i++){
            int ans =0 ;
            for(int j=i; j<nums.length; j++){
                ans += nums[j];
                if(ans == k) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}