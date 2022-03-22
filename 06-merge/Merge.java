public class Merge {
  /*merge takes two sorted arrays and returns a new array that combines all
   *elements of both arrays in asorted order.
   *@left a sorted array (this is a precondition)
   *@right a sorted array (this is a precondition)
   *@return a sorted array that contains all elements of left and right
   */
  public static int [] merge(int [] left, int[] right){
    //return a new array that is the merged version of left and right
    int[] mergedArr = new int[left.length + right.length];
    int leftIn = 0;
    int rightIn = 0;
    for(int i = 0; i < mergedArr.length; i++){
      if(left[leftIn] >= right[rightIn]){
        mergedArr[i] = left[leftIn];
        leftIn++;
      }else{
        mergedArr[i] = right[rightIn];
        rightIn++;
      }
    }
    return mergedArr;
  }

  public static int[] mergesortH(int[] data){
    //if more than 1 element{
    //left = copy half of data
    //right = copy other half of data
    //sort each half and merge them together
    //}
    if (data.length > 0){
      int[] left = new int[data.length/2];
      int[] right = new int[data.length - left.length];
      for (int i = 0; i < left.length; i++){
        left[i] = data[i];
      }
      int dataIn = (data.length - left.length) - 1;
      for (int i = 0; i < left.length; i++){
        left[i] = data[dataIn];
        dataIn += 1;
      }
      return merge(mergesortH(left),mergesortH(right));
    }
    return new int[1]; //so this compiles
  }

  /*mergesort uses the recursive mergesortH method to create a sorted
  *version of the array. It then copies the data back into the original
  *array. (This is for compatibility with prior sort testers)
  *@param data the array to be sorted, this will be modified by the method
  */
  public static void mergesort(int [] data){
    int [] temp  =  mergesortH(data);
    for(int i = 0; i < data.length; i++){
      data[i] = temp[i];
    }
  }
}
