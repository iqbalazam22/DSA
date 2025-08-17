class MinStack {
    List<Integer> list;
    Stack<Integer> stack = new Stack<>();
    public MinStack() {
       list = new ArrayList<>();
    }
    
    public void push(int val) {
        list.add(val);
        if(stack.isEmpty()){
            stack.push(val);
        }else{
            stack.push(Math.min(stack.peek(), val));
        }
    }
    
    public void pop() {
        list.remove(list.size()-1);
        stack.pop();
    }
    
    public int top() {
        return list.get(list.size()-1);
    }
    
    public int getMin() {
        return stack.peek();
    }
    
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */