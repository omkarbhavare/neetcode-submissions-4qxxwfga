class Solution {
    public int majorityElement(int[] nums) {

        int maxNum = nums[0], count=1;

        for(int num: nums){

            if(count == 0){
                maxNum = num;
            }

            if(num != maxNum){
                count--;
            }else{
                count++;
            }
        }

        return maxNum;
        
    }
}