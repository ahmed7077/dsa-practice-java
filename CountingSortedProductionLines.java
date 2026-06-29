/*Counting Sorted Production Lines
In a manufacturing plant, items produced in assembly lines are arranged in rows for quality control. Each row represents a production line, and each item in the row has a quality score. The plant's quality assurance team needs to identify how many production lines have items sorted in non-decreasing order based on their quality scores.

Write a program that counts the number of rows in the matrix that are sorted in non-decreasing order.



Input Format

The first line contains two integers, m (number of rows) and n (number of columns).
The next m lines contain n integers each, representing the quality scores of items in each production line.


Output Format

Print the total count of rows that are sorted in non-decreasing order.


Constraints

1≤m,n≤100
The quality scores are integers ranging from −1000 to 1000.


Sample Input

4 5

10 20 30 40 50

15 10 5 0 -5

5 5 6 7 8

9 11 10 13 14



Sample Output

2



Explanation

Input Matrix (Quality Scores of Items in Production Lines)

10 20 30 40 50 -> Sorted

15 10 5 0 -5   -> Not sorted

5 5 6 7 8      -> Sorted

9 11 10 13 14  -> Not sorted

The 1st and 3rd rows are sorted in non-decreasing order, so the output is 2.



Output

The program counts the rows where quality scores are sorted in non-decreasing order. */
import java.util.*;
class CountingSortedProductionLines{
  public static void main(String[]args){
    Scanner sc=new Scanner(System.in);
    int r=sc.nextInt();
    int c=sc.nextInt();
    int ans=0;
    for (int i=0;i<r;i++){
      int prev=Integer.MIN_VALUE;
      int sorted=1;
      for (int j=0;j<c;j++){
        int curr=sc.nextInt();
        if (prev>curr)
            sorted=0;
        prev=curr;
      }
      ans+=sorted;
    }
    System.out.println(ans);
  }
}