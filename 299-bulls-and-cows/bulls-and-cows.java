class Solution {
    public String getHint(String secret, String guess) {
        int[] secDigits = new int[10];
        int[] guessDigits = new int[10];
        int bulls = 0;
        int cows = 0;

        for(int i=0;i<secret.length();i++){
            if(secret.charAt(i)==guess.charAt(i)) bulls++;
            else{
                secDigits[secret.charAt(i)-'0']++;
                guessDigits[guess.charAt(i)-'0']++;
            }
        }

        for(int i=0;i<10;i++){
            cows += Math.min(secDigits[i], guessDigits[i]);
        }

        return bulls + "A" + cows + "B";
    }
}