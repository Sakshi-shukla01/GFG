class Solution {
    public Queue<Integer> reverseFirstK(Queue<Integer> q, int k) {
        // code here'
        if(q.isEmpty() || k<=0 || k>q.size()){
            return q;
        }
        Stack<Integer> stack =new Stack<>();
        for(int i=0;i<k;i++){
            stack.push(q.poll());
        }
        while(!stack.isEmpty()){
            q.add(stack.pop());
        }
        int remainingElements=q.size()-k;
        for(int i=0;i<remainingElements;i++){
            q.add(q.poll());
        }
         return q;
    }
}