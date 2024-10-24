class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        
        List<int[]> res = new ArrayList<>();
    
        int i=0, j=0;

        while(i<firstList.length && j<secondList.length){
            if(secondList[j][0]<=firstList[i][1] && firstList[i][0]<=secondList[j][1]){
                int[] curr = {Math.max(firstList[i][0],secondList[j][0]), Math.min(firstList[i][1], secondList[j][1])};
                res .add(curr);
            }
            if(firstList[i][1]>secondList[j][1]){
                j++;
            }else {
                i++;
            }
        }
        int[][] finalResult = new int[res.size()][2];
        for( i=0;i<res.size();i++){
            finalResult[i] = res.get(i);
        }
        return finalResult;
    }
}