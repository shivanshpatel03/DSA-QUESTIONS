class Solution {
    public String removeDuplicateLetters(String s) {
        int[] freq= new int[26];
        for(char c:s.toCharArray()){
            freq[c-'a']++;
        }
        Deque<Character> stack =new ArrayDeque<>();
        boolean[] seen = new boolean[26];
        for(char c:s.toCharArray()){
            freq[c-'a']--;
            if(seen[c-'a']){
                continue;
            }
            while(!stack.isEmpty()&& stack.peek()>c && freq[stack.peek()-'a']>0){
                char removed=stack.pop();
                seen[removed-'a']=false;
            }
            stack.push(c);
            seen[c-'a']=true;
        }
        StringBuilder sb =new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();


        
        
    }
}