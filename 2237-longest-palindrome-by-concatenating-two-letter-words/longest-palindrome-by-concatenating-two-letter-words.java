class Solution {
    public int longestPalindrome(String[] words) {
        
        Map<String, Integer> map = new HashMap<>();
        boolean usedMiddle = false;
        int maxMiddle = 0;
        int maxLength = 0;

        for(String word : words) map.put(word, map.getOrDefault(word, 0) + 1);

        for(String word : words){
            String reverseString = new StringBuilder(word).reverse().toString();

            if(map.containsKey(word) && map.containsKey(reverseString) &&  word.equals(reverseString) == false){
                maxLength += 4;
                map.put(word, map.get(word) - 1);
                map.put(reverseString, map.get(reverseString) - 1);
                if(map.get(word) == 0) map.remove(word);
                if(map.get(reverseString) == 0) map.remove(reverseString);
            }else if(word.equals(reverseString) && map.containsKey(word)){
                if(map.get(word) >= 2){
                    int count = map.get(word) / 2;
                    maxLength += count*4;
                    
                    if(map.get(word) % 2 == 0) map.remove(word);
                    else map.put(word, 1);
                }
                if(map.getOrDefault(word, 0) > 0 ) usedMiddle = true;
            }
        }

        return usedMiddle ? maxLength + 2 : maxLength;

    }
}