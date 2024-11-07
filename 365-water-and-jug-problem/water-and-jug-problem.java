class Solution {
    public boolean canMeasureWater(int x, int y, int target) {
        if (target > x + y) return false;
        if (target == 0) return true;
        int gcd = gcd(x, y);
        //if (target % gcd != 0) return false;
        Set<String> visited = new HashSet<>();

        return recursion(x,y,0,0,target,visited);
    }

    private boolean recursion(int xCap, int yCap, int currX, int currY, int target,Set<String> visited){
        if(currX+currY==target || currX==target || currY==target) return true;

        String state = currX + "," + currY;
        if (visited.contains(state)) return false;
        visited.add(state);

        // case 1 fill full
        if(currX<xCap && recursion(xCap,yCap,xCap,currY,target,visited)) return true;
        if(currY<yCap &&  recursion(xCap,yCap,currX,yCap,target,visited)) return true;

        //Case 2 fill in one another
        if(currX<xCap){
            int used = Math.min(xCap-currX,currY);
            if(recursion(xCap,yCap, currX + used, currY - used, target,visited)) return true;
        }
        if(currY<yCap){
            int used = Math.min(yCap-currY,currX);
            if(recursion(xCap,yCap,currX-used,currY+used,target,visited)) return true;
        }

        // Case 3 Empty
        if(recursion(xCap,yCap,0,currY,target,visited)) return true;
        if(recursion(xCap,yCap,currX,0,target,visited)) return true;

        return false;
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}