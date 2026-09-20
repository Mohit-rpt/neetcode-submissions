class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0 ; i<tokens.length;i++){
            if(tokens[i].equals("+") || 
                tokens[i].equals("-") || 
                tokens[i].equals("*") || 
                tokens[i].equals("/")){
                
                int right = stack.pop();
                int left = stack.pop();
                int result;
                if(tokens[i].equals("+")){
                    result = left + right;
                }else if(tokens[i].equals("-")){
                    result = left - right;
                }else if(tokens[i].equals("*")){
                    result = left * right;
                }else{
                    result = left/right;
                }
                stack.push(result);
            }else{
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }
}
