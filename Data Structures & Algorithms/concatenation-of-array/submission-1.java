class Solution {
    public int[] getConcatenation(int[] nums) {

        int ans[] = new int[2 * nums.length];

        for(int count=0 , index=0; count<2; count++){
            for (int i=0 ; i<nums.length;i++){
                ans[index] = nums[i];
                index++;
            }
        }

        return ans;
        
    }
}