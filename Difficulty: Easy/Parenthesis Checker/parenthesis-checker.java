
class Solution {
    public boolean isBalanced(String s) {

        Map<Character, Character> map = new HashMap<>();

        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            // Opening bracket
            if (!map.containsKey(c)) {
                stack.push(c);
            }

            // Closing bracket
            else {

                // No opening bracket available
                if (stack.isEmpty()) {
                    return false;
                }

                // Check whether brackets match
                if (stack.peek() == map.get(c)) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        // Stack should be empty
        return stack.isEmpty();
    }
}

