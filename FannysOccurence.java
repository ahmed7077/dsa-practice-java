/*Fannys occurrence

Fanny is given a string along with the string which contains single character x. She has to remove the character x from the given string. Help her write a function to remove all occurrences of x character from the given string.



Note

The operation is case-sensitive (i.e., 'o' and 'O' are different).



Input Format 

input1: input string s

input2: String containing any character x



Output Format

String without the occurrence of character x



Example 1

Sample Input 1

Input1: welcome to mettl

Input2: l



Sample Output 1

wecome to mett



Explanation

As I is the character which is required to be removed, therefore all the occurrences of I are removed, keeping all other characters.



Example 2

Sample Input 2

Input1: Lord out of Rings

Input2: o



Sanple Output 2

Lrd ut f Rings



Explanation 

As o is the character which is required to be removed, therefore all the occurrences of o are removed, keeping all other characters.

 */
import java.util.*;
class FannysOccurence{
  public static void main(String []args){
    Scanner sc=new Scanner(System.in);
    String s=sc.nextLine();
    char c=sc.next().charAt(0);
    String result="";
    for (int i=0;i<s.length();i++){
      char ch=s.charAt(i);
      if (ch!=c)
        result+=ch;
    }
    System.out.println(result);
  }
}