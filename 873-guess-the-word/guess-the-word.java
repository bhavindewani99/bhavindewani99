

/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface Master {
 *     public int guess(String word) {}
 * }
 */
class Solution {
    public void findSecretWord(String[] words, Master master) {
        Random ran = new Random();
        ArrayList<String> possibles = new ArrayList<>();
        for (String word : words){
            possibles.add(word);
        }
        int trials = 0;
        while (trials < 30){
            int index = ran.nextInt(possibles.size());
            String testWord = possibles.get(index);
            int matches = master.guess(testWord);
            if (matches == 6)
                return;
            ArrayList<String> newPossibles = new ArrayList<>();
            for (String word : possibles){
                if (getMatches(testWord, word) == matches){
                    newPossibles.add(word);
                }
            }
            possibles = newPossibles;
            trials++;
        }

    }

    private int getMatches(String guess, String word){
        int matches =0;
        for(int i=0;i<6;i++){
            if(guess.charAt(i)==word.charAt(i)) matches++;
        }
        return matches;
    }
}