/*Most Popular Products in an Online Store
An online store keeps track of the number of times each product is purchased. The store manager wants to know the top K most frequently purchased products so that they can promote them on the homepage.

If two products have the same purchase count, the more expensive product (larger number) is given priority.

Your task is to write a program that analyzes sales data and finds the top K most frequently purchased products.



Input Format

The first line contains an integer N (number of products in the sales data).
The second line contains N space-separated integers representing the product IDs.
The third line contains an integer K (number of most frequently purchased products to find).


Output Format

A single line containing K space-separated integers representing the top K most purchased product IDs.


Sample Input 1

8

3 1 4 4 5 2 6 1

2



Sample Output 1

4 1



Explanation

The sales data contains the following product IDs:

[3, 1, 4, 4, 5, 2, 6, 1]

The store wants to know the top K = 2 most frequently sold products.

The correct answer is:

[4, 1]

Product 4 has been purchased 2 times.
Product 1 has been purchased 2 times.
Since both have the same frequency, we prioritize the larger product ID (4 > 1).


Sample Input 2

11

7 10 11 5 2 5 5 7 11 8 9

4



Sample Output 2

5 11 7 10



Explanation

Product 5 appears 3 times.
Product 11 appears 2 times.
Product 7 appears 2 times.
Product 10 appears 1 time.
Since frequency is the priority, but ties are broken by product value, the final order is: 5, 11, 7, 10. */
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MostPopularProductsInOnlineStore {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        int[] products = new int[n];

        for (int i = 0; i < n; i++) {
            products[i] = scanner.nextInt();
        }

        int k = scanner.nextInt();

        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int product : products) {
            frequencyMap.put(product, frequencyMap.getOrDefault(product, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(
            (a, b) -> {
                int freqCompare = b.getValue() - a.getValue();
                if (freqCompare != 0) {
                    return freqCompare;
                }
                return b.getKey() - a.getKey();
            }
        );

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            maxHeap.add(entry);
        }

        for (int i = 0; i < k; i++) {
            if (!maxHeap.isEmpty()) {
                System.out.print(maxHeap.poll().getKey() + (i == k - 1 ? "" : " "));
            }
        }
    }
}