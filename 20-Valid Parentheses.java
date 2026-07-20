import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        // If the length is odd, it's impossible to have balanced brackets
        if (s.length() % 2 != 0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            // Push the corresponding closing bracket onto the stack when an opening bracket is found
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else {
                // If it's a closing bracket, it must match the top of the stack
                if (stack.isEmpty() || stack.pop() != c) {
                    return false;
                }
            }
        }

        // The string is valid only if all brackets have been matched and popped
        return stack.isEmpty();
    }
}
