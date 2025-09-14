class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> original = new HashSet();
        Map<String,String> capitalMap = new HashMap<>();
        Map<String,String> vowelMap = new HashMap<>();
        Set<Character> vowels = new HashSet(Arrays.asList('a','e','i','o','u'));
        String[] result = new String[queries.length];

        for(String word : wordlist){
            original.add(word);

            String smallWord = word.toLowerCase();
            if(!capitalMap.containsKey(smallWord)) capitalMap.put(smallWord,word);

            StringBuilder vowelWord = new StringBuilder();
            for(char c : smallWord.toCharArray()){
                if(vowels.contains(c)) vowelWord.append('*');
                else vowelWord.append(c);
            }
            String newVowelWord = vowelWord.toString();
            if(!vowelMap.containsKey(newVowelWord)) vowelMap.put(newVowelWord,word);
        }

        int index=0;
        for(String query : queries){

            String smallWord = query.toLowerCase();
            StringBuilder vowelWord = new StringBuilder();
            for(char c : smallWord.toCharArray()){
                if(vowels.contains(c)) vowelWord.append('*');
                else vowelWord.append(c);
            }
            String newVowelWord = vowelWord.toString();

            if(original.contains(query)) result[index] = query;
            else if(capitalMap.containsKey(smallWord)) result[index] = capitalMap.get(smallWord);
            else if(vowelMap.containsKey(newVowelWord)) result[index] = vowelMap.get(newVowelWord);
            else result[index] = "";
            index++;
            
        }
        return result;
    }
}