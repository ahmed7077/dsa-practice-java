/*Finding the Mighty Element in the Forest

In the enchanting forest of Eldoria, the wise old owl named Orin has the unique ability to communicate with the animals. One day, Orin decided to organize a competition among the animals to find the mightiest creature based on their sizes. To do this, he devised a plan to represent the sizes of the animals in an array and asked the clever rabbit, Ruby, to help him find the largest size using a special method: recursion.

Write a program that takes an array of positive integers representing the sizes of different animals and finds the maximum size using recursion.



Input Format

The first line contains an integer n (the number of animals).
The second line contains n positive integers representing the sizes of the animals.


Constraints

1≤n≤1000
Sizes are positive integers.


Output Format

Output the maximum size value from the array


Example 1

Sample Input 1

5

23 12 45 67 34



Sample Output 1

67



Explanation

In the array [23, 12, 45, 67, 34], the maximum size is 67, which represents the largest animal.



Example 2

Sample Input 2

4

2 8 1 5



Sample Output 2

8



Explanation

In the array [2, 8, 1, 5], the maximum size is 8, which represents the largest animal. */
import java.util.Scanner;

public class FindingMightyElementInTheForest {
    public static int findMax(int[] arr, int n) {
        if (n == 1) {
            return arr[0];
        }
        return Math.max(arr[n - 1], findMax(arr, n - 1));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(findMax(arr, n));
    }
}