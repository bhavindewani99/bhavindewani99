class Solution {
    public String toGoatLatin(String sentence) {
        StringBuilder result = new StringBuilder();
        StringBuilder atLast = new StringBuilder("maa");
        Set<Character> set = new HashSet<>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));

        String[] arr = sentence.split(" ");

        for(String word : arr){
            char c = word.charAt(0);
            if(set.contains(c)){
                result.append(word);
            }else{
                result.append(word.substring(1));
                result.append(c);
            }
            result.append(atLast+" ");
            atLast.append("a");
        }
        result.deleteCharAt(result.length()-1);
        return result.toString();
    }
}