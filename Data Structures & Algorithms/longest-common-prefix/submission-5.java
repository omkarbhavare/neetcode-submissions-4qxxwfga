class Solution{
public String longestCommonPrefix(String[] strs) {

    // If array is empty or null, no common prefix possible
    if (strs == null || strs.length == 0)
        return "";

    // Assume first string is the common prefix initially
    String prefix = strs[0];

    // Compare prefix with every other string
    for (int i = 1; i < strs.length; i++) {

        // While current string does NOT start with prefix
        // means prefix is too long or incorrect
        while (!strs[i].startsWith(prefix)) {

            // Reduce prefix by removing last character
            // because longer prefix cannot match
            prefix = prefix.substring(0, prefix.length() - 1);

            // If prefix becomes empty, no common prefix exists
            if (prefix.isEmpty())
                return "";
        }
    }

    // After checking all strings, prefix is the longest common prefix
    return prefix;
}
}