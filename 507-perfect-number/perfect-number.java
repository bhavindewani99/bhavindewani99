class Solution {
    public boolean checkPerfectNumber(int num) {
        
        int sum = 0;

        for(int i=1;i * i<=num;i++){
            if(num%i==0){
                sum += i;
                if(i*i!=num ){
                    sum += num/i;
                }

            }
        }
        return sum - num == num;
    }
}

// 28 -> Sqrt is 5
// 1 
// 2, 14
// 4, 7 