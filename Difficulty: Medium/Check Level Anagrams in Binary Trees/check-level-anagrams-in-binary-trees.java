/* Structure of binary tree Node
class Node {
    public int data;
    public Node left, right;

    public Node(int x) {
        data = x;
        left = right = null;
    }
}
*/

class Solution {
    public boolean areAnagrams(Node root1, Node root2) {

        Queue<Node> q1 = new LinkedList<>();
        Queue<Node> q2 = new LinkedList<>();

        q1.add(root1);
        q2.add(root2);

        while (!q1.isEmpty() && !q2.isEmpty()) {

            int size1 = q1.size();
            int size2 = q2.size();

            if (size1 != size2) {
                return false;
            }

            ArrayList<Integer> list1 = new ArrayList<>();
            ArrayList<Integer> list2 = new ArrayList<>();

            for (int i = 0; i < size1; i++) {
                Node curr = q1.poll();

                list1.add(curr.data);

                if (curr.left != null) {
                    q1.add(curr.left);
                }

                if (curr.right != null) {
                    q1.add(curr.right);
                }
            }

            for (int i = 0; i < size2; i++) {
                Node curr = q2.poll();

                list2.add(curr.data);

                if (curr.left != null) {
                    q2.add(curr.left);
                }

                if (curr.right != null) {
                    q2.add(curr.right);
                }
            }

            Collections.sort(list1);
            Collections.sort(list2);

            if (!list1.equals(list2)) {
                return false;
            }
        }

        if (!q1.isEmpty() || !q2.isEmpty()) {
            return false;
        }

        return true;
    }
}