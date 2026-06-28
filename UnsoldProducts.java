/*Unsold Products
In a coding project you are developing a feature for a data visualization tool that process large datasets of products stored in array A. One dataset contains sales figures for various products where a sale value of 0 indicates that the product was not sold during a specific period. Your task is to find and return an integer array representing the dataset representing all the unsold products at the end.



Input Format

Input1:An integer N containing the array size

Input2: An integer array A containing sales number of a particular product.



Output Format

Return an integer array representing the dataset representing all the unsold products at the end.



Sample Input 1

Input1:7

Input2:5 2 0 8 0 2 1



Samplr Output 1

5 2 8 2 1 0 0



Explanation

Here, A = {5, 2, 0, 8, 0, 2, 1}. The dataset contains zeros at position 2 and 4. After shifting all zeros to the end, the non-zero elements {5, 2, 8, 2, 1} retain the original order. And the last two positions will be occupied with zeros. */
import java.util.*;
class UnsoldProducts{
  public static void main(String[]args){
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int[] l=new int[n];
    for (int i=0;i<n;i++)
      l[i]=sc.nextInt();
    for (int i=0;i<n;i++){
      for (int j=i+1;j<n;j++){
        if (l[i]==0){
          int temp=l[j];
          l[j]=l[i];
          l[i]=temp;
        }
      }
    }
    for (int i=0;i<n;i++)
      System.out.print(l[i]+" ");
  }
}