/*Finding the Common Captain in a Cricket Team's Hierarchy
In a cricket team, players and team management staff are arranged in a hierarchical structure similar to a binary tree. The head coach is at the root, and the assistant coaches or players report to them. Each player has a manager, and sometimes they might have assistants too.

Given two players or staff members, we need to determine who their common captain is. In this scenario, the common captain is defined as the Lowest Common Ancestor (LCA), the lowest-ranking person who manages both players or staff members in the hierarchy.

For example, consider the case where Player A and Player B need to know who their common captain is, i.e., the lowest person who manages them both directly or indirectly.



Input Format

First line contains the number of members in the team.
Second line contains the values (IDs) of the members in level-order format (use "null" for missing members).
Third line contains two member IDs, p and q, for whom the common captain is to be found.


Output Format

The ID of the common captain (Lowest Common Ancestor).


Sample Input

7

3 5 1 6 2 0 8 null null 7 4

5 4



Sample Output

5



Explanation

The team structure is represented as a binary tree:

      3

     / \

    5  1

   / \ / \

  6 2 0 8

      / \

    7  4

In this structure:

3 is the head coach (root).
5 and 1 report directly to 3.
6 and 2 report to 5, while 0 and 8 report to 1.
7 and 4 are under 2.
To find the common captain (LCA) for members 5 and 4, the lowest-ranking person managing both of them is 5 because 5 is already the captain of 4 (directly or indirectly). */
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

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

class FindingCommonCaptainInACricketTeamHistory {
    
    public static TreeNode buildTree(String[] levelOrder) {
        if (levelOrder == null || levelOrder.length == 0 || levelOrder[0].equals("null")) {
            return null;
        }
        
        TreeNode root = new TreeNode(Integer.parseInt(levelOrder[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        int index = 1;
        
        while (!queue.isEmpty() && index < levelOrder.length) {
            TreeNode current = queue.poll();
            
            if (index < levelOrder.length) {
                String leftVal = levelOrder[index];
                if (!leftVal.equals("null")) {
                    current.left = new TreeNode(Integer.parseInt(leftVal));
}
                queue.offer(current.left);
                index++;
            }
            
            if (index < levelOrder.length) {
                String rightVal = levelOrder[index];
                if (!rightVal.equals("null")) {
                    current.right = new TreeNode(Integer.parseInt(rightVal));
                }
                queue.offer(current.right);
                index++;
            }
        }
        
        return root;
    }
    
    public static TreeNode findLCA(TreeNode root, int p, int q) {
        if (root == null) {
            return null;
        }
        
        if (root.value == p || root.value == q) {
            return root;
        }
        
        TreeNode leftLCA = findLCA(root.left, p, q);
        TreeNode rightLCA = findLCA(root.right, p, q);
        
        if (leftLCA != null && rightLCA != null) {
            return root;
        }
        
        return (leftLCA != null) ? leftLCA : rightLCA;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = Integer.parseInt(scanner.nextLine());
        String[] levelOrder = scanner.nextLine().split(" ");
        
        TreeNode root = buildTree(levelOrder);
        
        String[] members = scanner.nextLine().split(" ");
        int p = Integer.parseInt(members[0]);
        int q = Integer.parseInt(members[1]);
        
        TreeNode lca = findLCA(root, p, q);
        
        if (lca != null) {
            System.out.println(lca.value);
        } else {
            System.out.println("No common captain found.");
        }
        
        scanner.close();
    }
}