class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        
        // We are doing BFS from the starting string we are trying each possible by replacing each character with all 4 possible characters if present in the bank then only we process
        // so at worst case we do this for each word in the bank and for each word we can do 32 permutations as length will be always 8 and possible characters is 4 so time complexity is O(n*32)
        Set<String> givenBank = new HashSet<>();
        char[] possible = {'A','C','G','T'};

        for(String word : bank) givenBank.add(word);

        if(givenBank.contains(endGene)==false) return -1;
        givenBank.remove(startGene);

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(startGene, 0));

        while (!queue.isEmpty()) {
            String currWord = queue.peek().word;
            int currOperation = queue.peek().operation;
            queue.poll();

            if(currWord.equals(endGene)) return currOperation;

            char[] arr = currWord.toCharArray();

            for(int i=0;i<8;i++){
                char temp = arr[i];
                for(int j=0;j<4;j++){
                    arr[i] = possible[j];
                    String newWord = new String(arr);
                    if(givenBank.contains(newWord)){
                        givenBank.remove(newWord);
                        queue.offer(new Pair(newWord, currOperation + 1));
                    }
                }
                arr[i] = temp;
            }
        }

        return -1;
    }

    class Pair{
        String word;
        int operation ;
        Pair(String word, int operation){
            this.word = word;
            this.operation = operation;
        }
    }
}