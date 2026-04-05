class Solution {

    public String mergeAlternately(String word1, String word2) {

        // StringBuilder is used because strings are immutable in Java
        // and repeated concatenation would be expensive
        StringBuilder result = new StringBuilder();

        // Pointers for both strings
        int wi = 0;
        int wj = 0;

        // Traverse both strings while both have characters left
        while (wi < word1.length() && wj < word2.length()) {

            // Append character from word1
            result.append(word1.charAt(wi));

            // Append character from word2
            result.append(word2.charAt(wj));

            // Move both pointers
            wi++;
            wj++;
        }

        // If word1 still has characters remaining
        if (wi < word1.length()) {

            while (wi < word1.length()) {
                result.append(word1.charAt(wi));
                wi++;
            }

        } 
        // If word2 still has characters remaining
        else {

            while (wj < word2.length()) {
                result.append(word2.charAt(wj));
                wj++;
            }

        }

        // Convert StringBuilder to String
        return result.toString();
    }
}