import java.util.*;
public class Merge {
  /*merge takes two sorted arrays and returns a new array that combines all
   *elements of both arrays in asorted order.
   *@left a sorted array (this is a precondition)
   *@right a sorted array (this is a precondition)
   *@return a sorted array that contains all elements of left and right
   */
  public static int [] merge(int[] left, int[] right){
    //return a new array that is the merged version of left and right
    int[] mergedArr = new int[left.length + right.length];
    int leftIn = 0;
    int rightIn = 0;
    while(!(leftIn == left.length && rightIn == right.length)){
      if(left[leftIn] <= right[rightIn]){
        System.out.println("Left: "+ left[leftIn]);
        mergedArr[leftIn + rightIn] = left[leftIn];
        System.out.println("Left Index: " + leftIn);
        leftIn++;
        if(leftIn == left.length){
          for (int i = rightIn; i < right.length; i++){
            mergedArr[leftIn + rightIn] = right[i];
            rightIn++;
          }
        }
      }else{
        System.out.println("Right: " + right[rightIn]);
        mergedArr[leftIn + rightIn] = right[rightIn];
        System.out.println("Right Index: " + rightIn);
        rightIn++;
        if(rightIn == right.length){
          for (int i = leftIn; i < left.length; i++){
            mergedArr[leftIn + rightIn] = left[i];
            leftIn++;
          }
        }
      }
    }
    /*
    for(int i=rightIn; i < right.length; i++){
      mergedArr[rightIn] = right[rightIn];
    }
    for(int i=leftIn; i < left.length; i++){
      mergedArr[leftIn] = left[leftIn];
    }

    */
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

  public static void main(String[] args){
    int [] data = {1,3,5,7};
    int [] data1 = {2,4,6,8};
    System.out.println("Left Array: "+Arrays.toString(data));
    System.out.println("Right Array: "+Arrays.toString(data1));
    //System.out.println("Original: "+Arrays.toString(data));
    //mergesort(data);
    //System.out.println("Sorted: "+Arrays.toString(data));
    System.out.println("Merge: "+Arrays.toString(merge(data,data1)));
  }
}
