class Solution {
    public int prefixCount(String[] words, String pref) {

       int result = 0;
       for(String word : words){
        boolean startsWith = true;
        if(word.length()>=pref.length()){
            for(int i=0;i<pref.length();i++){
                if(word.charAt(i)!=pref.charAt(i)){
                    startsWith=false;
                    break;
                }
            }
            if(startsWith) result++;
        }
       } 
       return result;
    }
}