/*Efficient Budget Allocation for Project Expenses
Imagine you are working in a project management company responsible for handling budgets for various projects. Each project involves allocating funds to either odd-numbered or even-numbered categories. For instance, categories numbered with an even digit might represent equipment expenses, while odd-digit categories represent employee wages. The goal is to maximize the efficiency of your budget by allocating it to the category (either odd or even) that has a greater total sum.

Your task is to implement a function that calculates the sum of all odd-digit expenses and the sum of all even-digit expenses from a given project budget number. The program should then output the higher sum to aid in efficient budget allocation.



Function Description

int OddEvenSum(int num)

The function OddEvenSum accepts a non-negative integer num representing the project budget. The function should find the sum of all odd digits and the sum of all even digits in num and return the greater sum. If both sums are equal, return either one.



Input Format

A single integer num representing the project budget.


Output Format

An integer representing the greater sum between the sum of odd digits and the sum of even digits.


Example 1

Sample Input 1

98631



Sample Output 1

14



Explanation

Sum of odd digits: 9 + 3 + 1 = 13
Sum of even digits: 8 + 6 = 14
Since the sum of even digits is greater, the output is 14.


Example 2

Sample Input 2

274695



Sample Output 2

21



Explanation

Sum of odd digits: 7 + 9 + 5 = 21
Sum of even digits: 2 + 4 + 6 = 12
Since the sum of odd digits is greater, the output is 21. */
import java.util.*;
class EfficientBudgetAllocation{
  public static void main(String[]args){
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int odd=0;
    int even=0;
    while (n>0){
      int d=n%10;
      if (d%2==0)
        even+=d;
      else
        odd+=d;
      n/=10;
    }
    System.out.println((odd>even)? odd : even);
  }
}