/*Coding Marathon
N number of people participated in a coding marathon where they were asked to solve some problems. Each problem carried 1 mark and at the end of the marathon, the total marks that each person achieved was calculated.

As an organizer, you have the list of the total marks that each person achieved. You have to calculate the sum of the marks of top K scorers from the list.



Input Format

Input 1:An integer N representing the number of participants.

Input 2:An integer K representing the number of top scorers to consider.

Input 3:A space-separated list of N integers representing the marks of each participant.



Output Format

A single integer representing the sum of the marks of the top K scorers.



Example 1

Sample Input 1

Input1: 4

Input2: 2

Input3: 4 1 2 5



Sample Output 1

9



Explanation

Top 2 scores are 5 and 4. Sum = 5+4 = 9.



Example 2

Sample Input 2

Input1: 4

Input2: 3

Input3: 4 3 6 1



Sample Output 2

13



Explanation

Top 3 scores are 6, 4 and 3. Sum = 6+4+3 = 13. */
import java.util.Scanner;
public class CodingMarathon 
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int l[]=new int[n];
        int sum=0;
        for(int i= 0;i<n;i++)        
            l[i]=sc.nextInt();
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                if(l[i]<l[j])
                {
                    int temp=l[i];
                    l[i]=l[j];
                    l[j]=temp;
                }
            }
        }

    for(int i=0;i<k;i++)
        sum+=l[i];
    System.out.print(sum);
    }
    
}
