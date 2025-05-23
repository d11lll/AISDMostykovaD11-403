package task4;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //задача 1
        int[] arr1 = {10, 8, 5, 3, 1, 2, 4, 6};
        int j = findInflectionPoint(arr1);
        System.out.println("Задача 1. Индекс перегиба: " + j + " (элемент: " + arr1[j] + ")");

        //задача 2
        String str = "  the   sky  is   blue  ";
        String reversed = reverseWords(str);
        System.out.println("Задача 2. Разворот слов: \"" + reversed + "\"");

        //задача 3
        int[] nums3 = {3, 30, 34, 5, 9};
        String largestNum = largestNumber(nums3);
        System.out.println("Задача 3. Максимальное число: " + largestNum);

        //задача 4
        int[] nums4 = {15, 5, 11, 10, 12};
        int s = 30;
        int maxCount = maxNumbers(nums4, s);
        System.out.println("Задача 4. Максимальное количество чисел (сумма ≤ " + s + "): " + maxCount);
    }

    //задача1
    public static int findInflectionPoint(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > arr[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    //задача2
    public static String reverseWords(String s) {
        char[] chars = s.trim().replaceAll(" +", " ").toCharArray();
        reverse(chars, 0, chars.length - 1);

        int start = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                reverse(chars, start, i - 1);
                start = i + 1;
            }
        }
        reverse(chars, start, chars.length - 1);
        return new String(chars);
    }

    private static void reverse(char[] arr, int left, int right) {
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    //задача3
    public static String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, (a, b) -> (b + a).compareTo(a + b));
        if (strs[0].equals("0")) {
            return "0";
        }
        return String.join("", strs);
    }

    //задача4
    public static int maxNumbers(int[] nums, int s) {
        Arrays.sort(nums);
        int count = 0, total = 0;
        for (int num : nums) {
            if (total + num <= s) {
                total += num;
                count++;
            } else {
                break;
            }
        }
        return count;
    }
}