class Solution {
    public String longestCommonPrefix(String[] strs) {

        // Edge case: empty array
        if (strs == null || strs.length == 0) {
            return "";
        }

        // Sort strings lexicographically
        Arrays.sort(strs);

        // First and last strings after sorting
        String first = strs[0];
        String last  = strs[strs.length - 1];

        // Compare characters of first and last string
        int minLength = Math.min(first.length(), last.length());

        for (int i = 0; i < minLength; i++) {

            // If characters differ, return prefix up to this index
            if (first.charAt(i) != last.charAt(i)) {
                return first.substring(0, i);
            }
        }

        // All characters matched up to minLength
        return first.substring(0, minLength);
    }
}
