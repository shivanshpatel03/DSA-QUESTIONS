class Solution {
    public String destCity(List<List<String>> paths) {
        int n = paths.size();
        Set<String> set = new HashSet<>();
        for(int i =0 ; i<n;i++){
            set.add(paths.get(i).get(0));
        }
        for(int i = 0 ; i<n ; i++){
            String k = paths.get(i).get(1);
            if(!set.contains(k)){
                return k;
            }
        }
        return "";
    }
}