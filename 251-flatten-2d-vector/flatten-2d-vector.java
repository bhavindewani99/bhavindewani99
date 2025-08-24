class Vector2D {

    List<Integer> list;
    int index;
    public Vector2D(int[][] vec) {
        list = new ArrayList<>();
        for(int[] temp : vec){
            for(int ele : temp) list.add(ele);
        }
        index = 0;
    }
    
    public int next() {
        return list.get(index++);
    }
    
    public boolean hasNext() {
        return index < list.size();
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(vec);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */