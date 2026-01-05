class MagicDictionary {
    String[] dictionary;
    public MagicDictionary() {
        
    }
    
    public void buildDict(String[] dictionary) {
        this.dictionary = dictionary;
    }
    
    public boolean search(String searchWord) {
        for(String word : dictionary){
            if(diff(word, searchWord) == 1) return true;
        }
        return false;
    }

    private int diff(String word, String searchWord){
        int currDiff = 0;
        if(word.length() != searchWord.length()) return 0;
        for(int i=0;i<searchWord.length();i++){
            if(word.charAt(i) != searchWord.charAt(i)) currDiff++;
        }
        return currDiff;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */