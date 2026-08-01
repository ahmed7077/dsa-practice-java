/*Shortest Route Finder in a City
In a city, there are neighborhoods connected by roads, forming an undirected graph where each road has a uniform length of 6 units. Given multiple scenarios, you are tasked with determining the shortest distance from a specified starting neighborhood to all other neighborhoods. If a neighborhood is unreachable from the starting point, it should be reported with a distance of -1.

You will be provided with a number of queries, where each query describes a unique graph. For each query, you need to create a representation of the graph based on the given roads and calculate the shortest distances from the starting neighborhood using the breadth-first search (BFS) algorithm.



Input Format

The first line contains an integer qqq, the number of queries.
Each query consists of:
The first line containing two space-separated integers nnn (number of nodes) and mmm (number of edges).
The next mmm lines, each containing two space-separated integers uuu and vvv representing an edge between nodes uuu and vvv.
The last line of the query contains a single integer sss, the starting node for BFS.


Output Format

For each query, return a single line containing the distances from the starting node to all other nodes in increasing order of node numbers. The distances should be space-separated. If a node is unreachable, indicate this with -1.



Sample Input 1

2

4 2

1 2

1 3

1

3 1

2 3

2



Sample Output 1

6 6 -1

-1 6



Explanation

In the first query, the distances from node 1 to nodes 2, 3, and 4 are 6, 6, and -1, respectively.

In the second query, the distances from node 2 to nodes 1 and 3 are -1 and 6, respectively.

 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ShortestRouteFinderInACity {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        
        int q = sc.nextInt();

        while (q-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                adj.add(new ArrayList<>());
            }

            for (int i = 0; i < m; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                adj.get(u).add(v);
                adj.get(v).add(u);
            }

            int start = sc.nextInt();
            int[] distances = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                distances[i] = -1;
            }

            Queue<Integer> queue = new LinkedList<>();
}