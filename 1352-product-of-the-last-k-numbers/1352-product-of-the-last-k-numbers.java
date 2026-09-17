class ProductOfNumbers {
    private List<Integer> prefix;

    public ProductOfNumbers() {
        prefix=new ArrayList<>();
        prefix.add(1);
    }
    
    public void add(int num) {
        if(num==0){
            prefix =new ArrayList<>(List.of(1));
        }else{
            int last = prefix.get(prefix.size()-1);
            prefix.add(last*num);
        }
        
    }
    
    public int getProduct(int k) {
        int n=prefix.size();
        if(k>=n){
            return 0;
        }
        int result = prefix.get(n-1)/prefix.get(n-1-k);
        return result;
        
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */