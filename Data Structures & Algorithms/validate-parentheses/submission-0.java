

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            // If it's an opening bracket, push corresponding closing bracket
            if (ch == '(') stack.push(')');
            else if (ch == '{') stack.push('}');
            else if (ch == '[') stack.push(']');
            else {
                // If stack is empty or top doesn't match current char, return false
                if (stack.isEmpty() || stack.pop() != ch) return false;
            }
        }

        // Stack should be empty if all brackets matched correctly
        return stack.isEmpty();
    }
}
