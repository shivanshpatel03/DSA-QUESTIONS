class Solution {
    private Integer [][] memo;
    private int lcs(String txt1, String txt2, int i,int j){
        if(i<0 || j<0){
            return 0;
        }
        if(memo[i][j]!=null){
            return memo[i][j];
        }
        int res;
        if(txt1.charAt(i)==txt2.charAt(j)){
            res= 1+lcs(txt1,txt2,i-1,j-1);
        }else{
            res= Math.max(lcs(txt1,txt2,i-1,j),lcs(txt1,txt2,i,j-1));
        }
        memo[i][j]=res;
        return res;
        
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        memo=new Integer[m][n];
        return lcs(text1,text2,m-1,n-1);
    }
}