class Solution {
    public int jump(int[] nums) {
        if(nums.length == 1) return 0;
        int curEnd =0;
        int curFarthest = 0;
        int jumps = 0;
        
        for(int i=0; i< nums.length; i++){
            curFarthest = Math.max(curFarthest, i + nums[i]);
            if(i == curEnd){
                jumps ++;
                curEnd = curFarthest;
            }
            if(curEnd >= nums.length-1)break;
        }
        return jumps;
    }
}