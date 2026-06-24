/*Character Count
You are given a string S of length N. Your friend wants to know the number of times his favorite letter C occurs in the string. Your task is to help your friend find and return an integer value representing the number of times a character occurs in a particular string.



Note

All the characters in the strings are in lowercase.



Input Format 

Input1: A string S

Input2: An integer N, representing the length of string

Input3: A character C



Output Format

Return an integer value representing the number of times a character occurs in a particular string



Example 1

Sample Input 1

Input1: helloworld

Input2: 10

Input3: l



Sample Output 1

3



Explanation

Here the given string is "helloworld" and the length of the string is 10 and the character whose count is to be found is "I". The number of times "I" occurs in the string is 3. Therefore, 3 is returned as the output.



Example 2

Sample Input 2

Input1: mercermettl

Input2: 11

Input3: t



Sample Output 2

2



Explanation

Here the given string is "mercermettl" and the length of the string is 11 and the AOS character whose count is to be found is "t". The number of times "t" occurs in the string is 2. Therefore, 2 is returned as the output. */
import java.util.*;
class CharacterCount{
  public static void main(String[]args){
    Scanner sc=new Scanner(System.in);
    String s=sc.nextLine();
    int n=sc.nextInt();
    char c=sc.next().charAt(0);
    int count=0;
    for (int i=0;i<n;i++){
      char ch=s.charAt(i);
      if (ch==c)
        count+=1;
    }
    System.out.println(count);
  }
}