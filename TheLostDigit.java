/*The lost Digit
You are working on a number sequence puzzle. You have an array A, that is supposed to contain all the numbers from 1 to N, but you realize one number is missing. The array might have been shuffled, so the numbers are not in order. Your task is to find and return an integer value representing the missing number from the sequence.



Input Format

Input1: An integer value N representing the length of the sequence

Input2: An integer array A



Output Format

Return an integer value representing the missing number from the sequence.



Example 1

Sample Input 1

Input1: 5

Input2: 3 1 2 5



Sample Output 1

4



Explanation

Here, A = {3, 1, 2, 5} and N = 5. The sequence should contain the numbers from 1 to 5 but the number 4 is missing from the array A. Hence, 4 is returned as the output.



Example 2 

Sample Input 2

Input1: 4

Input2: 2 3 4



Sample Output 2

1



Explanation

Here, A = {2, 3, 4} and N = 4. The sequence should contain the numbers from 1 to 4 but the number 1 is missing from array A. Hence, 1 is returned as the output. */
import java.util.*;
class TheLostDigit{
  public static void main(String[]args){
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int[] l=new int[n-1];
    for (int i=0;i<n-1;i++)
      l[i]=sc.nextInt();
    for (int i=0;i<n-1;i++){
      for (int j=i+1;j<n-1;j++){
        if (l[i]>l[j]){
          int temp=l[i];
          l[i]=l[j];
          l[j]=temp;
        }
      }
    }
    for (int i=0;i<n-1;i++)
      if (l[i]!=i+1){
        System.out.print(i+1+" ");
        break;
      }
  }
}