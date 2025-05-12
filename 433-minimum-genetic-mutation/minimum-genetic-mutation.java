class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        
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