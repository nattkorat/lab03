import java.util.Stack;

public class Ex1 {
    static boolean isValidParenthesis(String str) {
        Stack<Character> stack = new Stack<Character>();

        for (char character : str.toCharArray()) {
            if (character == '(')
                stack.push(character);

            if (character == ')') {
                if (stack.empty())
                    return false;
                else
                    stack.pop();
            }
        }
        if (stack.empty())
            return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isValidParenthesis("(())"));
    }

}
