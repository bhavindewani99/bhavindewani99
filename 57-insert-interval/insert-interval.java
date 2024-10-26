class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int start = newInterval[0];
        int end = newInterval[1];
        if(intervals.length==0) return new int[][]{{start,end}};
        int n = intervals.length;
        List<List<Integer>> res = new ArrayList<>();
        boolean inserted = false;

        
        for(int i=0;i<n;i++){
            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];
            if(inserted){
                res.add(new ArrayList<>(Arrays.asList(currStart, currEnd)));
                continue;
            }
            if(currStart>end){
                res.add(new ArrayList<>(Arrays.asList(start, end)));
                res.add(new ArrayList<>(Arrays.asList(currStart, currEnd)));
                inserted=true;
            }else if(start<=currEnd){
                end = Math.max(end, currEnd);
                start=Math.min(start,currStart);
                i++;
                while(i<n && end>=intervals[i][0]){
                    end = Math.max(end,intervals[i][1]);
                    i++;
                }
                res.add(new ArrayList<>(Arrays.asList(start, end)));
                i--;
                inserted=true;
            }else{
                res.add(new ArrayList<>(Arrays.asList(currStart, currEnd)));
            }
        }
        if(inserted==false){
            res.add(new ArrayList<>(Arrays.asList(start, end)));
        }
        int[][] result = new int[res.size()][2];
        int index=0;
        for(List<Integer> curr : res){
            result[index][0] = curr.get(0);
            result[index][1] = curr.get(1);
            index++;
        }
        return result;
    }
}