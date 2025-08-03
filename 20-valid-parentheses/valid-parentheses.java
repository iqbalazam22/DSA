class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '['){
                stack.push(s.charAt(i));
            }
            else{
                if(stack.isEmpty()) return false;
                char c = stack.pop();
                if(c == '(' && s.charAt(i) != ')') return false; 
                if(c == '{' && s.charAt(i) != '}') return false; 
                if(c == '[' && s.charAt(i) != ']') return false; 
                
            }
        }
        if(!stack.isEmpty()) return false;
        return true;
    }
}