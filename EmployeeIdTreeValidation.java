/*Employee ID Tree Validation

In a Company Employee Management System, employee IDs are stored in a binary tree for quick searching and organization. To ensure fast retrieval, the tree must follow Binary Search Tree (BST) rules.You are given the root node of a binary tree. Your task is to determine whether the given binary tree is a Binary Search Tree (BST) or not.



A Binary Search Tree satisfies the following conditions:

All nodes in the left subtree contain values smaller than the root node.

All nodes in the right subtree contain values greater than the root node.

Both left and right subtrees must also be BSTs.

All node values are distinct.



Print Yes if the tree is a BST, otherwise print No.



Input Format

The first line contains an integer N, representing the number of nodes in the binary tree.
The second line contains N space-separated integers representing the level-order traversal of the tree. Use -1 to represent a NULL node.


Output Format

Print Yes if the binary tree is a BST. Otherwise, print No.



Example 1

Sample Input 1

7

4 2 6 1 3 5 7



Sample Output 1

Yes



Explanation

The tree formed is:



    4

   /  \

   2   6

  / \  / \

 1  3 5  7



All left subtree values are smaller and right subtree values are greater, so it is a BST.



Example 2

Sample Input 2

7

5 2 7 1 6 4 8



Sample Output 2

No



Explanation

Node 6 is in the left subtree of 5, but it is greater than 5, so BST property is violated. */
import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
        val = x;
        left = right = null;
    }
}

public class EmployeeIdTreeValidation {

    public static TreeNode buildTree(int[] levelOrder) {
        if (levelOrder.length == 0 || levelOrder[0] == -1) {
            return null;
        }

        TreeNode root = new TreeNode(levelOrder[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (!queue.isEmpty() && i < levelOrder.length) {
            TreeNode current = queue.poll();

            if (i < levelOrder.length && levelOrder[i] != -1) {
                current.left = new TreeNode(levelOrder[i]);
                queue.offer(current.left);
            }
            i++;

            if (i < levelOrder.length && levelOrder[i] != -1) {
                current.right = new TreeNode(levelOrder[i]);
                queue.offer(current.right);
            }
            i++;
        }
        return root;
    }
}