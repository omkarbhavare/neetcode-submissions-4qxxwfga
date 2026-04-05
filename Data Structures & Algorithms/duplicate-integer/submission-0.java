// import java.util.*;

class Solution {
    public boolean hasDuplicate(int[] nums) {
 
     Set<Integer> seen = new HashSet<>(nums.length);

     for(int num:nums){
        if(seen.contains(num)){
            return true;
        }

        seen.add(num);
     }

     return false;
    }
}
