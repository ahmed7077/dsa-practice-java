/*Finding the Kth Smallest Book ID in a Digital Library
In a Digital Library System, every book is assigned a unique Book ID for identification. The library uses a Binary Search Tree (BST) to manage the collection of Book IDs efficiently. The librarian wants to know the Kth smallest Book ID to fulfill specific requirements, such as finding the ID of the Kth most popular book or for display purposes.

You are given the root node of a BST and an integer k. Your task is to return the Kth smallest Book ID from the BST, where K is 1-indexed.



Input Format

First, enter the number of books (n) currently in the library.
Then, enter n unique Book IDs to insert into the BST.
Finally, enter the integer k to find the Kth smallest Book ID.


Output Format

Display the Kth smallest Book ID or a message indicating that the value of k is out of range.


Sample Input

6

50 30 70 20 40 60

3



Sample Output

40



Explanation

Step 1: Insert the following Book IDs into the BST: 50, 30, 70, 20, 40, 60. After insertion, the BST maintains its ordered structure.
Step 2: The user wants to find the 3rd smallest Book ID.
Step 3: Perform an in-order traversal of the BST to get the Book IDs in sorted order:
The order of Book IDs during the traversal will be: 20, 30, 40, 50, 60, 70.
The 3rd smallest Book ID in this order is 40.
4.Step 4: The program outputs 40 */
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
        val = x;
        left = right = null;
    }
}

public class SmallestBookIdInDigitalLibrary {

    public static TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }

    public static int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            k--;
            if (k == 0) {
                return current.val;
            }
            current = current.right;
        }
        return -1; // k is out of bounds
    }
}