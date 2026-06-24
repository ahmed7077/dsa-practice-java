/*Authentication Check for Secure Locker Access
In a secure facility, lockers are protected with special numeric codes. These codes are considered valid only if they are Armstrong Numbers. An Armstrong Number (or Narcissistic Number) for a three-digit number is a number for which the sum of the cubes of its digits is equal to the number itself. Your task is to create a program to verify if a given locker code is valid for access.

Imagine a security officer who needs to check if the locker code provided is valid. If the code is an Armstrong Number, access is granted with the label "Access Granted," otherwise, it is denied with the label "Access Denied."



Input Format

The first line of input contains an integer N, representing the locker code (a three-digit number).


Output Format

Print "Access Granted" if the locker code is an Armstrong Number.
Print "Access Denied" if the locker code is not an Armstrong Number.


Example 1

Sample Input 1

153



Sample Output 1

Access Granted



Explanation

The digits of 153 are 1, 5, and 3.
The cube of 1 is 1, the cube of 5 is 125, and the cube of 3 is 27.
The sum of the cubes: 1 + 125 + 27 = 153, which is equal to the number itself.
Hence, the locker code 153 is an Armstrong Number, so the output is "Access Granted."


Example 2

Sample Input 2

123



Sample Output 2

Access Denied



Explanation

The digits of 123 are 1, 2, and 3.
The cube of 1 is 1, the cube of 2 is 8, and the cube of 3 is 27.
The sum of the cubes: 1 + 8 + 27 = 36, which is not equal to the number itself.
Hence, the locker code 123 is not an Armstrong Number, so the output is "Access Denied." */
import java.util.Scanner;
public class AuthCheck 
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int sum=0;
        int temp=n;
        while(temp!=0)
        {
            int digit=temp%10;
            sum+=Math.pow(digit,3);
            temp/=10;
        }
        if(sum==n)
            System.out.print("Access Granted");
        else
            System.out.print("Access Denied");  
    }
    
}
