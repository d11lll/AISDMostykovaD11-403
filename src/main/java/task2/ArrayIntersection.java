package task2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArrayIntersection {
    public static void main(String[] args) {
        int[] nums1 = {2, 4, 4, 1};
        int[] nums2 = {2, 2, 4, 5};
        int[] result = intersect(nums1, nums2);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> countMap1 = countElements(nums1);
        Map<Integer, Integer> countMap2 = countElements(nums2);

        List<Integer> resultList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : countMap1.entrySet()) {
            int num = entry.getKey();
            if (countMap2.containsKey(num)) {
                int minCount = Math.min(entry.getValue(), countMap2.get(num));
                for (int i = 0; i < minCount; i++) {
                    resultList.add(num);
                }
            }
        }

        int[] result = new int[resultList.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }

    private static Map<Integer, Integer> countElements(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        return countMap;
    }
}