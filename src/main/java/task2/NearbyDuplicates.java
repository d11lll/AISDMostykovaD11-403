package task2;

import java.util.HashMap;
import java.util.Map;

public class NearbyDuplicates {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1, 5};
        int k = 3;
        System.out.println(containsNearbyDuplicate(nums, k));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        Map<Integer, Integer> lastSeen = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (lastSeen.containsKey(num) && (i - lastSeen.get(num)) <= k) {
                return true;
            }
            lastSeen.put(num, i);
        }
        return false;
    }
}
