class Solution {
    public int maximumPopulation(int[][] logs) {

        int[] population = new int[101];
        int maximumPopulation = 0, resultYear = 1950;

        for(int[] log : logs){
            int birthYear = log[0] - 1950;
            int deathYear = log[1] - 1950;
            population[birthYear]++;
            population[deathYear]--;
        }

        maximumPopulation = population[0];
        for(int i=1;i<101;i++){
            population[i] += population[i-1];
            if(maximumPopulation < population[i]){
                resultYear = i + 1950;
                maximumPopulation = population[i];
            }
        }

        return resultYear;
    }
}