/*Ayushi and the Magical Chocolate Piles
Ayushi is a chocolate lover and visits a special chocolate shop where chocolates are stacked in different piles. The shop has a unique rule: each time Ayushi picks chocolates, she must choose the pile with the maximum number of chocolates. After choosing, she eats the chocolates such that only the square root of the chocolates in that pile remains.

Given an array representing the number of chocolates in each pile and a number k representing the number of times Ayushi can pick chocolates, determine the total number of chocolates remaining after k iterations.



Input Format

The first line contains an integer N (number of piles).
The second line contains N space-separated integers representing the number of chocolates in each pile.
The third line contains an integer k (number of times Ayushi can pick chocolates).


Output Format

A single integer representing the total number of chocolates remaining after k iterations.


Sample Input

5

25 64 9 4 100

4



Sample Output

29



Explanation

Ayushi visits the chocolate shop and sees five different piles of chocolates with the following amounts:

Piles: [25, 64, 9, 4, 100]

Ayushi can pick chocolates 4 times.

Pick pile with 100 chocolates → Remaining chocolates in that pile: square root of 100=10
Updated piles: [25, 64, 9, 4, 10]
Pick pile with 64 chocolates → Remaining chocolates in that pile: square root of 64=8
Updated piles: [25, 8, 9, 4, 10]
Pick pile with 25 chocolates → Remaining chocolates in that pile: square root of 25=5
Updated piles: [5, 8, 9, 4, 10]
Pick pile with 10 chocolates → Remaining chocolates in that pile: square root of 10≈3
Updated piles: [5, 8, 9, 4, 3]
After 4 iterations, the total number of chocolates remaining is:

5+8+9+4+3=29 */
import java.util.*;
class AyushiandTheMagicalChocolatePiles {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);;
        int n = sc.nextInt();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++)
            maxHeap.add(sc.nextInt());
        int k = sc.nextInt();
        for (int i = 0; i < k; i++) {    
            int maxVal = maxHeap.poll();
            maxHeap.add((int)Math.sqrt(maxVal));
        }
        int sum = 0;
        while (!maxHeap.isEmpty()) 
            sum += maxHeap.poll();
        System.out.println(sum);
    }
}