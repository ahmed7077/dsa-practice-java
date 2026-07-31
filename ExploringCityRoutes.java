/*Exploring City Routes

Imagine you work for the City Transportation Department, and they are trying to analyze all possible road routes between various cities. The cities are represented as nodes, and the direct roads between the cities are represented as edges in a graph. Your goal is to simulate exploring all the routes starting from one city and traversing through neighboring cities before backtracking.

This traversal is conducted using the Depth-First Search (DFS) technique, which explores as far as possible along each branch before backtracking.

For example, the department might want to check the routes by starting from one city and moving through its connected cities one by one, deeply exploring each possible road path.

You are tasked with implementing a program to perform depth-first traversal on a graph representing cities and roads. The system will:

Input the number of cities and roads.
Perform a DFS traversal starting from a specified city.


Input Format

An integer n representing the number of cities (nodes).
An integer m representing the number of roads (edges).
m pairs of integers where each pair (u, v) represents a bidirectional road (undirected edge) between city u and city v.
An integer start representing the city to start the DFS traversal from.


Output Format

The order in which the cities are visited using the DFS traversal starting from the specified city.


Sample Input

5

6

1 2

1 3

2 4

3 4

4 5

5 1

3



Sample Output

3 1 2 4 5




Explanation

Cities (nodes): There are 5 cities represented as 1, 2, 3, 4, 5.
Direct roads (edges):
Road from city 1 to city 2.
Road from city 1 to city 3.
Road from city 2 to city 4.
Road from city 3 to city 4.
Road from city 4 to city 5.
Road from city 5 to city 1.
Starting the DFS traversal from city 3, the traversal visits city 3 first. From city 3, it moves to city 1 (connected via a road). From city 1, it goes to city 2. From city 2, it visits city 4, and from city 4, it visits city 5. The traversal follows the depth-first approach, visiting as far as possible along each branch before backtracking. */
import java.util.*;
class Graph{
  int v;
  LinkedList<Integer>[] adj;
  boolean[] visited;
  Graph(int v){
    this.v=v;
    adj=new LinkedList[v+1];
    for(int i=0;i<=v;i++)
      adj[i]=new LinkedList<>();
    visited=new boolean[v+1];
  }
  void addedges(int a, int b){
    adj[a].add(b);
    adj[b].add(a);
  }
  void dfs(int search){
    visited[search]=true;
    System.out.print(search+" ");
    for(int number:adj[search]){
      if(!visited[number])
        dfs(number);
    }
  }
}
class ExploringCityRoutes{
  public static void main(String[]args){
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    Graph g=new Graph(n);
    int m=sc.nextInt();
    for(int i=0;i<m;i++){
      int a=sc.nextInt();
      int b=sc.nextInt();
      g.addedges(a,b);
      
    }
    int start=sc.nextInt();
    g.dfs(start);
  }
}