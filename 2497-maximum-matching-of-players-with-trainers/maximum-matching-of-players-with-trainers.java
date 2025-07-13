class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        
        Arrays.sort(players);
        Arrays.sort(trainers);
        int playersIndex = 0, trainersIndex =0;

        while (playersIndex<players.length && trainersIndex<trainers.length) {
            if(players[playersIndex] <= trainers[trainersIndex]) playersIndex++;
            trainersIndex++;
        }

        return playersIndex;

    }
}