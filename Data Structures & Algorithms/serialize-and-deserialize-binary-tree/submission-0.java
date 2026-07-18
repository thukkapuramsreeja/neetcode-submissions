/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */


public class Codec {

    // Serialize
    public String serialize(TreeNode root) {

        StringBuilder sb = new StringBuilder();

        preorder(root, sb);

        return sb.toString();
    }

    private void preorder(TreeNode node, StringBuilder sb) {

        if (node == null) {
            sb.append("N,");
            return;
        }

        sb.append(node.val).append(",");

        preorder(node.left, sb);
        preorder(node.right, sb);
    }

    // Deserialize
    public TreeNode deserialize(String data) {

        String[] arr = data.split(",");

        Queue<String> queue = new LinkedList<>();

        for (String s : arr) {
            queue.offer(s);
        }

        return build(queue);
    }

    private TreeNode build(Queue<String> queue) {

        String val = queue.poll();

        if (val.equals("N")) {
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(val));

        node.left = build(queue);

        node.right = build(queue);

        return node;
    }
}
