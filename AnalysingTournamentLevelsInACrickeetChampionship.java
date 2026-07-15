/*Analyzing Tournament Levels in a Cricket Championship

In a cricket tournament, the organizer arranges matches in a hierarchy where each level represents a match round. The matches form a binary tree, where the root is the first match of the tournament, and each child node represents subsequent matches. The maximum depth of the tournament structure represents the maximum number of rounds a team has to win to become the champion.

Given the structure of the tournament in the form of a binary tree, find the maximum number of rounds (or depth) of the tournament.



Input Format

First line contains the number of inputs(matches).
The next line contains the input values (matches) in level-order (use "null" for no match at that position).


Output Format

A single integer representing the maximum depth of the tournament structure (binary tree).


Sample Input

7

3 9 20 null null 15 7



Sample Output

3



Explanation

The first value 3 is the root of the binary tree (the first match).
The second and third values 9 and 20 represent the left and right matches of 3.
The values null indicate that node 9 has no children.
The next two values 15 and 7 represent the left and right matches of node 20.
The structure of the binary tree looks like this:

      3

     / \

    9 20

        / \

    15  7

The maximum depth of this binary tree is 3 because the longest path from the root 3 to the farthest leaf nodes (15 or 7) contains 3 nodes. */
import java.util.*;
class Node {
    int data;
    Node left;
    Node right;    
    Node(int data) {
        this.data = data;
    }
}
class AnalysingTournamentLevelsInACrickeetChampionship {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] values = new String[n];
        for (int i = 0; i < n; i++) {
            values[i] = sc.next();
        }
        Node root = Tree(values);
        System.out.println(maxDepth(root));
    }
    public static Node Tree(String[] values) {
        if (values.length == 0 || values[0].equals("null")) {
            return null;
        }
      Node root = new Node(Integer.parseInt(values[0]));
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty() && i < values.length) {
            Node current = queue.poll();            
            if (i < values.length) {
                if (!values[i].equals("null")) {
                    current.left = new Node(Integer.parseInt(values[i]));
                    queue.add(current.left);
                }
                i++;
}
            if (i < values.length) {
                if (!values[i].equals("null")) {
                    current.right = new Node(Integer.parseInt(values[i]));
                    queue.add(current.right);
                }
                i++;
            }
        }
        return root;
    }
    public static int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}