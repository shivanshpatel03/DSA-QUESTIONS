class Solution {
    public String maxSumOfSquares(int num, int sum) {
        int[] result=new int[num];
        int n=num;
        int k=sum;
        for(int i=0;i<num;i++){
            if(k>=9&&n>0){
                result[i]=9;
                k=k-9;
                n--;
            }else if(k<9&&n>0){
                result[i]=k;
                k=k-k;
                n--;
                break;
            }
        }
        if(k>0&&n==0){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int digit : result) {
            sb.append(digit);
        }
        
        return sb.toString();
        
    }
}