class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> charmap = new HashMap<>();

        for (char c : magazine.toCharArray()) {
            charmap.put(c, charmap.getOrDefault(c, 0) + 1);
        }
        for(char i : ransomNote.toCharArray()){
            if(charmap.containsKey(i) && charmap.get(i)>0){
                charmap.put(i,charmap.get(i)-1);
            }else{
                return false;
            }
        }
        return true;
    }
}
