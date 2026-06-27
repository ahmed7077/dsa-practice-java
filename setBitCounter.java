/*Jack's Set Bit Counter

Jack is participating in a "Speed Maths" competitive exam for 9th-grade students, where he needs to solve various mathematical problems quickly. One of the problems asks him to count the number of 1s in the binary representation of a given integer. The goal is to help Jack solve the problem efficiently by writing a code that calculates the number of 1s in the binary representation of an integer.

You need to write a program that accepts an integer and returns the number of 1s in its binary representation. If the input is a non-integer or out of range, output an error message.



Input Format

A single integer N.


Constraints

The input should be an integer between 0 and 100000 (inclusive).
If the input is outside the range or not an integer, output "Wrong Input".


Output Format

A single integer representing the number of 1s in the binary representation of N.
If the input is not a valid integer or outside the acceptable range, output "Wrong Input".


Example 1

Sample Input 1

7



Sample Output 1

3



Explanation

The binary representation of 7 is 0111, which contains three 1s. Hence, the output is 3.



Example 2

Sample Input 2

0



Sample Output 2

0



Explanation

The binary representation of 0 is 0000. There are no 1s in this representation, so the output is 0.



Example 3

Sample Input 3

101



Sample Output 3

4 */
import java.util.*;
class setBitCounter{
  public static void main(String []args){
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    if (n<0 || n>100000)
      System.out.println("Wrong Input");
    else{
      int count=0;
      while (n>0){
        if (n%2==1)
          count+=1;
        n/=2;
      }
      System.out.println(count);
    }
  }
}