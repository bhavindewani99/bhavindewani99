class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        
        List<Integer> result = new ArrayList<>();
        int wordLength = words[0].length();
        int totalWords = words.length;

        // build map from words array
        Map<String, Integer> wordMap = new HashMap<>();
        for(String word : words){
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }

        // Now there is fixed window size but starting points can be different because suppose wordLength is 4 so starting point can be 0, 1, 2, 3 so it will cover all the cases

        for(int i=0;i<wordLength;i++){
            int left = i;
            int count = 0;
            Map<String, Integer> windowMap = new HashMap<>();

            for(int right =i;right+wordLength <= s.length(); right += wordLength){
                String currWord = s.substring(right, right + wordLength);

                if(wordMap.containsKey(currWord)){
                    windowMap.put(currWord, windowMap.getOrDefault(currWord, 0) + 1);
                    count++;

                    while(windowMap.get(currWord) > wordMap.get(currWord)){
                        String leftWord = s.substring(left, left + wordLength);
                        windowMap.put(leftWord, windowMap.getOrDefault(leftWord, 0) - 1);
                        left += wordLength;
                        count--;
                    }

                    if(count == totalWords) result.add(left);
                }else{
                    windowMap.clear();
                    count = 0;
                    left = right + wordLength;
                }
            }
        }
        return result;
    }
}