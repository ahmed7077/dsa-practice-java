/*Calculating the Total of Unique Products Sold
You are working as an inventory manager for an e-commerce company. The company tracks the products sold across different regions. However, some products might be sold in multiple regions, and they want to calculate the total sales of products that have only been sold in one region. This means you need to find the sum of product IDs that appear only once in the list.

You are given an array of product IDs, where each product ID represents a product sold. Your task is to write a program that calculates the sum of unique product IDs, i.e., those that appear exactly once in the array. If no product ID is unique (i.e., all appear more than once), return 0.



Function Signature

int SumUniqueElements(int[] arr, int length);



Assumptions

The length of the array is always greater than 0.
The product IDs in the array are positive integers.
You need to sum only those product IDs which appear exactly once.


Input Format

The first input is the size of the array, length.
The second input is the array arr which contains the product IDs.


Constraints

1 ≤ length ≤ 10000
The product IDs in the array are positive integers within the integer range.


Output Format

You need to output the sum of all unique product IDs.


Example 1

Sample Input 1

8

2 5 4 7 9 2 4 8



Sample Output 1

29



Explanation

The product IDs 2 and 4 appear more than once, so they are not included in the sum.
The unique product IDs are 5, 7, 9, and 8. Their sum is 29.


Example 2

Sample Input 2

6

10 12 22 10 12 98



Sample Output 2

120



Explanation

The product IDs 10 and 12 appear more than once, so they are not included in the sum.
The unique product IDs are 22 and 98. Their sum is 120. */
import java.util.*;
class TotalUniqueProductsSold{
  public static void main(String[]args){
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int[] arr=new int[n];
    HashMap<Integer, Integer> map=new HashMap<>();
    for (int i=0;i<n;i++){
      arr[i]=sc.nextInt();
      map.put(arr[i],map.getOrDefault(arr[i],0)+1);
    }
    int sum=0;
    for (int id : map.keySet())
      if (map.get(id)==1)
        sum+=id;
    System.out.println(sum);
  }
}