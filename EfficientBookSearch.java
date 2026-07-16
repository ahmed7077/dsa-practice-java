/*Efficient Book Search in a Digital Library
Imagine you are developing a Digital Library Management System for a university that holds a large collection of books, each identified by a unique Book ID. The library system needs to efficiently store, manage, and retrieve information about these books. To ensure quick search operations, the Book IDs are stored in a Binary Search Tree (BST).

Every time a student or librarian enters a Book ID, the system searches for the book in the BST. If the Book ID exists, the system returns information about that book along with details of related books (those with Book IDs close to the searched ID). If the Book ID does not exist in the library's catalog, the system should notify the user that the book is unavailable.

In this library system:

Each book is assigned a unique Book ID based on the year of publication, genre code, and a unique serial number.
The system needs to handle searches efficiently as the library grows, with thousands of books being stored.
When a librarian or student searches for a book, they want to know if the book is available, along with recommendations for other similar books (based on Book ID proximity).
For example, if a student searches for a book with Book ID 1040, and the book is found, the system should return this book's details. It should also suggest other books with similar IDs, i.e., books in the same subtree.


Input Format

First, enter the number of books (n) available in the library system.
Then, enter n unique book IDs (these are used to construct the BST).
After that, enter the Book ID (val) you want to search for.


Output Format

If the book is found, display the message "Book found!" and print the In-Order Traversal of the subtree rooted at the found node.
If the book is not found, display the message "Book not found."


Example 1

Sample Input 1

6

50 30 70 20 40 60

30



Sample Output 1

Book found! Subtree rooted at 30:

20 30 40



Explanation

We are searching for the book with ID 30 in the BST. Here’s how the search works:

Start at the root (50):
We compare 30 with 50. Since 30 is less than 50, we move to the left child.
Move to node 30:
We find that the current node's value is 30, which matches the value we are searching for.
Since we have found the node with value 30, we now return the subtree rooted at this node.

The subtree rooted at 30 looks like this:

  30

 /   \

20  40

Since the book with ID 30 is found, the system outputs the message:

Book found! Subtree rooted at 30:

Next, it performs an In-Order Traversal of the subtree rooted at 30. In an In-Order Traversal, we visit the left subtree, then the current node, and finally the right subtree.

The nodes visited in the subtree are: 20, 30, 40.
The final output is:

Book found! Subtree rooted at 30:

20 30 40



Example 2

Sample Input 2

6

50 30 70 20 40 60

25



Sample Output 2

Book not found



Explanation:

Step 1: The same BST structure is used.
Step 2: The user searches for book ID 25.
Starting from the root (50), since 25 is less than 50, move to the left subtree.
At node 30, since 25 is less than 30, move to the left child (20).
Since 25 is greater than 20, check the right child, but the right child is null.
Step 3: The book with ID 25 is not found in the BST, and the system outputs "Book not found."
 */
import java.util.*;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
        this.val = val;
    }
}
public class EfficientBookSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);        
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();        
        TreeNode root = null;
        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            root = insert(root, id);
        }        
        int target = sc.nextInt();
        TreeNode targetNode = search(root, target);        
        if (targetNode != null) {
            System.out.println("Book found! Subtree rooted at " + target + ":");
            List<Integer> result = new ArrayList<>();
            inorder(targetNode, result);            
            for (int i = 0; i < result.size(); i++) {
                System.out.print(result.get(i));
                if (i < result.size() - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        } else {
            System.out.println("Book not found");
        }
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
    public static TreeNode search(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }
        if (val < root.val) {
            return search(root.left, val);
        } else {
            return search(root.right, val);
        }
    }    
    public static void inorder(TreeNode root, List<Integer> result) {
        if (root != null) {
            inorder(root.left, result);
            result.add(root.val);
            inorder(root.right, result);
        }
    }
}

