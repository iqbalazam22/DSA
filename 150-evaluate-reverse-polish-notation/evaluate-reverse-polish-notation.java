class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        int n = tokens.length;
        for(int i = 0; i < n; i++){
            if(tokens[i].equals("+")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(a+b);
            }
            else if(tokens[i].equals("-")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b-a);
            }
            else if(tokens[i].equals("*")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(a*b);
            }
            else if(tokens[i].equals("/")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b/a);
            }else
            stack.push(Integer.parseInt(tokens[i]));
        }
        return stack.pop();
    }
}