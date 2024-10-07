class TreeNode {
    int data;
    TreeNode left, right;

    TreeNode(int item) {
        data = item;
        left = right = null;
    }
}

public class BinaryTree {
    TreeNode root;

    // Method to find the LCA of n1 and n2
    TreeNode findLCA(TreeNode node, int n1, int n2) {
        // Base case
        if (node == null) {
            return null;
        }

        // If either n1 or n2 matches the node's data, return the node
        if (node.data == n1 || node.data == n2) {
            return node;
        }

        // Look for keys in left and right subtrees
        TreeNode leftLCA = findLCA(node.left, n1, n2);
        TreeNode rightLCA = findLCA(node.right, n1, n2);

        // If both of the above calls return non-null, this node is the LCA
        if (leftLCA != null && rightLCA != null) {
            return node;
        }

        // Otherwise return the non-null value
        return (leftLCA != null) ? leftLCA : rightLCA;
    }

    // Helper method to initiate the LCA search
    public TreeNode getLCA(int n1, int n2) {
        return findLCA(root, n1, n2);
    }

    // Main method to test the LCA implementation
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
        tree.root.right.left = new TreeNode(6);
        tree.root.right.right = new TreeNode(7);

        int n1 = 4, n2 = 5;
        TreeNode lca = tree.getLCA(n1, n2);
        if (lca != null) {
            System.out.println("LCA of " + n1 + " and " + n2 + " is " + lca.data);
        } else {
            System.out.println("LCA not found");
        }
    }
}
