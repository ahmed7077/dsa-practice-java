/*Road Network Connectivity
Imagine you are working with a road management system that monitors cities and roads connecting them. Each road allows traffic to flow in one direction (represented by a directed edge in a graph). The management wants to know whether every city in the network is reachable from any other city, ensuring smooth transportation throughout the country.

In this scenario, cities are represented as nodes in a directed graph, and roads between cities as directed edges. The goal is to check if the road network is connected, meaning there is a path from any city to all other cities, and vice versa.



Problem Statement

You are given a directed graph representing cities and one-way roads. Write a program to check whether the graph is connected. A directed graph is connected if:

All nodes (cities) can be reached starting from any given node.
Every node must also have a path back to any other node.


Input Format

An integer n representing the number of cities (nodes).
An integer m representing the number of one-way roads (edges).
m pairs of integers, where each pair (u, v) represents a one-way road from city u to city v.


Output Format

Print "The road network is connected." if all nodes are reachable from any starting city.
Print "The road network is not connected." if there is any city that cannot be reached.


Example 1

Sample Input 1

4

5

1 2

2 3

3 4

4 1

2 4



Sample Output 1

The road network is not connected.



Explanation

In this case, the road network is not fully connected:

You can travel from city 1 to city 2, from city 2 to city 3, and from city 3 to city 4.
However, there is no road back to city 1 from city 4 or any other cities. Therefore, the road network is not connected.


Example 2

Sample Input 2

5

6

1 2

2 3

3 4

4 5

5 1

2 4



Sample Output 2

The road network is connected.



Explanation

In this example, the road network forms a strongly connected graph. Let's check the connectivity:

Starting from city 1:
You can reach city 2 directly.
From city 2, you can travel to city 3.
From city 3, you can travel to city 4.
From city 4, you can travel to city 5.
From city 5, you can travel back to city 1.
Reversed Graph:
The graph is reversed to check if every city can also reach city 1.
From city 5, there is a direct road to city 4.
From city 4, you can reach city 3 and then city 2.
From city 2, you can travel back to city 1.
Since all cities can be reached from any other city and you can also travel back to the starting city from any other city, the network is fully connected. */
import java.util.ArrayList;
import java.util.Scanner;

public class RoadNetworkConnectivity {

    static void dfs(int u, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        visited[u] = true;
        for (int v : adj.get(u)) {
            if (!visited[v]) {
                dfs(v, adj, visited);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        ArrayList<ArrayList<Integer>> reverseGraph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
            reverseGraph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.get(u).add(v);
            reverseGraph.get(v).add(u);
        }

        boolean[] visited = new boolean[n + 1];
}