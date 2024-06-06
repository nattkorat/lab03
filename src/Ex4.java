import java.util.Stack;

public class Ex4 {
    static boolean ABC(String str) {
        Stack<Character> stackA = new Stack<Character>();
        Stack<Character> stackB = new Stack<Character>();
        Stack<Character> stackC = new Stack<Character>();
        for (char character : str.toLowerCase().toCharArray()) {
            if (character == 'a') {
                if (stackB.empty() || stackC.empty())
                    stackA.push(character);
                else {
                    stackB.pop();
                    stackC.pop();
                }
            }
            if (character == 'b') {
                if (stackA.empty() || stackC.empty())
                    stackB.push(character);
                else {
                    stackA.pop();
                    stackC.pop();
                }
            }
            if (character == 'c') {
                if (stackA.empty() || stackB.empty())
                    stackC.push(character);
                else {
                    stackA.pop();
                    stackB.pop();
                }
            }

        }
        if (stackA.empty() && stackB.empty() && stackC.empty())
            return true;

        return false;

    }

    public static void main(String[] args) {
        System.out.println(ABC("CABBBCAC"));
    }
}
