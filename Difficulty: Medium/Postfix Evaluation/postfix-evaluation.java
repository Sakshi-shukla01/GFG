import java.util.*;

class Solution {
    public int evaluatePostfix(String[] arr) {

        Stack<Integer> stack = new Stack<>();

        for (String s : arr) {

            if (s.equals("+") || s.equals("-") ||
                s.equals("*") || s.equals("/") ||
                s.equals("^")) {

                int b = stack.pop();
                int a = stack.pop();

                int result = 0;

                if (s.equals("+")) {
                    result = a + b;
                }
                else if (s.equals("-")) {
                    result = a - b;
                }
                else if (s.equals("*")) {
                    result = a * b;
                }
                else if (s.equals("/")) {
                    result = Math.floorDiv(a, b);
                }
                else if (s.equals("^")) {
                    result = (int)Math.pow(a, b);
                }

                stack.push(result);

            } else {

              
                stack.push(Integer.parseInt(s));
            }
        }

        return stack.pop();
    }
}