/*Reordering Packages in a Delivery Center
A delivery center receives packages from different vendors. The packages are supposed to be sorted based on their order of delivery, but due to logistics delays, each package may be misplaced at most k positions away from its correct order.

The manager of the delivery center wants to completely sort the packages so they can be delivered in the correct order. Your task is to write a program that efficiently sorts these misplaced packages.



Input Format

The first line contains an integer N (number of packages).
The second line contains N space-separated integers representing the misplaced packages.
The third line contains an integer K (maximum distance each package can be misplaced).


Output Format

A single line of N space-separated integers representing the completely sorted package order.


Sample Input 1

7

6 5 3 2 8 10 9

3



Sample Output 1

2 3 5 6 8 9 10



Explanation

The packages arrived in the following order:

[6, 5, 3, 2, 8, 10, 9]

The sorting error is such that each package is misplaced by at most k = 3 positions.

The correctly sorted order should be:

[2, 3, 5, 6, 8, 9, 10]



Sample Input 2

10

1 4 5 2 3 6 7 8 9 10

2



Sample Output 2

1 2 3 4 5 6 7 8 9 10 */
import java.util.PriorityQueue;
import java.util.Scanner;

public class ReorderingPackagesInADeliveryCenter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        int[] packages = new int[n];

        for (int i = 0; i < n; i++) {
            packages[i] = scanner.nextInt();
        }

        int k = scanner.nextInt();

        sortKSortedArray(packages, n, k);

        for (int i = 0; i < n; i++) {
            System.out.print(packages[i] + (i == n - 1 ? "" : " "));
        }
        
        scanner.close();
    }

    public static void sortKSortedArray(int[] arr, int n, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        int index = 0;
        for (int i = 0; i < n; i++) {
            minHeap.add(arr[i]);
            
            if (minHeap.size() > k) {
                arr[index++] = minHeap.poll();
}
        }

        while (!minHeap.isEmpty()) {
            arr[index++] = minHeap.poll();
        }
    }
}