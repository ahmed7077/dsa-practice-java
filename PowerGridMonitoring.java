/*Power Grid Monitoring - Computing Diagonal Load Balances

In a power distribution center, the load levels are monitored and recorded in a grid-like structure to analyze how power is being distributed across different regions. The grid is represented as an n×n matrix, where each element represents the load level at a specific point in the grid.

The engineers are interested in efficiently calculating the sum of load levels along the two main diagonals:

Primary diagonal: From the top-left to the bottom-right.
Secondary diagonal: From the top-right to the bottom-left.
Write a program to compute the sum of the load levels along both diagonals.



Input Format

The first line contains a single integer, n (the size of the square matrix).
The next n lines contain n integers each, representing the load levels in the grid.


Output Format

Print two integers: the sum of the primary diagonal and the sum of the secondary diagonal, separated by a space.


Sample Input

3

5 2 3

8 6 4

1 9 7



Sample Output

18 10



Explanation

Input Matrix (Load Levels):

5 2 3

8 6 4

1 9 7

Primary Diagonal: 5+6+7=18

Secondary Diagonal: 3+6+1=10



Output The program outputs 18 10, which represents the sum of the primary and secondary diagonals, respectively. */
import java.util.*;
class PowerGridMonitoring{
  public static void main(String args[]){
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int[][] A=new int[n][n];
    for (int i=0;i<n;i++)
      for (int j=0;j<n;j++)
        A[i][j]=sc.nextInt();
    int d1=0;
    int d2=0;
    for (int i=0;i<n;i++){
          d1+=A[i][i];
          d2+=A[i][n-1-i];
    }
    System.out.println(d1+" "+d2);
  }
}