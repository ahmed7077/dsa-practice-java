/*Constructing a Social Network Graph

In a social network, different users are connected through friendships. You need to represent the connectivity of these users using an undirected graph. Each user is represented as a vertex, and each friendship connecting two users is represented as an edge. Your task is to create an adjacency matrix representation of this graph. Additionally, you should allow the user to input the number of users and the friendships that connect them.



Input Format

The first line contains an integer n, the number of nodes (people) in the graph.
The second line contains an integer m, the number of edges (connections) in the graph.
The next m lines each contain two space-separated integers u and v, representing an edge between nodes u and v.


Output Format

Print the adjacency matrix of the graph.


Sample Input

4

5

1 2

1 3

2 4

3 4

1 4



Sample Output

0 1 1 1

1 0 0 1

1 0 0 1

1 1 1 0



Explanation

The input defines a graph with 4 nodes and 5 edges.
The output shows the adjacency matrix where:
A 1 indicates the presence of an edge between two nodes.
A 0 indicates no edge. */
import java.util.*;
class Graph{
  int vertices;
  int[][] mat;
  Graph(int vertices){
    this.vertices=vertices;
    mat=new int[vertices][vertices];
  }
  void addedges(int source,int destination){
    mat[source-1][destination-1]=1;
    mat[destination-1][source-1]=1;
  }
  void display(){
    for(int i=0;i<vertices;i++){
      for(int j=0;j<vertices;j++)
        System.out.print(mat[i][j]+" ");
      System.out.println();
    }
  }
}
class ConstructingASocialNetworkGraph{
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
    g.display();
  }
}