/*Largest prime divisor
Clint loves numbers so much, that he tries to find some quirky math tricks whenever he can. One day, he decides to take up a number and tries to find out it's largest prime divisor.



Note

Largest prime divisor has to be greater than 1 and less than the number itself. If there is no such divisor, then return -1



Input Format

Input1: The number N



Output Format

Return the largest prime divisor



Example 1

Sample Input 1

Input1: 9



Sample Output 1

3



Explanation

Here, 9 divisor is only 3 which is also prime.

Hence the output is 3



Example 2

Sample Input 2

Input1: 20



Sample Output 2

5



Explanation

Here, 20 divisor are 1, 2, 4, 5, 10

The largest prime divisor is 5.

Hence the output is 5. */
import java.util.Scanner;
public class LargestPrimeDivisor{
  public static void main(String[]args){
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int lar=0;
    for (int i=2;i<n;i++){
      if (n%i==0){
        int count=0;
        for (int j=2;j<i;j++)
          if (i%j==0)
            count+=1;
        if (count==0)
          lar=i;
      }
    }
    System.out.println(lar);
  }
}