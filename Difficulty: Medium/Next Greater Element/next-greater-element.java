
class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {

        int n = arr.length;

        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {

            // Remove elements that are not greater
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }

            // Find next greater element
            if (stack.isEmpty()) {
                ans.add(-1);
            } else {
                ans.add(stack.peek());
            }

            // Add current element
            stack.push(arr[i]);
        }

        Collections.reverse(ans);

        return ans;
    }
}
