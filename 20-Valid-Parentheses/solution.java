public class Solution {
    public boolean isValid(String s) {
        if(s == null || s.length() == 0){
            return true;
        }
        
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if(stack.isEmpty()){
                stack.push(c);
                continue;
            }
            
            
            if( (c == ')' && stack.peek() == '(') || (c == ']' && stack.peek() == '[' ) || ( c == '}' && stack.peek() == '{') ){
                stack.pop();
            }else{
                stack.push(c);
            }
        }
        
        return stack.isEmpty();
    }
}