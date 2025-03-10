class Solution {
    public long countOfSubstrings(String word, int k) {
        
        // So to findout exactly k we will use technique like atleast k and atleast k+1
        // so if we take difference of atleast k and atleast k+1 we get exactly k

        return countSubString(word, k) - countSubString(word, k+1);

    }

    private long countSubString(String word, int k){

        long result = 0;
        Set<Character> vowelSet = new HashSet<>(Arrays.asList('a','e','i','o','u'));
        Map<Character, Integer> vowelCount = new HashMap<>();
        int left = 0;
        int consonants = 0;

        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(vowelSet.contains(c)) vowelCount.put(c, vowelCount.getOrDefault(c, 0) + 1);
            else consonants++;

            while(vowelCount.size()==vowelSet.size() && consonants>=k){
                result += (word.length() - i);
                char leftChar = word.charAt(left++);
                if(vowelCount.containsKey(leftChar)) vowelCount.put(leftChar, vowelCount.get(leftChar) - 1);
                else consonants--;
                if(vowelCount.containsKey(leftChar) && vowelCount.get(leftChar)==0) vowelCount.remove(leftChar);
            }
        }
        return result;
    }
}