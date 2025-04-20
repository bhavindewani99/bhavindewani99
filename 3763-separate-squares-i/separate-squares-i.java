class Solution {
    public double separateSquares(int[][] squares) {
        
        double low = Double.MAX_VALUE, high = Double.MIN_VALUE, precision = (double) 1e-5;

        for(int[] square : squares){
            low = Math.min(low, square[1]);
            high = Math.max(high, square[1] + square[2]);
        }

        while(high - low > precision){
            double mid = (low + high)/2;
            if(lowerAreaLarger(squares, mid)){
                high = mid;
            }else{
                low = mid;
            }
        }
        return low;
    }

    private boolean lowerAreaLarger(int[][] squares, double mid){
        double upperArea = 0, lowerArea = 0;

        for(int[] square : squares){
            double bottomY = square[1], topY = square[1] + square[2], side = square[2];

            if(topY <= mid) lowerArea += side*side;
            else if(bottomY >= mid) upperArea += side * side;
            else{
                double bottomLength = mid - bottomY;
                double topLength = topY - mid;
                upperArea += side * topLength;
                lowerArea += side * bottomLength;
            }
        }
        return lowerArea >= upperArea;
    }
}