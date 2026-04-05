class Solution {
    public String longestCommonPrefix(String[] strs) {

        Arrays.sort(strs);

        int size = strs.length;

        

        for(int i = 0; i<strs[0].length();i++){
            char ch1 = strs[0].charAt(i);
            char ch2 = strs[strs.length-1].charAt(i);

            if(!(ch1 == ch2)){
                return strs[0].substring(0,i);
            }
        }

        return strs[0];
        
    }
}