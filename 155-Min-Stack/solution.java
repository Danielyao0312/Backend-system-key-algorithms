
class MinStack {

	Stack<Integer> stack = new Stack<>();
	Stack<Integer> minStack = new Stack<>();
        
    public void push(int x) {
    	stack.push(x);
    	if(minStack.isEmpty() || x <= minStack.peek()){
    		minStack.push(x);
    	}
    }

    public void pop() {
    	if(stack.isEmpty()) return;
    	
        int top = stack.pop();
        
        if(!minStack.isEmpty() && top == minStack.peek()){
        	minStack.pop();
        }
        	
    }

    public int top() {
        return stack.isEmpty() ? 0 : stack.peek();
    }

    public int getMin() {
        return stack.isEmpty() ? 0 : minStack.peek();
    }
}
