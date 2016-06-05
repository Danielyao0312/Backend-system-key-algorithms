class MyQueue {
    private Stack<Integer> inbox = new Stack<>();
    private Stack<Integer> outbox = new Stack<>();
    
    // Push element x to the back of queue.
    public void push(int x) {
        inbox.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if(outbox.isEmpty()){
            while(!inbox.isEmpty()) {
                int cur = inbox.pop();
                outbox.push(cur);
            }
        }
        outbox.pop();
    }

    // Get the front element.
    public int peek() {
        if(outbox.isEmpty()){
            while(!inbox.isEmpty()) {
                int cur = inbox.pop();
                outbox.push(cur);
            }
        }
        return outbox.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return outbox.isEmpty() && inbox.isEmpty();
    }
}
