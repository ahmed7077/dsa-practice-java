/*Perfect Number Detection for Vault Security
In a high-security vault, the system checks the integrity of access codes to ensure they are "perfect" codes. A "perfect" code is a special access code where the sum of its proper divisors (excluding the code itself) equals the code number. If the code is perfect, the system grants access; otherwise, it returns the sum of its proper divisors to indicate the code's validity. Your task is to write a program that determines if a given code is perfect or returns the sum of its proper divisors.

Write a function that accepts an integer n representing the access code and:

Returns 1 if the number is a perfect number.
Otherwise, returns the sum of the proper divisors of the number.


Function Signature

int detectPerfectNumber(int n)



Input Format

The input consists of a single integer n.


Output Format

The output is either 1 (if n is a perfect number) or the sum of the proper divisors of n.


Example 1

Sample Input 1

22



Sample Output 1

14



Explanation  

The proper divisors of 22 are 1, 2, and 11. The sum of these divisors is 14, which is not equal to 22. Hence, the code is not perfect, and the sum of proper divisors 14 is returned.



Example 2

Sample Input 2 

6



Sample Output 2

1



Explanation  

The proper divisors of 6 are 1, 2, and 3. The sum of these divisors is 6, which is equal to the number itself. Hence, the number 6 is a perfect number, and the output is 1. */
import java.util.*;
class PerfectNumverDetection{
  public static void main(String[]args){
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    System.out.println(perNum(n));
  }
  static int perNum(int n){
    int sum=0;
    for (int i=1;i<=n/2;i++)
      if (n%i==0)
        sum+=i;
    if (sum==n)
      return 1;
    else
      return sum;
  }
}