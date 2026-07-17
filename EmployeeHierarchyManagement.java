/*Employee Hierarchy Management

Imagine you're working on an employee management system for a company, where employees are organized in a hierarchical structure similar to a Binary Search Tree (BST). Each employee has a unique ID, and employees are arranged in such a way that the employee with a lower ID is in the left subtree, and those with a higher ID are in the right subtree.

Your task is to build a feature that helps find the lowest common manager (or common ancestor) of two given employees in the company. The lowest common manager is defined as the employee who is the lowest node (manager) in the hierarchy such that both of the given employees are either directly under them or further down the hierarchy.

Given a binary search tree (BST) where each node represents an employee ID, find the lowest common ancestor (LCA) of two given employee nodes p and q. The LCA is the lowest node in the tree that has both p and q as descendants, where we allow a node to be a descendant of itself.



Input Format

The first line contains an integer n, representing the number of employees (nodes) in the binary search tree.
The second line contains n space-separated integers representing the employee IDs in the binary search tree.
The third line contains an integer p, representing the first employee ID.
The fourth line contains an integer q, representing the second employee ID.


Output Format

The program should output the ID of the lowest common manager (ancestor) of the two given employees.



Sample Input 1

7

20 10 30 5 15 25 35

5

15



Sample Output 1

10



Explanation

The binary search tree (BST) constructed from the employee IDs looks like this:



    20

   / \

  10  30

  / \  / \

 5 15 25 35



The given employees are p = 5 and q = 15.

In this case, the lowest common ancestor of employees 5 and 15 is 10, as 10 is the lowest manager that both 5 and 15 report to.

The output is 10, which is the employee ID of the lowest common manager of employees 5 and 15. */

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
        val = x;
        left = right = null;
    }
}

public class EmployeeHierarchyManagement {

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

    static int lowestCommonAncestor(TreeNode root, int p, int q) {
        while (root != null) {
            if (p < root.val && q < root.val) {
                root = root.left;
            } else if (p > root.val && q > root.val) {
                root = root.right;
            } else {
                return root.val;
            }
        }
        return -1;
    }
}