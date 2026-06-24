/*Calculating the Total Revenue of Orders

In an e-commerce platform, you are tasked with calculating the total revenue generated from the first n orders. Each order is associated with a price that corresponds to its order number (i.e., the first order costs 1 unit, the second order costs 2 units, and so on). The company wants to implement a feature where the total revenue from the first n orders is computed using recursion.



Problem

You are given a positive integer n which represents the number of orders. You need to calculate the total revenue generated from the first n orders using recursion.



Input Format

The input consists of a single integer n (1 ≤ n ≤ 1000), representing the number of orders.


Output Format

The output should be a single integer representing the total revenue generated from the first n orders.


Example 1

Sample Input 1

5



Sample Output 1

15



Explanation

The total revenue from the first 5 orders can be calculated as the sum of natural numbers from 1 to 5:

Revenue = 1 + 2 + 3 + 4 + 5 = 15


Example 2

Sample Input 2 

3



Sample Output 2 

6



Explanation

The total revenue from the first 3 orders is:

Revenue = 1 + 2 + 3 = 6 */
import java.util.*;
class CalculatingTotalRevenue{
  public static void main(String[]args){
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    System.out.print(total(n));
  }
  static int total(int n){
    if(n==0)
      return 0;
    return n+total(n-1);
  }
}