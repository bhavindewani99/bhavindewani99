class Solution {
    public int tupleSameProduct(int[] nums) {
        
        Map<Integer, Integer> map = new HashMap<>(); // Multiplication to count
        int result = 0;

        for(int i=0;i<nums.length;i++){
            for(int j=i+1; j<nums.length;j++){
                int multiplication = nums[i]*nums[j];
                map.put(multiplication, map.getOrDefault(multiplication, 0) + 1);
            }
        }

        for(int count : map.values()){ // for making a valid pair count should be greater then equal to 2
            int pairs = count * (count-1) / 2;
            result += pairs * 8;
        }

        return result;
    }
}

// We need to find pairs to calculate the result means suppose [1,2,4,5,10]
// For multiplication as 10 we can do 2 *5 or 1*10 means count is 2 for 10 therefore we found one array
// From one array we can make 8 different subarrays
// For count is 2 we can make one pair like p1 = p2 where p1 is(a*b) and (c*d)
// Count is 3 we can (p1, p2), (p2 ,p3) and (p1 and p3) = 3 pairs
// Count is 4 we can do (p1,p2), (p1,p3), (p1,p4), (p2,p3), (p2,p4) and (p3,p4) = 6 pairs
// Count is 5 then 10 pairs
// Formula can be derived as n*(n-1)/2