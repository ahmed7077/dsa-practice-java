/*Finding the Leaders in Sales Data
You are working in a sales department where you are analyzing sales data for a particular month. Each element in the array represents the total sales value for a given day of the month. You are tasked with identifying the leaders in the sales data, where a leader is defined as a sales value that is higher than all the sales values to its right. The rightmost sales value of the month is always a leader. Once you identify all the leaders, your task is to calculate their total sum.



Function Signature

int SumOfLeaders(int arr[], int n);

This function accepts an array arr[] of size n where each element in the array represents the sales for a specific day. It returns the sum of the leaders in the array.



Assumptions

The sales values in the array are distinct integers.
The array contains sales data for at least one day (i.e., n > 0).
If the array is empty, return -1.


Note

If the array is empty or None (in case of Python), return -1.


Input Format

The first input is an integer n, representing the number of days (length of the array).
The second input is a space-separated list of integers representing the sales data for n days.


Output Format

The output should be an integer representing the sum of the leader elements in the array.


Example 1

Sample Input 1

7

52 66 64 36 45 24 32



Sample Output 1

207



Explanation  

The leaders in the array are:

66 (since it is greater than 64, 36, 45, 24, and 32)
64 (since it is greater than 36, 45, 24, and 32)
45 (since it is greater than 24 and 32)
32 (since it is the rightmost element)
The sum of the leaders is: 66 + 64 + 45 + 32 = 207.



Example 2

Sample Input 2

4

33 7 28 14



Sample Output 2

75



Explanation  

The leaders in the array are:

33 (since it is greater than 7, 28, and 14)
28 (since it is greater than 14)
14 (since it is the rightmost element)
The sum of the leaders is: 33 + 28 + 14 = 75. */
import java.util.*;
class FindingLeadersInSalesData{
  public static void main(String[]args){
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int[] l=new int[n];
    for (int i=0;i<n;i++)
      l[i]=sc.nextInt();
    System.out.println(leader(l,n));
  }
  static int leader(int l[],int n){
    int max=l[n-1];
    int sum=0;
    sum+=max;
    for (int i=n-2;i>-1;i--){
      if (l[i]>max){
        max=l[i];
        sum+=l[i];
      }
    }
    return sum;
  }
}