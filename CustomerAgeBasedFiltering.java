/*Customer Age-Based Filtering
Imagine you're working on a customer database system where customers are stored in a Binary Search Tree (BST). Each node in the tree represents a customer, and the value of the node is the customer's age. The BST is structured such that for every node, all customers with ages less than the node are stored in the left subtree, and all customers with ages greater than the node are stored in the right subtree.

Now, for a promotional campaign, the company wants to target customers whose ages fall within a specific range [low, high]. You need to "trim" the customer database (BST) so that only customers within this age range remain in the tree. After trimming, the relative structure of the customers should remain the same, meaning any customer’s descendant should remain a descendant. The remaining customers should still follow the properties of a BST.

You are required to implement a function that trims the customer BST based on the given age boundaries (low and high). Return the root of the trimmed BST.

You are given the root of a Binary Search Tree (BST) where each node represents the age of a customer and two integers low and high. Your task is to trim the tree so that all node values (ages) lie within the interval [low, high]. Any nodes with values (ages) outside this range should be removed, and the structure of the remaining nodes should still satisfy the properties of a BST.



Input Format

The first line contains an integer n, representing the number of nodes (customers) in the binary search tree.
The second line contains n space-separated integers representing the ages of the customers.
The third and fourth lines contain two integers low and high, representing the minimum and maximum age boundaries for trimming.


Output Format

The program should output the pre-order traversal of the trimmed binary search tree (customers within the specified age range).


Sample Input

7

18 10 25 5 15 20 30

10

20



Sample Output

18 10 15 20



Explanation

We start with the following customer age BST (constructed in order)

      

       18

     /       \

   10      25

  / \        / \

 5  15 20 30

The low boundary is 10, and the high boundary is 20.

After trimming the BST, all nodes with values less than 10 (like 5) and greater than 20 (like 25 and 30) will be removed.

The remaining BST will be:

      18

     / \

   10  20

     \

     15

Pre-order traversal (root, left, right) of the trimmed tree gives: 18 10 15 20. */

class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    public TreeNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

public class CustomerAgeBasedFiltering {

    public static TreeNode insert(TreeNode root, int age) {
        if (root == null) {
            return new TreeNode(age);
        }
        if (age < root.value) {
            root.left = insert(root.left, age);
        } else if (age > root.value) {
            root.right = insert(root.right, age);
        }
        return root;
    }

    public static TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }

        if (root.value < low) {
            return trimBST(root.right, low, high);
        }
        if (root.value > high) {
            return trimBST(root.left, low, high);
        }
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }
}