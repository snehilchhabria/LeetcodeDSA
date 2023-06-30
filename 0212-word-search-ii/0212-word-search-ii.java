class Solution {
    Set<String> set = new HashSet<>();
    int m;
    int n;
    public List<String> findWords(char[][] board, String[] words) {
        
        Trie trie = new Trie();
        for(String x : words){
            trie.insert(x);
        }
        m = board.length;
        n = board[0].length;
        
        
            boolean [][] vis = new boolean[m][n];
            for(int i =0; i<m; i++){
                for(int j=0; j<n; j++){
                   dfs(board,"", vis, i, j, trie);
                    }
                }
        return new ArrayList<>(set);
    }
    private void dfs(char[][] board, String str,boolean [][] vis, int i, int j,Trie trie){
       
        if(i<0 || i>=m || j<0 ||j>=n || vis[i][j] == true){
            return ;
        }
        
        str += board[i][j];
        if (!trie.startsWith(str)) return;
        
        if (trie.search(str)) {
            set.add(str);
        }
      
        vis[i][j] = true;
            dfs(board, str, vis, i+1, j, trie);
            dfs(board, str, vis, i-1, j, trie);
            dfs(board, str, vis, i, j+1, trie);
            dfs(board, str, vis, i, j-1, trie);
         
        vis[i][j] = false;
    }
}

class TrieNode {
    private TrieNode[] children;
    private boolean isWord;

    public TrieNode() {
        children = new TrieNode[26]; // Assuming lowercase English alphabet
        isWord = false;
    }

    public void setWord() {
        isWord = true;
    }

    public boolean isWord() {
        return isWord;
    }

    public TrieNode getChild(char c) {
        return children[c - 'a'];
    }

    public void setChild(char c, TrieNode node) {
        children[c - 'a'] = node;
    }
}

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            TrieNode child = current.getChild(c);
            if (child == null) {
                child = new TrieNode();
                current.setChild(c, child);
            }
            current = child;
        }
        current.setWord();
    }

    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for (char c : prefix.toCharArray()) {
            current = current.getChild(c);
            if (current == null) {
                return false;
            }
        }
        return true;
    }

    public boolean search(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            current = current.getChild(c);
            if (current == null) {
                return false;
            }
        }
        return current.isWord();
    }
}