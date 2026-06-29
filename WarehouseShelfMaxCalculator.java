/*Warehouse Shelf Max Quantity Finder
In a large warehouse, products are organized on a series of vertical shelves arranged in rows and columns. The warehouse manager needs to know the maximum quantity of items available in each column to make better decisions for restocking. Write a program that calculates the maximum quantity of items present in each column.



Input Format

The first line of input contains an integer n, which represents the number of rows and columns in the grid (n x n grid).
The next n lines each contain n integers, representing the quantity of items in each cell of the grid.


Output Format

Print the maximum quantity for each column on a new line.



Example 1

Sample Input 1

3

5 1 9

2 8 6

7 4 3



Sample Output 1

7

8

9



Explanation

Input Details

The warehouse has a 3x3 grid representing the quantity of items:

5 1 9

2 8 6

7 4 3

Maximum Quantity in Each Column

Column 1: The values are 5, 2, and 7. The maximum is 7.
Column 2: The values are 1, 8, and 4. The maximum is 8.
Column 3: The values are 9, 6, and 3. The maximum is 9.


Example 2

Sample Input 2

2

10 15

20 5



Sample Output 2

20

15



Explanation

Input Details

The warehouse has a 2x2 grid representing the quantity of items:

10 15

20 5

Maximum Quantity in Each Column

Column 1: The values are 10 and 20. The maximum is 20.
Column 2: The values are 15 and 5. The maximum is 15.
 */
import java.util.*;
class WarehouseShelfMaxCalculator{
  public static void main(String args[]){
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int[][] A=new int[n][n];
    for (int i=0;i<n;i++)
      for (int j=0;j<n;j++)
        A[i][j]=sc.nextInt();
    for (int j=0;j<n;j++){
      int high=0;
      for (int i=0;i<n;i++){
        if (A[i][j]>high)
          high=A[i][j];
      }
      System.out.println(high);
    }
  }
}