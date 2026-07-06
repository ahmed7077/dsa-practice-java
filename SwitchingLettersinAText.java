/*Switching Letters in a Text

You are given a string representing a name of a product, and you need to perform a modification based on customer feedback. Some customers have complained that two characters in the product name are often confusing and they want the characters swapped. You are tasked with writing a function that swaps two characters in the product name wherever they occur.

Function Description:

String replaceCharacter(String str, int n, char ch1, char ch2)

The function accepts three arguments:
str[]: A string str of length n containing only lowercase alphabets.
n: The length of the string str[].
ch1: The character to be replaced by ch2.
ch2: The character to be replaced by ch1.
The function modifies the string in place by swapping every occurrence of ch1 with ch2 and vice versa.


Note

If the string is empty, return null (None, in case of Python).
If both characters ch1 and ch2 do not exist in the string or are the same, return the original string unchanged.


Input Format

A string str[] of lowercase alphabetical letters.
Two characters ch1 and ch2.


Output Format

The modified string with ch1 and ch2 swapped wherever they occur.


Example 1

Sample Input 1

apples

a

p



Sample Output 1

paales



Explanation  

In the string "apples", every occurrence of 'a' is replaced with 'p', and every occurrence of 'p' is replaced with 'a', resulting in "paales".



Example 2

Sample Input 2

bluecoloure

l

o



Sample Output 2

boueClolure



Explanation  

In the string "bluecoloure", the character 'l' is replaced with 'o', and the character 'o' is replaced with 'l', resulting in "boueClolure". */
import java.util.Scanner;

public class SwitchingLettersinAText {

    public static String replaceCharacter(String str, int n, char ch1, char ch2) {
        if (str == null || n == 0) {
            return null;
        }

        if (ch1 == ch2) {
            return str;
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            if (currentChar == ch1) {
                result.append(ch2);
            } else if (currentChar == ch2) {
                result.append(ch1);
            } else {
                result.append(currentChar);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String input1 = scanner.next();
        String input2 = scanner.next();
        char ch1 = input1.charAt(0);
        char ch2 = input2.charAt(0);
    }
}