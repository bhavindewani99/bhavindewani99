class Solution {
    public String longestSubsequenceRepeatedK(String s, int k) {
        
        int[] freq = new int[26];
        String result = "";

        for(char c : s.toCharArray()) freq[c-'a']++;
        Queue<String> queue = new LinkedList<>();
        queue.offer("");

        while(!queue.isEmpty()){
            String curr = queue.peek();
            result = queue.poll();

            StringBuilder next = new StringBuilder(result);
            for(char c='a';c<='z';c++){
                if(freq[c-'a'] < k) continue;
                next.append(c);
                int nextCountinS = countOccurence(s, next.toString());

                if(nextCountinS >=k){
                    queue.offer(next.toString());
                }
                next.deleteCharAt(next.length()-1);
            }
        }

        return result;
    }

    private int countOccurence(String s, String sub){
        int count = 0, j=0;

        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == sub.charAt(j)) j++;
            
            if(j==sub.length()){
                j=0;
                count++;
            }
        }
        return count;
    }
}