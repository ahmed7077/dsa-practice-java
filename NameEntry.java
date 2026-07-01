/*Name Entry
Your friend has made entry of a name in the form first name F and last name L in your contact list. But some letters are in uppercase while others are in lowercase Your task is to find and return a string representing the names such that the first name of your contact is in lowercase, and the last name of your contact is in uppercase.



Input Format

Input1: A string F, representing the first name.

Input2: A string L, representing the last name.



Output Format

Return a string representing the names such that the first name of your contact is in lowercase, and the last name of your contact is in uppercase.



Example 1

Sample Input 1

Input1: Lily

Input2: Johnson



Sample Output 1

lily JHONSON



Explanation

Here the First Name is "Lily" and Last Name is "Johnson". On converting first name in lower case we get "lily" and on converting last name in uppercase we get "JOHNSON". Therefore, "lily JOHNSON" is returned as the output.



Example 2

Sample Input 2

Input1:ADAM

Input2: clarke



Sample Output 2

adam CLARKE



Explanation

Here the First Name is "ADAM" and Last Name is "clarke". On converting first name in lower case we get "adam" and on converting last name in uppercase we get "CLARKE". Therefore, "adam CLARKE" is returned as the output. */
import java.util.*;
class NameEntry{
  public static void main(String[]args){
    Scanner sc=new Scanner(System.in);
    String f=sc.nextLine();
    String l=sc.nextLine();
    String nf="";
    String nl="";
    for (int i=0;i<f.length();i++){
      char ch=f.charAt(i);
      if (ch>='A' && ch<='Z')
        ch=(char)(ch+32);
      nf+=ch;
    }
    for (int i=0;i<l.length();i++){
      char ch=l.charAt(i);
      if (ch>='a' && ch<='z')
        ch=(char)(ch-32);
      nl+=ch;
    }
    System.out.println(nf+" "+nl);
  }
}