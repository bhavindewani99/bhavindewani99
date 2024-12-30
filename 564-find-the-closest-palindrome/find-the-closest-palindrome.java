class Solution {
    public String nearestPalindromic(String n) {
        int len = n.length();
        boolean isEven = len%2==0;
        List<Long> palindromes = new ArrayList<>();
        int mid = isEven ? len/2 : len/2 +1;
        long firstHalf = Long.valueOf(n.substring(0,mid));

        palindromes.add(generatePalindrome(firstHalf, isEven)); // mirroring as it is
        palindromes.add(generatePalindrome(firstHalf + 1, isEven)); // in case of 139 we need to increment 3 and mirro
        palindromes.add(generatePalindrome(firstHalf - 1, isEven)); // same as above
        palindromes.add((long) Math.pow(10, len-1) - 1); // if number is 101 then we have to add 99
        palindromes.add((long) Math.pow(10, len) + 1); // if number is 99 then we have to add 101

        long result = 0l;
        long difference = Long.MAX_VALUE;
        long origianlNum = Long.valueOf(n);

        for(long num : palindromes){
            if(num==origianlNum) continue;
            if(Math.abs(num-origianlNum) < difference){
                difference = Math.abs(num-origianlNum);
                result = num;
            }else if(Math.abs(num-origianlNum) == difference){
                result = Math.min(result, num);
            }
        }

        return String.valueOf(result);

    }

    private long generatePalindrome(long firstHalf, boolean isEven){
        long result = firstHalf;
        if(isEven==false){
            firstHalf /= 10; // removing the middle element and mirroring the remainig part
        }

        while(firstHalf>0){
            result = result*10 + firstHalf%10;
            firstHalf /= 10;
        }

        return result;
    }
}