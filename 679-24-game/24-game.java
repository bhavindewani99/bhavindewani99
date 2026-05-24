class Solution {
    double epsilon = 0.001;
    public boolean judgePoint24(int[] card) {
        
        List<Double> cards = new ArrayList<>();
        for(int x : card) cards.add(1.0 * x);

        return recursion(cards);
    }

    private boolean recursion(List<Double> cards){

        if(cards.size() == 1){
            return Math.abs(24 - cards.get(0)) <= epsilon;
        }

        for(int i=0;i<cards.size();i++){
            for(int j=0;j<cards.size();j++){
                if(i==j) continue;

                List<Double> temp = new ArrayList<>();
                for(int k=0;k<cards.size();k++){
                    if(k != i && k != j) temp.add(cards.get(k));
                }

                double a = cards.get(i), b = cards.get(j);

                List<Double> possible = new ArrayList<>();
                possible.add(a + b);
                possible.add(a * b);
                possible.add(a - b);
                possible.add(b - a);

                if(Math.abs(a) > 0) possible.add(b/a);
                if(Math.abs(b) > 0) possible.add(a/b);

                for(double x : possible){
                    temp.add(x);
                    if(recursion(temp)) return true;
                    temp.removeLast();
                }

            }
        }
        return false;
    }
}