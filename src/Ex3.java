import java.util.Stack;

public class Ex3 {
    static boolean AIsEqualB(String str) {
        Stack<Character> stackA = new Stack<Character>();
        Stack<Character> stackB = new Stack<Character>();
        for (char character : str.toLowerCase().toCharArray()) {
            if (character == 'a') {
                if (stackB.empty())
                    stackA.push(character);
                else
                    stackB.pop();
            }
            if (character == 'b') {
                if (stackA.empty())
                    stackB.push(character);
                else
                    stackA.pop();
            }
        }
        if (stackA.empty() && stackB.empty())
            return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(AIsEqualB("BAabBAbA")); // true
    }
}
