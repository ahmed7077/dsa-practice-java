/*Cricket Team Hierarchy Visualization
In a cricket team's management structure, some team members report directly to others, forming a hierarchical structure similar to a binary tree. Imagine that you're standing to the right of this hierarchy and you can only see the members who are on the right-most part of the structure. For example, the head coach, assistant coaches, and key players might all appear on the right-most side.

Given this structure in the form of a binary tree, return the IDs of the members you can see from the right side, ordered from top to bottom.



Input Format

The first line contains the number of members in the cricket team's hierarchy.
The second line contains the team member IDs in level-order traversal (use null for missing members).


Output Format

The IDs of the members that can be seen from the right side, listed from top to bottom.


Sample Input

7

1 2 3 null 5 null 4



Sample Output

1 3 4



Explanation

The cricket team structure is represented as follows:

   1

  / \

 2  3

  \   \

   5   4

From the right side, the members visible are: 1, 3, and 4.

Member 1 is the head coach, member 3 is a key coach, and member 4 is a player at the bottom of the hierarchy. */
import java.util.ArrayList;

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

public class CricketTeamHierarchyVisualization {

    public static TreeNode buildTree(String[] levelOrder) {
        if (levelOrder == null || levelOrder.length == 0 || levelOrder[0].equals("null")) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(levelOrder[0]));
        ArrayList<TreeNode> queue = new ArrayList<>();
        queue.add(root);

        int index = 1;

        while (!queue.isEmpty() && index < levelOrder.length) {
            TreeNode current = queue.remove(0);

            if (index < levelOrder.length) {
                String leftVal = levelOrder[index];
                if (!leftVal.equals("null")) {
                    current.left = new TreeNode(Integer.parseInt(leftVal));
                    queue.add(current.left);
}
            }

            if (index < levelOrder.length) {
                String rightVal = levelOrder[index];
                if (!rightVal.equals("null")) {
                    current.right = new TreeNode(Integer.parseInt(rightVal));
                    queue.add(current.right);
                }
            }
            index++;
        }

        return root;
    }
}