class Node{
    Node[] links = new Node[26];
    boolean end;

    public void addNode(char c, Node node){
        links[c-'a'] = node;
    }

    public boolean containsNode(char c){
        return links[c-'a']!=null;
    }

    public Node getNode(char c){
        return links[c-'a'];
    }
}

class Trie{
    Node root;
    Trie(){
        root= new Node();
    }

    public void addWord(String word){
        Node node = root;
        for(char c:word.toCharArray()){
            if(node.containsNode(c)==false){
                node.addNode(c, new Node());
            }
            node = node.getNode(c);
        }
        node.end = true;
    }
}

class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        Set<String> result = new HashSet<>();
        int n = board.length;
        int m = board[0].length;
        boolean[][] visited = new boolean[n][m];

        for(String curr : words) trie.addWord(curr);

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dfs(i, j, visited, result, new StringBuilder(), n, m, trie.root, board);
            }
        }

        return new ArrayList<>(result);

    }

    private void dfs(int r, int c, boolean[][] visited, Set<String> result, StringBuilder currString, int n, int m, Node node, char[][] board){
        if(r<0 || c<0 || r>=n || c>=m || visited[r][c] || node.containsNode(board[r][c])==false) return;
        
        visited[r][c] = true;
        node = node.getNode(board[r][c]);
        currString.append(board[r][c]);
        if(node.end==true) result.add(currString.toString());
        int[][] directions = {{-1,0},{0,1},{1,0},{0,-1}};

        for(int k=0;k<4;k++){
            dfs(r+directions[k][0], c+directions[k][1], visited, result, currString, n, m, node, board);
        }

        currString.deleteCharAt(currString.length()-1);
        visited[r][c] = false;

    }
}