/*Leaderboard Ranking in a Coding Contest
A coding contest platform stores the scores of participants as strings in an array. Each string represents an integer without leading zeros. The contest admin wants to determine the Kth largest score to reward the participant accordingly.

Since scores are stored as strings, they should be compared based on their integer values, not lexicographically. If there are duplicate scores, they are treated distinctly in ranking.

Your task is to help the contest admin find the Kth largest score in the given list.



Input Format

The first line contains an integer N (number of scores).
The second line contains N space-separated strings, where each string represents an integer without leading zeros.
The third line contains an integer K (rank to find).


Output Format

A single string representing the Kth largest integer in the list.


Sample Input

4

3 6 7 10

4



Sample Output

3



Explanation

The contest leaderboard shows the following scores:

Scores: ["3", "6", "7", "10"]

The admin wants to find the 4th largest score.

Sorting the Scores in Non-Decreasing Order

["3", "6", "7", "10"]

The 4th largest score is "3".

Output: "3" */
import java.util.*;
public class LeaderboardRankingInACodingTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] scores = new String[n];
        for (int i = 0; i < n; i++)
            scores[i] = sc.next();
        int k = sc.nextInt();
        Integer[] numericScores = new Integer[n];
        for (int i = 0; i < n; i++)
            numericScores[i] = Integer.parseInt(scores[i]);
        Arrays.sort(numericScores, Collections.reverseOrder());
        System.out.println(String.valueOf(numericScores[k - 1]));
    }
}