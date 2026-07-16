/*Efficient Book Deletion in a Digital Library System
Consider a Digital Library System where every book is stored in a database. Each book is identified by a unique Book ID. To ensure efficient insertion, deletion, and searching of books, the system stores these Book IDs in a Binary Search Tree (BST).

The librarian may need to remove books from the system as new editions come out, or if books are permanently removed from the library's collection. To handle this efficiently, you are tasked with developing the book deletion functionality within the BST.

You are given the root node of the BST and a Book ID that needs to be deleted. Implement a method to delete the node (representing the book) from the BST, ensuring the BST remains valid. The deletion involves:

Searching for the node with the target Book ID.
If the node is found, it is removed, and the BST structure is updated.


Input Format

First, enter the number of books (n) currently in the library.
Then, enter n unique Book IDs to insert into the BST.
After that, enter the Book ID (key) that you want to delete from the BST.


Output Format

Display the In-Order Traversal of the BST before and after the deletion of the book.


Sample Input

6

50 30 70 20 40 60

30



Sample Output

20 40 50 60 70



Explanation

Insert Book ID 50:
The BST is initially empty, so 50 becomes the root of the tree.
Insert Book ID 30:
30 is less than 50, so it is inserted as the left child of 50.
Insert Book ID 70:
70 is greater than 50, so it is inserted as the right child of 50.
Insert Book ID 20:
20 is less than 50 and also less than 30, so it is inserted as the left child of 30.
Insert Book ID 40:
40 is less than 50 but greater than 30, so it is inserted as the right child of 30.
Insert Book ID 60:
60 is greater than 50 but less than 70, so it is inserted as the left child of 70.
       50

      /     \

    30     70

   / \      /

 20 40 60

At this point, the BST contains the book IDs in an ordered structure:

Deleting Book ID 30:

We now attempt to delete the book with ID 30.
Step 1: Search for the book ID 30. We start at the root (50) and find that 30 is less than 50, so we move to the left subtree. Here we find 30.
Step 2: The node with ID 30 has two children (20 and 40). When deleting a node with two children, we replace it with the minimum node from its right subtree. In this case, 40 is the minimum node in the right subtree of 30.
Step 3: We replace 30 with 40 and remove the old node 40.
       50

      / \

    40   70

   /       /

  20   60

Final State of the BST:

The remaining book IDs are 20, 40, 50, 60, 70.
In an In-order traversal after deletion, the nodes are visited in the following order: 20, 40, 50, 60, 70. */

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

public class EfficientBookDeletion {

    public static TreeNode insert(TreeNode root, int bookId) {
        if (root == null) {
            return new TreeNode(bookId);
        }

        if (bookId < root.value) {
            root.left = insert(root.left, bookId);
        } else if (bookId > root.value) {
            root.right = insert(root.right, bookId);
        }

        return root;
    }

    public static TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
