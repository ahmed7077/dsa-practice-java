/*Finding the Median of Positive Product IDs

You are managing an inventory system, and you have an array of product IDs. Some of the IDs may be negative, which indicates a faulty product that should be ignored. You need to determine the product ID at the middle of the list, but only considering the positive product IDs. If there are two mid indices after ignoring the negative IDs, you are required to return the element at the larger index.

Write a function to find and return the product ID at the mid index from the list of positive product IDs, ignoring all negative IDs. If there are two mid indices, return the product ID at the larger index.



Input Format

The first line contains an integer n, representing the number of product IDs.
The second line contains n integers, representing the product IDs. These can include both positive and negative numbers.


Output Format

Print the product ID located at the mid-index of the array after ignoring all negative product IDs.


Assumptions

If there is no positive numbers in array return -1
If there are two mid indices after ignoring negative numbers, return the one at the larger index.


Example 1

Sample Input 1

6

11 23 -3 3 -5 -32



Sample Output 1

23



Explanation  

After removing negative numbers from the array, the positive product IDs are {11, 23, 3}. The middle product ID is 23, which is the mid index of the filtered array.



Example 2 

Sample Input 2

7

10 -5 12 7 8 -18 3



Sample Output 2

7



Explanation  

After removing negative numbers from the array, the positive product IDs are {10, 12, 7, 8, 3}. The mid index is 2, and the corresponding product ID is 7.



Example 3

Sample Input 3

5

-10 -20 -30 -40 -50



Sample Output 3

-1



Explanation

All values are negative, so positiveCount=0

Your code checks for this and returns -1 when there are no positive product IDs. */
import java.util.*;
class FindingMedian{
  public static void main(String[]args){
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int[] A=new int[n];
    for (int i=0;i<n;i++)
      A[i]=sc.nextInt();
    int m=0;
    for (int i=0;i<n;i++)
      if (A[i]>-1)
        m+=1;
    for (int i=0;i<n;i++)
      for (int j=i+1;j<n;j++){
        if (A[i]<0){
          int temp=A[i];
          A[i]=A[j];
          A[j]=temp;
        }
      }
    if (m==0)
      System.out.println(-1);
    else
      System.out.println(A[m/2]);
  }
}