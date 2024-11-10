class Solution {
    public String[] reorderLogFiles(String[] logs) {
        List<String> letterLogs = new ArrayList<>();
        List<String> digitLogs = new ArrayList<>();

        separateLogs(logs, letterLogs, digitLogs);

        Collections.sort(letterLogs, new Comparator<String>(){
            public int compare(String log1, String log2){
                String s1 = log1.substring(log1.indexOf(" ")+1);
                String s2 = log2.substring(log2.indexOf(" ")+1);

                return s1.equals(s2) ? log1.compareTo(log2) : s1.compareTo(s2);
            }
        });

        String[] result = new String[logs.length];
        int index=0;
        for(int i=0;i<letterLogs.size();i++){
            result[index++] = letterLogs.get(i);
        }
        for(int i=0;i<digitLogs.size();i++){
            result[index++] = digitLogs.get(i);
        }
        return result;
    }

    private void separateLogs(String[] logs, List<String> letterLogs, List<String> digitLogs){
        for(String log : logs){
            if(Character.isDigit(log.charAt(log.length()-1))){
                digitLogs.add(log);
            }else{
                letterLogs.add(log);
            }
        }
    }
}