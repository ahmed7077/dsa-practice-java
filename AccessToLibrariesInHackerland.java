/*Access to Libraries in HackerLand
HackerLand is a country made up of n cities, which currently have no libraries and are not connected. You are tasked with ensuring that all citizens have access to a library. A citizen has access to a library if either their city contains a library or they can travel via roads to a city that has a library.

You have the option to build roads between cities at a cost of c_road and to build a library in any city at a cost of c_lib. Given several queries, each describing a different configuration of cities and roads, your goal is to determine the minimum total cost required to provide library access to all citizens.



Input Format

The first line contains a single integer q, denoting the number of queries.
For each query, the first line contains four space-separated integers n, m, c_lib, and c_road.
Each of the next m lines contains two space-separated integers, denoting a bidirectional road that can be built between two cities.


Output Format

For each query, output a single line containing a single integer, which represents the minimum cost required to provide library access to all citizens.



Sample Input

2

3 3 2 1

1 2

3 1

2 3

6 6 2 5

1 3

3 4

1 2

2 3

5 6

3 4



Sample Output

4

12



Explanation

For the first query, the minimum cost to provide library access is 4, achieved by building one library and two roads.
For the second query, the minimum cost is 12, where libraries and roads are optimized to minimize total expenditure. */
import java.util.ArrayList;
import java.util.Scanner;

public class AccessToLibrariesInHackerland {

    static void dfs(int u, ArrayList<ArrayList<Integer>> adj, boolean[] visited, int[] count) {
        visited[u] = true;
        count[0]++;
        for (int v : adj.get(u)) {
            if (!visited[v]) {
                dfs(v, adj, visited, count);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int q = sc.nextInt();

        while (q-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            long cLib = sc.nextLong();
            long cRoad = sc.nextLong();

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
            boolean[] visited = new boolean[n + 1];
            long totalCost = 0;

            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    int[] count = new int[1];
                    dfs(i, adj, visited, count);
                    long costWithRoads = cLib + (count[0] - 1) * cRoad;
                    long costWithLibrariesOnly = count[0] * cLib;
                    totalCost += Math.min(costWithRoads, costWithLibrariesOnly);
                }
            }

            System.out.println(totalCost);
        }
    }
}