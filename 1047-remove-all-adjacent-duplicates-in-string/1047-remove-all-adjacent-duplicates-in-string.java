class Solution {
    public String removeDuplicates(String s) {
        int n = s.length();
        Deque<Character> stack = new ArrayDeque<>();
        for(char c: s.toCharArray()){
            if(!stack.isEmpty()&& stack.peek()==c){
                stack.pop();
            }else{
                stack.push(c);
            }
        }
        StringBuilder result = new StringBuilder();
        for(char c: stack){
            result.append(c);
        }
        return result.reverse().toString();
    }
}