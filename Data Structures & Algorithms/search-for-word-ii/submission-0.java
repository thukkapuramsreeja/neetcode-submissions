
class Solution {

    class TrieNode {
        TrieNode[] child = new TrieNode[26];
        String word;
    }

    private TrieNode root = new TrieNode();
    private List<String> ans = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {

        for (String word : words) {
            insert(word);
        }

        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dfs(board, i, j, root);
            }
        }

        return ans;
    }

    private void insert(String word) {

        TrieNode node = root;

        for (char ch : word.toCharArray()) {

            int index = ch - 'a';

            if (node.child[index] == null) {
                node.child[index] = new TrieNode();
            }

            node = node.child[index];
        }

        node.word = word;
    }

    private void dfs(char[][] board, int r, int c, TrieNode node) {

        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length) {
            return;
        }

        char ch = board[r][c];

        if (ch == '#' || node.child[ch - 'a'] == null) {
            return;
        }

        node = node.child[ch - 'a'];

        if (node.word != null) {
            ans.add(node.word);
            node.word = null; // avoid duplicates
        }

        board[r][c] = '#';

        dfs(board, r + 1, c, node);
        dfs(board, r - 1, c, node);
        dfs(board, r, c + 1, node);
        dfs(board, r, c - 1, node);

        board[r][c] = ch;
    }
}