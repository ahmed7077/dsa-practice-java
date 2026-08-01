/*Selecting Diverse Astronauts for a Lunar Mission

The United Nations has initiated a groundbreaking mission to send astronauts from different countries to the moon. However, they need to ensure that the astronauts selected come from various nationalities. To facilitate this, they have gathered information about pairs of astronauts who belong to the same country.

Your task is to determine how many valid pairs of astronauts can be formed such that each pair consists of astronauts from different countries.



Input Format

The first line contains two integers, n (the number of astronauts) and p (the number of pairs). Each of the next p lines contains two space-separated integers denoting astronaut IDs of two who share the same nationality.



Output Format

The output will be a single integer representing the number of valid pairs of astronauts that can be selected from different countries.



Sample Input

5 3

0 1

2 3

0 4



Sample Output

6



Explanation

In this example, astronauts 0 and 1 belong to one country, while 2 and 3 belong to another. The valid pairs of astronauts from different countries can be formed as follows:

(0, 2)
(0, 3)
(2, 4)
(1, 2)
(1, 3)
(3, 4)
Thus, there are a total of 6 valid pairs. */
import java.util.*;
class Graph {
    int vertices;
    List<List<Integer>> adj;
    Graph(int v) {
        vertices = v;
        adj = new ArrayList<>();
        for (int i = 0; i < v; i++)
            adj.add(new ArrayList<>());
    }
    void addEdge(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
    int dfs(int v, boolean[] visited) {
        visited[v] = true;
        int count = 1;
        for (int neighbor : adj.get(v))
            if (!visited[neighbor])
                count += dfs(neighbor, visited);
        return count;
    }
}
class SelectingDiverseAstronautsForLunarMission {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);      
        int n = sc.nextInt();
        int p = sc.nextInt();
        Graph graph = new Graph(n);
        for (int i = 0; i < p; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph.addEdge(u, v);
        }
        boolean[] visited = new boolean[n];
        List<Integer> countrySizes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                countrySizes.add(graph.dfs(i, visited));
            }
        }
        long totalPairs = 0;
        for (int i = 0; i < countrySizes.size(); i++) {
            for (int j = i + 1; j < countrySizes.size(); j++) {
                totalPairs += (long) countrySizes.get(i) * countrySizes.get(j);
            }
        }
        System.out.println(totalPairs);
    }
}