public class MinStack {
// implement pop, push, top, getMin in constant time
/*
1. we need a stack and a minStack
2. push: when push a new value, called s, if s < current_min(min stack top), push s to the minstack
3. pop: if the value poped equals to current_ min, then pop the minstack
4. top: same
5. getMin() : top of minStack
*/
	private Stack<Integer> stack = new Stack<Integer>();
	private Stack<Integer> minStack = new Stack<Integer>();

	public void push(int x) {
		stack.push(x);
		if (minStack.isEmpty() || x <= minStack.peek()) {
			minStack.push(x);
		}
	}

	public void pop() {
		if (!stack.isEmpty()) {
			int top = stack.pop();

			if (top == minStack.peek()) {
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