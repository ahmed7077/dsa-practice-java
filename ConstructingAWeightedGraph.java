/*Constructing a Weighted Graph

You are tasked with designing a transportation system in a city where each intersection is represented as a node and each road connecting the intersections is represented as an undirected edge with a specific weight (cost to travel). Your goal is to create a representation of this weighted graph and display the adjacency list.



Input Format

The first line contains integer n (the number of intersections)
Next line contains the integer m (the number of roads).
Each of the next m lines contains three integers u, v, and w, where u and v are the intersection IDs, and w is the weight of the edge (cost to travel between intersections u and v).


Output Format

Print the adjacency list representation of the weighted graph, where each line corresponds to an intersection and lists its connected intersections along with the corresponding weights.


Sample Input

5

6

1 2 4

1 3 3

2 3 1

2 4 2

3 5 5

4 5 3



Sample Output

1 -> (2, 4) -> (3, 3)

2 -> (1, 4) -> (3, 1) -> (4, 2)

3 -> (1, 3) -> (2, 1) -> (5, 5)

4 -> (2, 2) -> (5, 3)

5 -> (3, 5) -> (4, 3)



Explanation

In the given input:

There are 5 intersections (nodes) and 6 roads (edges).
The roads and their costs are specified as pairs of intersections with weights.
The output represents the adjacency list for each intersection, displaying which intersections are directly connected and the cost to travel to them. */
import java.util.*;

class ConstructingAWeightedGraph {
    static class Edge {
        int destination;
        int weight;
        public Edge(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        ArrayList<ArrayList<Edge>> adjList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int w = scanner.nextInt();

            adjList.get(u).add(new Edge(v, w));
            adjList.get(v).add(new Edge(u, w));
        }

        for (int city = 1; city <= n; city++) {
            System.out.print(city + " ->");
            ArrayList<Edge> neighbors = adjList.get(city);
            for (int i = 0; i < neighbors.size(); i++) {
                Edge edge = neighbors.get(i);
                System.out.print(" (" + edge.destination + ", " + edge.weight + ")");
                if (i < neighbors.size() - 1) {
                    System.out.print(" ->");
                }
            }
            System.out.println();
        }

        scanner.close();
    }
}