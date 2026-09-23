class Solution {
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        int y=x;
        int reverse=0;
        while(y>0){
            reverse= reverse*10 + y%10;
            y=y/10;
        }
        if(x==reverse){
            return true;
        }
        return false;
    }
}