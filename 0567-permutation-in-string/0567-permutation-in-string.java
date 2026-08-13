class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n= s1.length();
        int m = s2.length();
        if (n > m) {
            return false;
        }
        int[] s1count = new int[26];
        int[] s2count = new int[26];
        for(int i=0 ; i<n;i++){
            s1count[s1.charAt(i)-'a']++;
            s2count[s2.charAt(i)-'a']++;
        }
        if(Arrays.equals(s1count,s2count)){
            return true;
        }
        for(int i =n ; i<m; i++){
            s2count[s2.charAt(i)-'a']++;
            s2count[s2.charAt(i-n)-'a']--;
            if(Arrays.equals(s1count,s2count)){
                return true;
            }

        }
        return false;
    }
}