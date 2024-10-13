

import static java.lang.System.in;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int i=0;
        int length =0;
        List<String> curr = new ArrayList<>(); 

        while(i<words.length){
            String word = words[i];
            if(length + curr.size() + word.length()>maxWidth){
                int extraSpace = maxWidth - length;
                int spaces = extraSpace / Math.max(1, curr.size()-1);
                int remainder = extraSpace % Math.max(1, curr.size()-1);
                StringBuilder temp = new StringBuilder();

                for(int j=0;j<curr.size();j++){
                    temp.append(curr.get(j));
                    for(int k=0;k<spaces;k++) {
                        if(temp.length()<maxWidth)
                        temp.append(" ");
                    }
                    if(remainder>0) temp.append(" ");
                    remainder--;
                }
                while(temp.length()<maxWidth) temp.append(" ");
                res.add(temp.toString());
                length=0;
                curr = new ArrayList<>();
            }
            length+=word.length();
            curr.add(word);
            i++;
        }
        StringBuilder last = new StringBuilder();
        int index=0;
        for(int j=0;j<curr.size();j++){
            last.append(curr.get(j));
            if(last.length()<maxWidth)
            last.append(" ");
        }
        while(last.length()<maxWidth) last.append(" ");
        res.add(last.toString());
        return res;
        
    }
}