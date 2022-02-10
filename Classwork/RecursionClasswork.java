public class RecursionClasswork{
  /*
    Given an array of ints, is it possible to choose a group of some of the ints,
    such that the group sums to the given target?
    This is a classic backtracking recursion problem.
    Once you understand the recursive backtracking strategy in this problem,
    you can use the same pattern for many problems to search a space of choices.
    Rather than looking at the whole array, our convention is to consider the part of the array
    starting at index start and continuing to the end of the array.
    The caller can specify the whole array simply by passing start as 0.
    No loops are needed -- the recursive calls progress down the array.
  */
  public static boolean groupSum(int start, int[] nums, int target) {
    if (target == 0) {
      return true;
    }
    if (start >= nums.length){
      return false;
    }
    return (groupSum(start + 1, nums, target - nums[start]) || groupSum(start + 1, nums, target));
  }

  /*
    Given an array of ints, is it possible to divide the ints into two groups,
    so that the sums of the two groups are the same.
    Every int must be in one group or the other.
    Write a recursive helper method that takes whatever arguments you like,
    and make the initial call to your recursive helper from splitArray().
    (No loops needed.)
  */

  public static boolean splitArray(int[] nums) {
    return splitArray(nums, 0, 0, 0);
  }

  public static boolean splitArray(int[] nums, int index, int sum1, int sum2){
    if (index < nums.length){
      return splitArray(nums, index + 1, sum1 + nums[index], sum2) || splitArray(nums, index + 1, sum1, sum2 + nums[index]);
    }
    return (sum1 == sum2);
  }

  /*
  Given an array of ints, is it possible to choose a group of some of the ints,
  beginning at the start index, such that the group sums to the given target?
  However, with the additional constraint that all 6's must be chosen. (No loops needed.)
  */

  public static boolean groupSum6(int start, int[] nums, int target) {
    if (start >= nums.length){
      return (target == 0);
    }
    if (nums[start] == 6){
      return groupSum6(start + 1, nums, target - nums[start]);
    }
    return (groupSum6(start + 1, nums, target - nums[start]) || groupSum6(start + 1, nums, target));
  }

  public static boolean groupNoAdj(int start, int[] nums, int target) {
    if (target == 0) {
      return true;
    }
    if (start >= nums.length){
      return false;
    }
    return (groupNoAdj(start + 2, nums, target - nums[start]) || groupNoAdj(start + 1, nums, target));
  }

  public static boolean groupSum5(int start, int[] nums, int target) {
    if (start >= nums.length){
      return (target == 0);
    }else if (nums[start] % 5 == 0 && (start == nums.length - 1 || nums[start + 1] != 1)){
      return groupSum5(start + 1, nums, target - nums[start]);
    }else if (nums[start] % 5 == 0 && nums[start + 1] == 1){
      return (groupSum5(start + 1, nums, target - nums[start]) && groupSum5(start + 2, nums, target - nums[start]));
    }
    return (groupSum5(start + 1, nums, target - nums[start]) || groupSum5(start + 1, nums, target));
  }

  public static boolean splitOdd10(int[] nums, int index, int sum1, int sum2) {
    if (index < nums.length){
      return splitOdd10(nums, index + 1, sum1 + nums[index], sum2) || splitOdd10(nums, index + 1, sum1, sum2 + nums[index]);
    }
    return ((sum1 % 10 == 0 || sum2 % 10 == 0) && (sum1 % 2 != 0 || sum2 % 2 != 0));
  }

  public static boolean splitOdd10(int[] nums) {
    return splitOdd10(nums,0,0,0);
  }


}
