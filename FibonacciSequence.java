/*The Fibonacci Sequence for Future Engineers

In the year 2150, a group of engineering students at the Galactic Institute of Technology is studying algorithms and their applications in computational design. As part of their curriculum, they are learning about recursive functions and their power in solving complex problems.

To enhance their understanding, the instructor has assigned a project where students must calculate Fibonacci numbers using recursion. The Fibonacci sequence is a series of numbers where each number is the sum of the two preceding ones, usually starting with 0 and 1. The task is to write a program that computes the n-th Fibonacci number using a recursive approach.

Write a program that takes a non-negative integer nnn as input and returns the n-th Fibonacci number using recursion.



Input Format

The input consists of a single non-negative integer n.


Constraints

0≤n≤30


Output Format

Print the n-th Fibonacci number.


Example 1

Sample Input 1

5



Sample Output 1

5



Explanation

The Fibonacci sequence up to the 5th term is:

0,1,1,2,3,5

Thus, the 5th Fibonacci number is 5.



Example 2

Sample Input 2

10



Sample Output 2

55



Explanation

The Fibonacci sequence up to the 10th term is:

0,1,1,2,3,5,8,13,21,34,55

Thus, the 10th Fibonacci number is 55. */
import java.util.*;
class FibonacciSequence{
  public static void main(String args[]){
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    System.out.println(fib(n));
  }
  static int fib(int n){
    if (n==0)
      return 0;
    if (n==1)
      return 1;
    return fib(n-1)+fib(n-2);
  }
}