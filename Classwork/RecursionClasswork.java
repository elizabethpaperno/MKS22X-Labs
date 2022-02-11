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

  /*
    Given an array of ints, is it possible to choose a group of some of the ints,
    such that the group sums to the given target,
    with this additional constraint: if there are numbers in the array that are adjacent and
    the identical value, they must either all be chosen, or none of them chosen.
    For example, with the array {1, 2, 2, 2, 5, 2}, either all three 2's in the middle must be chosen or not, all as a group.
    (one loop can be used to find the extent of the identical values).
  */

  public static boolean groupSumClump(int start, int[] nums, int target) {
    if (start==nums.length) return target==0;
    int currentVal = nums[start];
    for(int i=start;i<nums.length-2 && currentVal==nums[i+1];i++){
      nums[start]+=nums[i+1];
      nums[i+1]=0;
    }
    return (groupSumClump(start+1, nums, target-nums[start])) || (groupSumClump(start+1, nums, target));
  }

  public static boolean splitArray(int[] nums, int index, int sum1, int sum2){
    if (index < nums.length){
      return splitArray(nums, index + 1, sum1 + nums[index], sum2) || splitArray(nums, index + 1, sum1, sum2 + nums[index]);
    }
    return (sum1 == sum2);
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

  public static boolean split53(int[] nums, int index, int sum1, int sum2) {
    if (index < nums.length){
      if (nums[index] % 5 == 0){
        return split53(nums, index + 1, sum1 + nums[index], sum2);
      } else if (nums[index] % 3 == 0){
        return split53(nums, index + 1, sum1, sum2 + nums[index]);
      }else {
      return split53(nums, index + 1, sum1 + nums[index], sum2) || split53(nums, index + 1, sum1, sum2 + nums[index]);
      }
    }
    return (sum1 == sum2);
  }
  public static boolean split53(int[] nums) {
    return split53(nums, 0, 0, 0);
  }


}
