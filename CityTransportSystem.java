/*City Transportation System

The city’s transportation department is tasked with managing a network of roads between several cities. They want to represent the direct road connections between cities in the form of a graph, where: Cities are represented as nodes. Roads (direct connections between cities) are represented as undirected edges, meaning a road between city u and city v connects both cities in both directions. Due to the size of the network and the need to quickly query connections, the transportation department has decided to use an adjacency list to represent the graph. The adjacency list provides an efficient way to store and process information about the roads. The adjacency list stores each city (node) as a list of its directly connected neighbouring cities (nodes). For example, if there is a road from city 1 to city 2, and another from city 1 to city 3, city 1 will store a list containing cities 2 and 3. You are required to implement the adjacency list representation of the city’s road network. The system will allow users to: Define the number of cities (nodes). Input the roads (edges) between the cities. Display the adjacency list to show which cities are connected by direct roads.



Input Format

An integer n representing the number of cities (nodes).

An integer m representing the number of roads (edges).

m pairs of integers where each pair (u, v) represents a direct road between city u and city v.



Output Format

The adjacency list representation of the graph showing the connections between cities.



Sample Input 1

5

6

1 2

1 3

2 4

3 4

4 5

5 1



Sample Output 1

City 1: 2 3 5

City 2: 1 4

City 3: 1 4

City 4: 2 3 5

City 5: 4 1



Explanation

Cities (nodes): There are 5 cities represented as 1, 2, 3, 4, 5.

Direct roads (edges): There are 6 roads between cities:

A road from city 1 to city 2.

A road from city 1 to city 3.

A road from city 2 to city 4.

A road from city 3 to city 4.

A road from city 4 to city 5.

A road from city 5 to city 1.

The adjacency list representation shows the direct connections between the cities:

City 1 is connected to cities 2, 3, and 5.

City 2 is connected to cities 1 and 4.

City 3 is connected to cities 1 and 4.

City 4 is connected to cities 2, 3, and 5.

City 5 is connected to cities 1 and 4. */
import java.util.*;
class CityTransportSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        for (int city = 1; city <= n; city++) {
            System.out.print("City " + city + ": ");
            for (int neighbor : adjList.get(city)) {
                System.out.print(neighbor+" ");
            }
            System.out.println();
        }
    }
}