/**
 * Problem: Two Sum
 * Source: https://leetcode.com/problems/two-sum/description/
 *
 * Description:
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order
 *
 *
 *
 * Example:
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        // Create a HashMap to store value → index
        Map<Integer, Integer> map = new HashMap<>();

        // Loop through each element
        for (int i = 0; i < nums.length; i++) {
            int remainder = target - nums[i];

            // Check if the complement is already in the map
            if (map.containsKey(remainder)) {
                // Return the stored index and current index
                return new int[]{map.get(remainder), i};
            }

            // Store the current number with its index
            map.put(nums[i], i);
        }

        // No solution found (shouldn't happen per problem constraints)
        return new int[0];
    }

    // Test the method
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] result = twoSum(nums, target);

        System.out.println("Indices: [" + result[0] + ", " + result[1] + "]");
    }
}
