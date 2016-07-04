public class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0) {
            return 0;
        }
        List<String> list = new ArrayList<String>();
        list.add("+");
        list.add("-");
        list.add("*");
        list.add("/");
        
        Stack<Integer> stack = new Stack<Integer>();
        for(String str : tokens) {
            if(list.contains(str)) {
                if(stack.size() < 2) {
                    throw new NullPointerException(); 
                }
                Integer num2 = stack.pop();
                Integer num1 = stack.pop();
                long sum = 0;
                switch(str) {
                    case "+":
                        sum = num1 + num2;
                        break;
                    case "-":
                        sum = num1 - num2;
                        break;
                    case "*":
                        sum = num1 * num2;
                        break;
                    case "/":
                        sum = num1 / num2;
                        break;
                        
                }
                if(sum > Integer.MAX_VALUE) {
                    sum = Integer.MAX_VALUE;
                } else if(sum < Integer.MIN_VALUE) {
                    sum = Integer.MIN_VALUE;
                }
                stack.push((int)sum);
            } else if(isInteger(str)) {
                stack.push(Integer.parseInt(str));
            } else {
                throw new NumberFormatException();
            }
        }
        
        return stack.pop();
    }
    
    public boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
        } catch(Exception e) {
            return false;
        }
        return true;
    }
}