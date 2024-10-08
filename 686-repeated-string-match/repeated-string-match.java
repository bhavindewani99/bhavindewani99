class Solution {
    private final int PRIME = 29;
    public int repeatedStringMatch(String a, String b) {
        
        if(b.equals("")) return 0;
        int m = a.length();
        int n = b.length();
        int count = 1;
        String source = a;

        while(source.length()<b.length()){
            source+=a;
            count++;
        }

        double sourceHash = calculateHash(source.substring(0,n));
        double bHash = calculateHash(b);

        if(checkStrng(source,b,sourceHash,bHash)) return count;

        source+=a;
        count++;

        sourceHash = calculateHash(source.substring(0,n));
        if(checkStrng(source,b,sourceHash,bHash)) return count;

        return -1;

    }

    private double updateHash(double oldHash, char newChar, char oldChar, int patternLength){
        double newHash = (oldHash - oldChar) / PRIME;
        newHash += (newChar*Math.pow(PRIME, patternLength-1));
        return newHash;
    }

    private boolean checkStrng(String source, String b, double sourceHash, double bHash){

        for(int i=0;i<=source.length()-b.length();i++){
            if(sourceHash==bHash){
                if(source.substring(i,i+b.length()).equals(b)){
                    return true;
                }
            }
            if(i+b.length()<source.length()){
                sourceHash = updateHash(sourceHash, source.charAt(i+b.length()), source.charAt(i), b.length());
            }
        }
        return false;
    }

    private double calculateHash(String s){
        double hash = 0;
        for(int i =0;i<s.length();i++){
            hash = hash + s.charAt(i) * Math.pow(PRIME, i);
        }
        return hash;
    }
}