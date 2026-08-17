class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new ArrayList<>();
        if (s == null || words == null || words.length == 0) return list;

        int n = s.length();
        int m = words.length;
        int k = words[0].length();
        int totallen = m * k;
        if(n<totallen) return list; 

        HashMap<String,Integer> map = new HashMap <>();
        for(String w : words){
            map.put(w,map.getOrDefault(w,0)+1);
        }

        for(int i =0 ; i<k ;i++){
            Map<String, Integer> seen = new HashMap<>();
            int left =i;
            int count =0;
            for(int j =i ; j<=n-k ;j+=k){
                String word = s.substring(j,j+k);
                if(map.containsKey(word)){
                    seen.put(word,seen.getOrDefault(word,0)+1);
                    count++;
                    
                    while(seen.get(word)> map.get(word)){
                        String leftw = s.substring(left,left+k);
                        seen.put (leftw, seen.get(leftw)-1);
                        count--;
                        left+=k;
                    }
                    if(count == m){
                        list.add(left);
                    }
                }else{
                    seen.clear();
                    count =0;
                    left = j+k;
                }

            }
        }
        return list;
        
    }
}