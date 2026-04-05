class Solution {
    public String longestCommonPrefix(String[] strs) {
        // Edge case: if the array is empty, return empty string
        if (strs == null || strs.length == 0) {
            return "";
        }

        // Start with the first string in the array as the initial prefix
        String prefix = strs[0];

        // Compare the prefix with the rest of the strings
        for (int i = 1; i < strs.length; i++) {
            // Keep reducing the prefix until it matches the start of the current string
            while (strs[i].indexOf(prefix) != 0) {
                // Shorten the prefix by removing the last character
                prefix = prefix.substring(0, prefix.length() - 1);

                // If the prefix becomes empty, there's no common prefix
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        // After checking all strings, return the final prefix
        return prefix;
    }
}
