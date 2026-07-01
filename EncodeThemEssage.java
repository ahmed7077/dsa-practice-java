/*Encode the message
You are a secret agent on a mission, and need to decode various messages using the ASCII values of characters. Due to resource constraints, you can send only those messages with a total ASCII sum equal to or less than a specified threshold N. You need to remove characters from the end of the string to maintain the sum accordingly. Your task is to find and return the decoded string, or return an empty string, if it is not possible to meet the condition.



Input Format

Input1: A string value S, representing the encoded message

Input2: An integer value N, representing the threshold value



Output Format

Return a string value representing the decoded string, or an empty string if it is not possible to meet the condition.



Example 1

Sample Input 1

Input1: AlohoMora

Input2: 584



Sample Output 1

AlohoM



Explanation

Here, the given string is “AlohoMora”. The ASCII sum of the characters is 65 + 108 + 111 + 104 + 111 + 77 + 111 + 114 + 97 = 898. Now we will remove the characters in the following manner.

We will first remove the character ‘a’ and the sum will become 898 -97 = 801.

Next we will remove the character ‘r’ and the sum will become 801 – 114 = 687.

Then we will remove the character ‘o’ and the sum will become 687 – 111 = 576, which is less than 584.

Therefore, AlohoM is returned as the output.



Example 2

Sample Input 2

Input1: CleVer

Input2: 221



Sample Output 2

Cl



Explanation

Here the given string is “CleVer”, the ASCII sum of all the character is 67 + 108 + 101 + 86 + 101 + 114 = 577. Now we will remove the characters in the following manner.

We will first remove the character ‘r’, and the sum will become 577 – 114 = 463.

Next we will remove the character ‘e’ and the sum will become 463 – 101 = 362.

Next we will remove the character ‘V’ and the sum will become 362 – 86 = 276

Then we will remove the character ‘e’ and the sum will become 276 – 101 = 175, which is less than 221.

Therefore, Cl is returned as the output. */
import java.util.*;
class EncodeTheMessage{
  public static void main(String[]args){
    Scanner sc=new Scanner(System.in);
    String s=sc.nextLine();
    int n=sc.nextInt();
    String result="";
    int sum=0;
    for (int i=0;i<s.length();i++)
      sum+=(int) s.charAt(i);
    int length=s.length();
    while (sum>n && length>0){
      char ch=s.charAt(length-1);
      sum-=(int) ch;
      length--;
    }
    if (length>0)
      System.out.println(s.substring(0,length));
  }
}