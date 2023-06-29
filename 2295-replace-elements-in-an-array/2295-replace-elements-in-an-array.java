class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {
        HashMap<Integer,Integer> map=new HashMap<>();
        
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        
        for(int i=0;i<operations.length;i++){
            int oldNum=operations[i][0];
            int newNum=operations[i][1];
            
            if(map.containsKey(oldNum)){
                int index=map.get(oldNum);
                nums[index]=newNum;
                
                map.put(newNum,index);
            }
        }
        return nums;
    }
}