/*Identifying Maximum Defect Levels in Production Batches
In a manufacturing unit, a quality control team is tasked with monitoring defect levels across multiple production batches. The defect levels for each item in a batch are recorded in a matrix format, where each row represents a production batch and each column represents the defect level of an item within that batch.

The quality control team needs to find the maximum defect level in each production batch to identify the most defective item in each batch. Write a program to help them identify the maximum defect levels for all production batches.



Input Format

The first line contains two integers, m (number of production batches) and n (number of items in each batch).
The next m lines contain n integers each, representing the defect levels of items in each batch.


Output Format

Output m integers, each representing the maximum defect level in the corresponding production batch.


Sample Input

3 4

5 3 8 6

2 9 4 7

1 6 3 8



Sample Output

8

9

8



Explanation

Input Matrix (Defect Levels)

Copy code

5 3 8 6

2 9 4 7

1 6 3 8

Batch 1: The maximum defect level is 8.

Batch 2: The maximum defect level is 9.

Batch 3: The maximum defect level is 8.



Output

The program outputs the maximum defect level for each batch, which helps the quality control team quickly assess the severity of defects in each batch. */
import java.util.*;
class IdenctifyingMaximumDefectLevels{
  public static void main(String args[]){
    Scanner sc=new Scanner(System.in);
    int r=sc.nextInt();
    int c=sc.nextInt();
    int[][] A=new int[r][c];
    for (int i=0;i<r;i++)
      for (int j=0;j<c;j++)
        A[i][j]=sc.nextInt();
    for (int i=0;i<r;i++){
      int max=A[i][0];
      for (int j=0;j<c;j++)
        if (A[i][j]>max)
          max=A[i][j];
      System.out.println(max);
    }
  }
}