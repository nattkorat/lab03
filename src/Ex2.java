import java.util.Stack;

public class Ex2 {
    static boolean isValidParenthesis(String str) {
        Stack<Character> stack_p = new Stack<Character>();
        Stack<Character> stack_b = new Stack<Character>();

        for (char character : str.toCharArray()) {
            if (character == '(')
                stack_p.push(character);
            if (character == ')') {
                if (stack_p.empty())
                    return false;
                else {
                    stack_p.pop();
                }
            }
            if (character == '[')
                stack_b.push(character);
            if (character == ']') {
                if (stack_b.empty())
                    return false;
                else {
                    stack_b.pop();
                }
            }
        }
        if (stack_p.empty() && stack_b.empty())
            return true;

        return false;
    }

    public static void main(String[] args) {
        System.out.println(isValidParenthesis("( [He] llo)"));
    }
}
