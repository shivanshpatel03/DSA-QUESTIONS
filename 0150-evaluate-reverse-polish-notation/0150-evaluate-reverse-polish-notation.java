class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack=new ArrayDeque<>();
        for(int i =0 ; i<tokens.length ;i++){
            if(tokens[i].equals("+")||tokens[i].equals("-")||tokens[i].equals("*")||tokens[i].equals("/")){
                String token = tokens[i];
                int a=stack.pop();
                int b = stack.pop();
                switch(token){
                    case "+": stack.push(b+a);break;
                    case "-": stack.push(b-a);break;
                    case "*": stack.push(b*a);break;
                    case "/": stack.push(b/a);break;
                }
            }else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }
}