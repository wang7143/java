import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

// @lc code=start
class Solution {
    public static int[] twoSum(int[] nums, int target) {
        int[] arr = new int[2];
        int l = nums.length - 1;
        int x = 0;
        while (x < l){
            int s = l;
            for (int i = x; s > i;) {
                if (nums[i] + nums[s] == target) {
                    arr[0] = i;
                    arr[1] = s;
                    return arr;
                } else {
                    s--;
                }
            }
            x++;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 7, 11,15 };
        System.out.printf("%s", Arrays.toString(twoSum(nums, 9)));
    }
}
// @lc code=end

