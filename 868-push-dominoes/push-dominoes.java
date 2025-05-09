class Solution {
    public String pushDominoes(String dominoes) {
        // Instead of processing '.' we process 'L' and 'R' what they will do
        // If we are at 'L' it can push to previous one
        // If we are at 'R' it can to push to its right but we have to handle one case
        // If we are at 'R' and next is '.' and next is 'L' so nothing will happen

        Queue<Pair> queue = new LinkedList<>();
        StringBuilder result = new StringBuilder(dominoes);
        int n = dominoes.length();

        for(int i=0;i<n;i++){
            if(dominoes.charAt(i) != '.') queue.offer(new Pair(dominoes.charAt(i), i));
        }

        while(!queue.isEmpty()){
            char currChar = queue.peek().c;
            int currIndex = queue.peek().index;
            queue.poll();

            if(currChar == 'L'){
                if(currIndex - 1 >= 0 && result.charAt(currIndex-1) == '.') {
                    result.setCharAt(currIndex-1, 'L');
                    queue.offer(new Pair('L', currIndex-1));
                }
            }else{
                if(currIndex + 1 < n && result.charAt(currIndex+1) == '.'){
                    if(currIndex + 2 < n && result.charAt(currIndex+2) == 'L'){
                        queue.poll(); // because the '.' will have to stand staright if we dont pop the next element in the queue will be 'L' and it will make it fall
                    }else{
                        result.setCharAt(currIndex+1, 'R');
                        queue.offer(new Pair('R', currIndex+1));
                    }
                }
            }
        }

        return result.toString();
    }


    class Pair{
        char c;
        int index;
        Pair(char c , int index){
            this.c = c;
            this.index = index;
        }
    }
}