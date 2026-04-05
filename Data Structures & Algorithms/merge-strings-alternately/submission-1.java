class Solution {
    public String mergeAlternately(String word1, String word2) {


        StringBuilder result = new StringBuilder();
        int wi=0;
        int wj=0;

        while(wi<word1.length() && wj<word2.length()){
            result.append(word1.charAt(wi));
            result.append(word2.charAt(wj));
            wi++;
            wj++;
        }

        if(wi<word1.length()){
            while(wi<word1.length()){
                result.append(word1.charAt(wi));
                wi++;
            }
        }else{
            while(wj<word2.length()){
                result.append(word2.charAt(wj));
                wj++;
            }
        }

        return result.toString();
    }
}