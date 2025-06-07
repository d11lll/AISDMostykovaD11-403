package task7;

import java.util.*;

public class Zad2 {
    public static String determineWinner(int n, Map<Integer, List<Integer>> moves) {
        boolean[] dp = new boolean[n + 1];
        dp[0] = false;

        for (int i = 1; i <= n; i++) {
            dp[i] = false;
            for (int move : moves.getOrDefault(i, new ArrayList<>())) {
                if (i - move >= 0 && !dp[i - move]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n] ? "First" : "Second";
    }

    public static void main(String[] args) {
        int n = 3;
        Map<Integer, List<Integer>> moves = new HashMap<>();
        moves.put(1, List.of(1));
        moves.put(2, List.of(1, 2));
        moves.put(3, List.of(1, 3));

        String winner = determineWinner(n, moves);
        System.out.println(winner);
    }
}
