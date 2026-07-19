/*Optimizing Product Search
Imagine you are working on a large-scale e-commerce platform that maintains a list of products in sorted order based on their price. Each product is represented as a node in a singly linked list. To improve the efficiency of searching for products within a given price range, you have been tasked with converting this sorted list of products into a height-balanced Binary Search Tree (BST). The BST will allow faster price-based searches and product comparisons.

Your job is to write a program that takes the head of the sorted singly linked list (representing the sorted prices of products) and converts it into a height-balanced BST. The tree must maintain the property where the left subtree of a node contains only nodes with values less than the node's value, and the right subtree contains only nodes with values greater than the node's value.

This task will enable the platform to efficiently query product prices within a given range, ensuring that searches are logarithmic in complexity, which is crucial for scaling with large datasets.

You are given the head of a singly linked list where elements are sorted in ascending order. Your task is to convert the linked list into a height-balanced Binary Search Tree (BST).

A height-balanced BST is defined as a binary tree in which the depth of the two subtrees of every node never differs by more than one.



Input Format

The first line contains an integer n representing the number of elements in the linked list.
The second line contains n space-separated integers, representing the prices of the products, sorted in ascending order.


Output Format

The output will print the pre-order traversal of the BST. Pre-order traversal ensures the root node is printed first, followed by the left and right subtrees.


Sample Input

5

-10 -3 0 5 9



Sample Output

0 -3 -10 9 5



Explanation

The input represents a sorted linked list: -10 -> -3 -> 0 -> 5 -> 9.
This list will be converted to a height-balanced BST where:
The root will be the middle element 0.
The left subtree will have -10 and -3, and the right subtree will have 5 and 9.
[-10, -3, 0, 5, 9] is a sorted list.

We find the middle element 0 and make it the root of the BST.

For the left subtree, we take the sublist [-10, -3] and make -3 the root. The element -10 becomes the left child of -3.

For the right subtree, we take the sublist [5, 9] and make 9 the root, and 5 becomes the left child of 9.

The pre-order traversal of the tree will visit the nodes in this order: 0 (root), -3 (left), -10 (left), 9 (right), 5 (left).

The BST will look like:

      0

     / \

   -3  9

   /   /

-10  5 */
import java.util.ArrayList;
import java.util.List;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
        val = x;
        left = right = null;
    }
}

public class OptimizingProductSearch {

    public static ListNode buildLinkedList(int[] values) {
        if (values.length == 0) return null;
        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }
        return head;
    }

    public static TreeNode sortedListToBST(ListNode head) {
        List<Integer> values = new ArrayList<>();
        ListNode current = head;
        while (current != null) {
            values.add(current.val);
            current = current.next;
        }
        return buildBalancedBST(values, 0, values.size() - 1);
    }

    private static TreeNode buildBalancedBST(List<Integer> values, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start + 1) / 2;
        TreeNode root = new TreeNode(values.get(mid));
        root.left = buildBalancedBST(values, start, mid - 1);
        root.right = buildBalancedBST(values, mid + 1, end);
        return root;
    }

    public static void printPreOrder(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        printPreOrder(root.left);
        printPreOrder(root.right);
    }
}