/* Binary Tree Node Structure
class Node {
    int data;
    Node left, right;

    public Node(int data){
        this.data = data;
    }
}
*/
class Solution {
    public int getCount(Node root, int k) {

        if (root == null) {
            return 0;
        }

        Queue<Node> q = new LinkedList<>();
        Queue<Integer> level = new LinkedList<>();

        q.offer(root);
        level.offer(1);

        ArrayList<Integer> costs = new ArrayList<>();

        while (!q.isEmpty()) {

            Node curr = q.poll();
            int currLevel = level.poll();

            if (curr.left == null && curr.right == null) {
                costs.add(currLevel);
            }

            if (curr.left != null) {
                q.offer(curr.left);
                level.offer(currLevel + 1);
            }

            if (curr.right != null) {
                q.offer(curr.right);
                level.offer(currLevel + 1);
            }
        }

    
        Collections.sort(costs);

        int count = 0;

        for (int cost : costs) {

            if (cost <= k) {
                k = k - cost;
                count++;
            } else {
                break;
            }
        }

        return count;
    }
}