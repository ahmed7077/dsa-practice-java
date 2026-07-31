/*City Infrastructure Planning

Imagine you work as a city planner, and your department is responsible for designing and maintaining road networks between different districts of a city. Each district is represented as a node, and the roads between the districts are represented as edges in a graph. Your task is to simulate how transportation would expand outward from one district to all others, where roads are directly connected to the cities(undirectired graph).

To do this, you need to use the Breadth-First Search (BFS) traversal method, which explores all the neighbours at the present depth prior to moving on to nodes at the next depth level.

This would help city planners evaluate the shortest route between two districts and how the transportation network can be improved or expanded efficiently.

Given a graph representing a city’s road network with districts as nodes and direct roads as edges, implement a breadth-first traversal starting from a specified district. The BFS traversal visits all the directly connected districts before moving on to their neighbours.



Input Format

An integer n representing the number of districts (nodes).
An integer m representing the number of roads (edges).
m pairs of integers where each pair (u, v) represents a direct road between district u and district v.
An integer start representing the district to start the BFS traversal from.


Output Format

The order in which the districts are visited using the BFS traversal starting from the specified district.


Sample Input

6

7

1 2

1 3

2 4

3 4

4 5

4 6

5 6

2



Sample Output

2 1 4 3 5 6



Explanation

Districts (nodes): There are 6 districts represented as 1, 2, 3, 4, 5, 6.
Direct roads (edges):
Road from district 1 to district 2.
Road from district 1 to district 3.
Road from district 2 to district 4.
Road from district 3 to district 4.
Road from district 4 to district 5.
Road from district 4 to district 6.
Road from district 5 to district 6.
Starting the BFS traversal from district 2, we visit its neighbors in a level-wise manner:

First, district 2 is visited.
The adjacent districts 1 and 4 are added to the queue.
District 1 is visited next.
Then district 4 is visited, and its neighbors 3, 5, and 6 are queued.
District 3 is visited next, followed by district 5, and finally district 6.
The BFS traversal explores all neighbors at the current level before moving deeper into the graph. */
import java.util.*;
class Graph{
  int v;
  LinkedList<Integer>[] adj;
  boolean visited[];
  Graph(int v){
    this.v=v;
    adj=new LinkedList[v+1];
    for(int i=1;i<=v;i++)
      adj[i]=new LinkedList<>();
    visited=new boolean[v+1];
  }
  void addedges(int a,int b){
    adj[a].add(b);
    adj[b].add(a);
  }
  void bfs(int search){
    visited[search]=true;
    Queue<Integer> q=new LinkedList<>();
    q.offer(search);
    while(!q.isEmpty()){
      int temp=q.poll();
      System.out.print(temp+" ");
      for(int i:adj[temp]){
        if(!visited[i]){
          visited[i]=true;
          q.offer(i);
        }
      }
    }
  }
}
class CityInfrastructurePlanning{
  public static void main(String[]args){
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int m=sc.nextInt();
    Graph g=new Graph(n);
    for(int i=0;i<m;i++){
      int a=sc.nextInt();
      int b=sc.nextInt();
      g.addedges(a,b);
    }
    int start=sc.nextInt();
    g.bfs(start);
  }
}