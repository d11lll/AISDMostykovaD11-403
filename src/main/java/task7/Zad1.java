package task7;

import java.util.Arrays;

public class Zad1 {
    public static int[] findClosestTriplet(int[] arr, int t) {
        if (arr.length < 3) {
            return new int[0];
        }

        double targetA = t / 3.0;
        int a = findClosest(arr, targetA, -1, -1);

        double targetB = (t - a) / 2.0;
        int b = findClosest(arr, targetB, a, -1);

        double targetC = t - a - b;
        int c = findClosest(arr, targetC, a, b);

        return new int[]{a, b, c};
    }

    private static int findClosest(int[] arr, double target, int exclude1, int exclude2) {
        int closest = 0;
        double minDiff = Double.MAX_VALUE;

        for (int num : arr) {
            if (num == exclude1 || num == exclude2) {
                continue;
            }
            double diff = Math.abs(num - target);
            if (diff < minDiff) {
                minDiff = diff;
                closest = num;
            }
        }

        return closest;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int t = 10;
        int[] result = findClosestTriplet(arr, t);
        System.out.println(Arrays.toString(result));
    }
}
