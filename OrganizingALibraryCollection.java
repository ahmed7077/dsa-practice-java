/*Organizing a Library Collection
A library is implementing a system to organize books based on their unique book IDs. The system should use a Binary Search Tree (BST) to manage the collection. Each book has a unique ID, and the library needs to insert new books into the system while maintaining the BST property. Your task is to implement the insertion of a new book ID into the existing BST.

Given the root node of a Binary Search Tree (BST) representing books in the library, and a value representing the book's unique ID, return the root node of the BST after inserting the new book ID. It is guaranteed that the new book ID does not exist in the original BST.

Implement a Binary Search Tree where each node represents a book's unique ID.
Ensure that after inserting a new book ID, the BST properties are maintained:
For any node N, all values in the left subtree of N must be smaller than N.val, and all values in the right subtree of N must be larger than N.val.
Return the root node of the updated BST.


Input Format

First, enter the number of books (n) already in the system (number of nodes in the BST).
Next, enter the unique IDs of the books (n integers) which will form the initial BST.


Output Format:

After the insertion, print the In-Order Traversal of the updated BST, which should display the book IDs in ascending order.


Sample Input

5

50 30 70 20 40



Sample Output

20 30 40 50 70



Explanation

The elements to be inserted are 50, 30, 70, 20, and 40.

Step-by-Step Insertion:

Inserting 50:
Start with an empty tree.
Since the tree is empty, 50 becomes the root of the BST.
Inserting 30:
Compare 30 with the root value 50.
Since 30 is less than 50, move to the left side.
The left side of 50 is empty, so place 30 as the left child of 50.
Inserting 70:
Compare 70 with the root value 50.
Since 70 is greater than 50, move to the right side.
The right side of 50 is empty, so place 70 as the right child of 50.
Inserting 20:
Compare 20 with the root value 50.
Since 20 is less than 50, move to the left side to 30.
Now, compare 20 with 30.
Since 20 is less than 30, move to the left side again.
The left side of 30 is empty, so place 20 as the left child of 30.
Inserting 40:
Compare 40 with the root value 50.
Since 40 is less than 50, move to the left side to 30.
Now, compare 40 with 30.
Since 40 is greater than 30, move to the right side.
The right side of 30 is empty, so place 40 as the right child of 30.
    50

    / \

 30 70

  / \

20 40 */
import java.util.*;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;    
    TreeNode(int val) {
        this.val = val;
    }
}
public class OrganizingALibraryCollection {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);        
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();        
        TreeNode root = null;
        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            root = insert(root, id);
        }        
        List<Integer> result = new ArrayList<>();
        inorder(root, result);        
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i));
            if (i < result.size() - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }    
    public static TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val < root.val) {
            root.left = insert(root.left, val);
        } else if (val > root.val) {
            root.right = insert(root.right, val);
        }
        return root;
    }    
    public static void inorder(TreeNode root, List<Integer> result) {
        if (root != null) {
            inorder(root.left, result);
            result.add(root.val);
            inorder(root.right, result);
        }
    }
}