/*Scoring System for Left-Handed Players

In a cricket tournament, every team has several players, and among them are left-handed players. Each player is represented by a node in a binary tree, where the left and right children represent players in different roles. The tournament organizers want to calculate the total contribution (score) made by all left-handed players who are not further managing other players, i.e., left-handed players who are "leaves" (players with no further responsibilities).

The binary tree structure can help represent the hierarchy of the players, and our goal is to find the sum of the scores of all left-handed players who are at the end of the hierarchy (leaf players).



Input Format

First line contains the number of inputs(players).
The next line contains the input values (scores of players) in level-order (use "null" for no player at that position).


Output Format

A single integer representing the sum of the scores of all left-handed (left child) leaf players.


Sample Input

7

3 9 20 null null 15 7



Sample Output

24



Explanation

The first value 3 is the root of the binary tree (captain).
The second and third values 9 and 20 represent the left and right players of 3.
The values null indicate that player 9 has no children.
The next two values 15 and 7 represent the left and right players of player 20.
The structure of the binary tree looks like this:

      3

     / \

    9 20

       / \

      15 7

The left leaf in this binary tree is 9, and the left leaf of node 20 is 15. Therefore, the sum of the left leaf nodes is 9 + 15 = 24. */
import java.util.*;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode(int val) {
        this.val = val;
    }
}
class ScoringSystemForLeftHandedPlayers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();        
        String[] values = new String[n];
        for (int i = 0; i < n; i++) {
            values[i] = sc.next();
        }        
        TreeNode root = buildTree(values);        
        System.out.println(sumOfLeftLeaves(root, false));
    }    
    public static TreeNode buildTree(String[] values) {
        if (values.length == 0 || values[0].equals("null")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty() && i < values.length) {
            TreeNode current = queue.poll();
            if (i < values.length) {
                if (!values[i].equals("null")) {
                    current.left = new TreeNode(Integer.parseInt(values[i]));
                    queue.add(current.left);
                }
                i++;
            }
            if (i < values.length) {
                if (!values[i].equals("null")) {
                    current.right = new TreeNode(Integer.parseInt(values[i]));
                    queue.add(current.right);
                }
                i++;
            }
        }
        return root;
    }
    public static int sumOfLeftLeaves(TreeNode node, boolean isLeft) {
        if (node == null) {
            return 0;
        }        
        if (node.left == null && node.right == null && isLeft) {
            return node.val;
        }        
        return sumOfLeftLeaves(node.left, true) + sumOfLeftLeaves(node.right, false);
    }
}