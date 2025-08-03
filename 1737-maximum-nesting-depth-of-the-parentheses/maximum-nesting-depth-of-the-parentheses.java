class Solution {
    public int maxDepth(String s) {
        Stack<Character> stack = new Stack<>();
        int count = 0, max = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '['){
                stack.push(s.charAt(i));
                count++;
                max = Math.max(max, count);
            }
            else if(s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']'){
                stack.pop();
                count--;
            }
        }
        return max;
    }
}