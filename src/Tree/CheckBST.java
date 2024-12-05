package Tree;
/*
 * All keys in the left subtree are smaller than the root and all keys in the right subtree are greater.
 * Both the left and right subtrees must also be binary search trees.
 * Each key must be distinct.
 */

public class CheckBST {

	public static void main(String[] args) {
		// Create a sample binary tree
        //      4
        //    /   \
        //   2     5
        //  / \
        // 1   3

        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(3);

        if (isBST(root)) {
            System.out.println("True");
        }
        else {
            System.out.println("False");
        }

	}
	
	static int maxValue(Node node) {
        if (node == null) return Integer.MIN_VALUE;
        return
        Math.max(node.data, 
                 Math.max(maxValue(node.left), maxValue(node.right)));
    }

    // Function to find min value in the subtree
    static int minValue(Node node) {
        if (node == null) return Integer.MAX_VALUE;
        return 
        Math.min(node.data, 
                 Math.min(minValue(node.left), minValue(node.right)));
    }

    // Returns true if the binary tree is a BST
    static boolean isBST(Node node) {
        if (node == null) return true;

        // Check if the max of the left subtree is greater than current node
        if (node.left != null && maxValue(node.left) >= node.data)
            return false;

        // Check if the min of the right subtree is smaller than or equal to current node
        if (node.right != null && minValue(node.right) <= node.data)
            return false;

        // Recursively check if left and right subtrees are BSTs
        return isBST(node.left) && isBST(node.right);
    }

}
