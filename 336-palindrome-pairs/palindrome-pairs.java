class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        
        List<List<Integer>> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        for(int i=0;i<words.length;i++){
            map.put(words[i], i);
        }

        // If Empty String is Present
        if(map.containsKey("")){
            for(String word : map.keySet()){
                if(isPalindrom(word) && word.equals("")==false){
                    result.add(new ArrayList<>(Arrays.asList(map.get(""), map.get(word))));
                    result.add(new ArrayList<>(Arrays.asList(map.get(word), map.get(""))));
                }
            }
        }

        // Reflection Case like abcd so dcba is Present or not
        for(String word : words){
            String reverseWord = new StringBuilder(word).reverse().toString();
            if(map.containsKey(reverseWord) && map.get(word)!=map.get(reverseWord)){
                result.add(new ArrayList<>(Arrays.asList(map.get(word), map.get(reverseWord))));
            }
        }

        // Now breaking each string and checking if one part is palindrome after breaking and does the reverse of another part is present or not for example lls will be breaked into ll and s and ll is palindrome and s is also palindrome so we can make a pair
        for(String word : words){
            for(int cut = 1;cut<word.length();cut++){
                String leftPart = word.substring(0, cut);
                String rightPart = word.substring(cut);

                // if leftPart is palindrome
                if(isPalindrom(leftPart)){
                    String rightPartReverse = new StringBuilder(rightPart).reverse().toString();
                    if(map.containsKey(rightPartReverse)){
                        result.add(new ArrayList<>(Arrays.asList(map.get(rightPartReverse), map.get(word))));
                    }
                }

                // if rightPart is palindrome
                if(isPalindrom(rightPart)){
                    String leftPartReverse = new StringBuilder(leftPart).reverse().toString();
                    if(map.containsKey(leftPartReverse)){
                        result.add(new ArrayList<>(Arrays.asList(map.get(word), map.get(leftPartReverse))));
                    }
                }
            }
        }

        return result;
    }

    private boolean isPalindrom(String word){
        int i=0, j=word.length()-1;

        while(i<j){
            if(word.charAt(i)!=word.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}