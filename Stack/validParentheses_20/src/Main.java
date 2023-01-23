import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        // stack problem
        // only push closing bracket into stack, when run into closing bracket, Stack.pop() only if it matches
        // if it doesnt match return false -- invalid
        // stack must be empty in the end to be valid
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }
}
