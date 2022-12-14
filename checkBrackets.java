import java.util.Stack;

class CheckBrackets {

    public static void main(String[] args) {
        testString("{([])}");
        testString("{([)}[]");
        testString("(())))");
        testString("[[[]]");
    }

    private static void testString(String testString) {
        System.out.println("Test string - " + testString);
        if (checkString(testString)) {
            System.out.println("String is valid");
        } else {
            System.out.println("String is not valid");
        }
    }

    private static Boolean checkString(String input) {
        Boolean result = true;

        Stack<Character> b = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            Character s = input.charAt(i);
            if (s == '(' || s == '[' || s == '{') {
                b.push(s);
            } else {
                if (b.isEmpty()) {
                    return false;
                } else {
                    Character check = b.pop();

                    if (check == '(' && s == ')' || check == '[' && s == ']' || check == '{' && s == '}') {
                        continue;
                    } else {
                        return false;
                    }
                }
            }
        }

        if (!b.empty()) {
            return false;
        }

        return result;
    }
}