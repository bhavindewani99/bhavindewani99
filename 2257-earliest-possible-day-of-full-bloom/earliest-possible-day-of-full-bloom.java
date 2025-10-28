class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        
        List<Pair> list = new ArrayList<>();
        
        for(int i=0;i<plantTime.length;i++) list.add(new Pair(plantTime[i], growTime[i]));
        Collections.sort(list, (a,b) -> b.growthT - a.growthT);

        int nextPlantTime = 0;
        int maxBloomTime = 0;

        for(int i=0;i<growTime.length;i++){
            nextPlantTime += list.get(i).plantT;
            maxBloomTime = Math.max(maxBloomTime, nextPlantTime + list.get(i).growthT);
        }

        return maxBloomTime;
    }

    class Pair{
        int plantT, growthT;
        Pair(int plantT, int growthT){
            this.plantT = plantT;
            this.growthT = growthT;
        }
    }
}