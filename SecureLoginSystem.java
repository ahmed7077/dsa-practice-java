/*Secure Login System Password Validator
Imagine a web application development scenario where you are responsible for implementing a secure login system. As part of this, you need to enforce specific rules to ensure that users set strong and secure passwords. The security team has provided you with password validation rules to protect against unauthorized access.

Your task is to create a function that checks if a given password is valid based on these rules. This function will help users choose secure passwords and prevent common vulnerabilities in the application.



Function Description

int CheckPassword(char str[], int n);

The function accepts a string str of size n as an argument and returns 1 if the given string str is a valid password and 0 otherwise. A valid password must satisfy the following conditions:

The password must be at least 4 characters long.
It must contain at least one numeric digit.
It must contain at least one uppercase letter.
It must not contain any spaces or slashes (/).
The first character of the password must not be a number.


Assumption

The input string will not be empty.



Input Format

A single string str that represents the password to be validated.


Constraints

The password will be a non-empty string containing alphanumeric characters and special characters.


Output Format

Return 1 if the password is valid.
Return 0 if the password is invalid.


Example 1

Sample Input 1

aA1_67



Sample Output 1

1



Explanation

The password aA1_67 is valid because:
It is at least 4 characters long.
It contains at least one numeric digit (1).
It contains at least one uppercase letter (A).
It does not contain spaces or /.
The first character is not a number.


Example 2

Sample Input 2

A987 abC012



Sample Output 2

0



Explanation

The password A987 abC012 is invalid because:
It contains a space.
Thus, the function returns 0.
 */
import java.util.*;
class SecureLoginSystem{
  public static void main(String[]args){
    Scanner sc=new Scanner(System.in);
    String s=sc.nextLine();
    int n=s.length();
    if (n<4 || Character.isDigit(s.charAt(0)) || s.contains(" ") || s.contains("/")){
      System.out.println(0);
      return;
    }
    int upper=0;
    int digit=0;
    for (int i=0;i<n;i++){
      char ch=s.charAt(i);
      if (Character.isUpperCase(ch))
        upper++;
      if (Character.isDigit(ch))
        digit++;
    }
    System.out.println((upper>0 && digit >0) ? 1:0);
  }
}