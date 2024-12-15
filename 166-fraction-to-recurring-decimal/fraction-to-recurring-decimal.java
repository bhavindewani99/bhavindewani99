class Solution {
    public String fractionToDecimal(int numerator, int denominator) {

        if(numerator==0) return "0";

        StringBuilder result = new StringBuilder();
        if((numerator<0) ^ (denominator<0)) result.append("-");
        long x = Math.abs((long) numerator);
        long y = Math.abs((long) denominator);

        result.append(x/y);
        long remainder = x%y;
        if(remainder==0) return result.toString();

        result.append(".");
        Map<Long, Integer> map = new HashMap<>();

        while(remainder!=0){
            if(map.containsKey(remainder)){
                result.insert(map.get(remainder), "(");
                result.append(")");
                break;
            }
            map.put(remainder, result.length());
            remainder *= 10;
            result.append(remainder/y);
            remainder %= y;
        }

        return result.toString();
    }
}