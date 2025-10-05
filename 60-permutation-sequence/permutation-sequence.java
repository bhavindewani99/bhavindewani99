class Solution {
    public String getPermutation(int n, int k) {

        StringBuilder result = new StringBuilder(); 
        List<Integer> numbers = new ArrayList<>();
        int factorial = 1;

        for(int i=1;i<n;i++){
            factorial*=i;
            numbers.add(i);
        }
        numbers.add(n);
        k--; // for 0th based indexing

        while(true){
            result.append(numbers.get(k/factorial));
            numbers.remove(k/factorial);

            if(numbers.size()==0) break;
            k = k % factorial;
            factorial /= numbers.size();
        }

        return result.toString();
    }
}