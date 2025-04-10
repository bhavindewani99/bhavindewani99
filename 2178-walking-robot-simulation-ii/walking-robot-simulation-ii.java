class Robot {
    private int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    private String[] direction = {"East","North","West","South"};
    private int width;
    private int height;
    private int x,y,d,mod;

    public Robot(int width, int height) {
        this.width = width;
        this.height = height;
        mod = width*2 + height*2 -4;
        d=0;
    }

    private boolean isValid(int x, int y){
        return x>=0 && x<width && y>=0 && y<height;
    }

    public void step(int num) {
        num = num % mod;
        if(num == 0) num=mod;

        while(num-->0){
            if(!isValid(x+dir[d][0], y+dir[d][1])) d = (d+1)%4;
            x+=dir[d][0];
            y+=dir[d][1];
        }
    }
    
    public int[] getPos() {
        return new int[]{x,y};
    }
    
    public String getDir() {
        return direction[d];
    }
}

/**
 * Your Robot object will be instantiated and called as such:
 * Robot obj = new Robot(width, height);
 * obj.step(num);
 * int[] param_2 = obj.getPos();
 * String param_3 = obj.getDir();
 */