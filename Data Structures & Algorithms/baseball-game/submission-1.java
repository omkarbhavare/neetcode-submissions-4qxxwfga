

class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();

        for (String op : operations) {
            if (op.equals("C")) {
                stack.pop(); // Invalidate last score
            } else if (op.equals("D")) {
                stack.push(stack.peek() * 2); // Double the last score
            } else if (op.equals("+")) {
                int top = stack.pop();
                int newTop = top + stack.peek(); // Sum of last two scores
                stack.push(top); // Push back the one we popped
                stack.push(newTop); // Push new score
            } else {
                stack.push(Integer.parseInt(op)); // Regular score
            }
        }

        // Sum all scores in stack
        int sum = 0;
        for (int score : stack) {
            sum += score;
        }

        return sum;
    }
}
