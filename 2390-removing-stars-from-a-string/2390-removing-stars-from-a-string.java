class Solution {
    public String removeStars(String s) {
        Deque<Character> stack=new ArrayDeque<>();
        for(char c: s.toCharArray()){
            if(c=='*'&&!stack.isEmpty()){
                stack.pop();
                continue;
            }
            stack.push(c);
        }
        StringBuilder sb =new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
        
    }
}