/*Finding the Greatest Common Divisor in Ancient Math

In the year 3000 BC, in the ancient city of Mesopotamia, mathematicians were discovering the wonders of numbers. Among their many studies, they found the need to simplify fractions, which led to the exploration of the Greatest Common Divisor (GCD). The GCD of two numbers is the largest positive integer that divides both numbers without leaving a remainder.

To help the young mathematicians master this concept, their wise teacher has assigned them a project to calculate the GCD of two positive integers using a recursive method. This task not only enhances their understanding of numbers but also builds their problem-solving skills.

Write a program that takes two positive integers as input and returns their GCD using recursion.



Input Format

The input consists of two positive integers, aaa and bbb.


Constraints:

1≤a,b≤106


Output Format

Print the GCD of the two integers.


Example 1

Sample Input 1

48 18



Sample Output 1

6



Explanation

The GCD of 48 and 18 is 6, as 6 is the largest number that divides both 48 and 18 without leaving a remainder.



Example 2

Sample Input 2

56 98



Sample Output 2

14



Explanation

The GCD of 56 and 98 is 14, as 14 is the largest number that divides both 56 and 98 without leaving a remainder */
import java.util.Scanner;

public class FindingGCD {
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println(gcd(a, b));
    }
}