class Solution {

    public boolean validPalindrome(String s) {

        int left = 0;
        int right = s.length() - 1;

        // Move pointers toward center
        while (left < right) {

            // If characters match → continue normally
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } 
            else {
                // If mismatch happens, we can delete ONE character.
                // Two possibilities:
                // 1) Skip left character
                // 2) Skip right character

                return isPalindrome(s, left + 1, right) 
                    || isPalindrome(s, left, right - 1);
            }
        }

        return true;
    }

    // Helper function to check if substring is palindrome
    private boolean isPalindrome(String s, int left, int right) {

        while (left < right) {

            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}