class Solution {
    public int majorityElement(int[] nums) {

        Arrays.sort(nums);

        int majorityElem = nums[0];
        int vote = 1;

        for( int i=1; i<nums.length ; i++ ){
            if(nums[i] == majorityElem){
                vote++;
            }else{
                vote--;
                if(vote == 0){
                    majorityElem=nums[i];
                    vote++;
                }
            }
        }

        return majorityElem;
        
    }
}