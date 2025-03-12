class Solution {
    public int numTrees(int n) {
        
        int[] possibleTrees = new int[n+1]; // each value indicates how many trees we can build with i nodes so for eg index 1 represents possible trees we can make with 1 node
        possibleTrees[0]=1;
        possibleTrees[1]=1; // base conditions

        for(int node =2;node<=n;node++){
            int total = 0;
            for(int root=1;root<=node;root++){// assuming this as root node for the tree
                int left = possibleTrees[root-1];
                int right = possibleTrees[node - root];
                total += left*right;
            }
            possibleTrees[node] = total;
        }
        return possibleTrees[n];
    }
}