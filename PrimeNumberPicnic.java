/*Prime Number Picnic

You are planning a picnic for a group of friends who love math. To make it interesting, you decided to bring unique numbers of items, N. Your task is to find and return an integer value representing the sum of all the prime numbers till N. In case, the number of items is 0 or 1, return 0.



Note

Prime numbers are natural numbers that are divisible by only 1 and the number itself.



Input Format

Input1: An integer value N



Output Format

Return an integer value representing the sum of the prime numbers till N. In case, the number of items is not prime, return 0.



Example 1

Sample Input 1

Input1: 10



Sample Output 1

17



Explanation

Here, N = 10. The prime numbers between 2 and 10 are 2, 3, 5, 7 and their sum is 17. Hence, 17 is returned as the output.



Example

Sample Input 2

Input1: 20



Samle Output 2

77



Explanation

Here, N = 20. The prime numbers between 2 and 20 are 2, 3, 5, 7, 11, 13,17 ,19 and their sum is 77. Hence, 77 is returned as the output. */
import java.util.*;
public class PrimeNumberPicnic
{
 public static void main(String args[])
 {
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int sum=0;
    if(n<=0){
        System.out.print(0);
        return;
    }
    for(int i=2;i<=n;i++)
    {
        boolean prime=true;
        for(int j=2;j<=i/2;j++)
        {
            if(i%j==0)
            {
                prime=false;
                break;
            }
        }
        if(prime)
            sum+=i;
    }
    System.out.print(sum);
 }   
}
