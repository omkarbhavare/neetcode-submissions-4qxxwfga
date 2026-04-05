class Solution {
    public boolean hasDuplicate(int[] nums) {

        HashSet<Integer> hash = new HashSet<>();

        for(int num:nums){
            if(!hash.contains(num)){
                hash.add(num);
            }else{
                return true;
            }
        }
        return false;
    }
}