class Solution {
    int[] bfs(ArrayList<ArrayList<Integer>> adj, int start) {
        int n = adj.size();
        int[] dist = new int[n];
        Arrays.fill(dist, -1);

        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        dist[start] = 0;

        int farthest = start;

        while (!q.isEmpty()) {
            int u = q.poll();

            for (int v : adj.get(u)) {
                v--;

                if (dist[v] == -1) {
                    dist[v] = dist[u] + 1;
                    q.add(v);

                    if (dist[v] > dist[farthest])
                        farthest = v;
                }
            }
        }

        return new int[]{farthest, dist[farthest]};
    }

    public int partyHouse(ArrayList<ArrayList<Integer>> adj) {
        int a = bfs(adj, 0)[0];       // find farthest house
        int diameter = bfs(adj, a)[1]; // find diameter

        return (diameter + 1) / 2;
    }
}