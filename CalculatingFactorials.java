/*Calculating Factorials for the Space Expedition

In the futuristic world of 2140, a team of astronauts is preparing for a journey to Mars. As part of their training, they are required to calculate various mathematical functions, one of which is the factorial of a number. To streamline their calculations, the team decided to implement a program that uses recursion to compute the factorial. Your task is to help them write a program that calculates the factorial of a given number using a recursive approach.

Write a program that takes a non-negative integer as input and returns its factorial using recursion.



Input Format

The input consists of a integer n between 0 and 20


Constraits

0<=n<=20



Output Format

Print the factorial of the number.


Example 1

Sample Input 1

5



Sample Output 1

120



Explanation

The factorial of 5 is calculated as:

5!=5×4×3×2×1=120



Example 2

Sample Input 2

0



Sample Output 2

1



Explanation

The factorial of 0 is defined as:

0!=1



Example 3

Sample Input 3

-3



Sample Ouput 3

Invalid input! Please enter a number between 0 and 20. */
import java.util.*;
class CalculatingFactorials{
  public static void main(String[]args){
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    if (n<0 || n>20)
      System.out.println("Invalid input! Please enter a number between 0 and 20.");
    else
      System.out.println(fact(n));
  }
  static int fact(int n){
    if (n==0 || n==1)
      return 1;
    return n*fact(n-1);
  }
}