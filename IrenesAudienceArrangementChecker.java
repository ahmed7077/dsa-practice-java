/*Irene's Audience Arrangement Checker
Irene, one of the event organizers, has arranged the audience in a matrix format where boys are represented by 1s and girls by 0s. To win a prize, she must ensure that all girls (0s) are positioned below the main diagonal of the matrix. If she successfully arranges the audience according to this condition, she will be rewarded; otherwise, she will not.

Your task is to help the judges determine if Irene's arrangement is valid by checking if the matrix is an upper triangular matrix.



Problem Statement

Write a program that checks whether a given matrix is an upper triangular matrix. A matrix is considered upper triangular if all the elements below the main diagonal are zero.



Input Format

The first line contains an integer n, representing the number of rows and columns of the square matrix.
The next n lines contain space-separated integers representing the matrix.


Constraints

The matrix is a square matrix (i.e., the number of rows equals the number of columns).


Output Format

Print "Upper triangular matrix" if the condition is satisfied; otherwise, print "Not an Upper triangular matrix"



Example 1

Sample Input 1

3

1 2 3

0 1 2

0 0 1



Sample Output 1

Upper triangular matrix



Explanation

In this input, all elements below the diagonal are 0, hence it is an upper triangular matrix.



Example 2

Sample Input 2

3

0 0 0

0 8 0

4 9 7



Sample Output 2

Not an Upper triangular matrix



Explanation

In this input, the element 4 below the diagonal is not 0, hence it is not an upper triangular matrix. */
import java.util.*;
class IrenesAudienceArrangementChecker{
  public static void main(String []args){
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int[][] A=new int[n][n];
    for (int i=0;i<n;i++)
      for (int j=0;j<n;j++)
        A[i][j]=sc.nextInt();
    int flag=1;
    for (int i=1;i<n;i++)
      for(int j=0;j<i;j++)
        if (A[i][j]!=0){
          flag=0;
          break;
        }
    if (flag==0)
      System.out.println("Not an Upper triangular matrix");
    else
      System.out.println("Upper triangular matrix");
  }
}