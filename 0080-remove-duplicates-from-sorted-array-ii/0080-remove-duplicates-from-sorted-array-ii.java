class Solution {
    public int removeDuplicates(int[] nums) {
        int k = nums.length;
        
        int l =0;
        int r = 0;
        int cnt = 0;
        
        while(l < nums.length && r < nums.length){
            
            if(nums[l] == nums[r] && cnt<2){
                cnt++;
                r++;
            }
            else if(nums[l] == nums[r]){
                nums[r] = Integer.MIN_VALUE;
                k -= 1;
                r++;
            }
            else{
                l=r;
                cnt =0;
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int num : nums){
            if(num != Integer.MIN_VALUE) {
                list.add(num);
            }
        }
        for(int i=0; i<list.size(); i++){
            nums[i] = list.get(i);
        }
        return k;
    }
}