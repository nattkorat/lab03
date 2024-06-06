import java.util.Stack;

public class Ex5 {
    static int stackCalculate(String strNum) { // error occur, will return 0 with error message
        String opterands = "+-*/";
        Stack<Integer> stack = new Stack<Integer>();
        for (String str : strNum.split(" ")) {
            if (opterands.contains(str) && !stack.empty()) {
                int last = (!stack.empty()) ? stack.pop() : 0;
                int first = (!stack.empty()) ? stack.pop() : 0;

                if (str.equals("+"))
                    stack.push(first + last);
                else if (str.equals("-"))
                    stack.push(first - last);
                else if (str.equals("*"))
                    stack.push(first * last);
                else if (str.equals("/") && last > 0)
                    stack.push(first / last);

            } else if (!str.equals("")) { // skip the spaces
                try {
                    stack.push(Integer.parseInt(str));
                } catch (NumberFormatException e) {
                    System.err.println(e);
                    return 0;
                }
            }
        }

        return (!stack.empty()) ? stack.pop() : 0;
    }

    public static void main(String[] args) {
        System.out.println(stackCalculate("1  2 +")); // 3
        System.out.println(stackCalculate("1 2 3 * + 4 +")); // 11
        System.out.println(stackCalculate("8 5 * 7 4 2 + * +")); // 82
        System.out.println(stackCalculate("6 8 2 / 1 - *")); // 18
        System.out.println(stackCalculate("1 -")); // -1
    }
}
