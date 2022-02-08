public class ChallengeRecursion{
  public boolean partialSum(int start,int[] arr,int targetValue){
    if (targetValue == 0) {
      return true;
    }
    if (start >= arr.length){
      return false;
    }
    return (partialSum(start + 1, arr, targetValue - arr[start]) || partialSum(start + 1, arr, targetValue));
  }
}
