
class MinStack {

	private Stack<Integer> stack = new Stack<Integer>();
	private Stack<Integer> minStack = new Stack<Integer>();

	public void push(int x) {
		if (stack.isEmpty() || x <= minStack.peek()) {
			stack.push(x);
			minStack.push(x);
		} else {
			stack.push(x);
		}
	}

	public void pop() {
		if (!stack.isEmpty()) {
			int popedValue = stack.pop();
			if (popedValue == minStack.peek()) {
				minStack.pop();
			}
		} 
	}


	public int top() {
		return stack.isEmpty() ? 0 : stack.peek();
	}

	public int getMin() {
		return stack.isEmpty() ? 0 : minStack.peek();
	}
}
