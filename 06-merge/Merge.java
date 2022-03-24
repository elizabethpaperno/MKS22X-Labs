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
        //System.out.println("Left: "+ left[leftIn]);
        mergedArr[leftIn + rightIn] = left[leftIn];
        //System.out.println("Left Index: " + leftIn);
        leftIn++;
        if(leftIn == left.length){
          for (int i = rightIn; i < right.length; i++){
            mergedArr[leftIn + rightIn] = right[i];
            rightIn++;
          }
        }
      }else{
        //System.out.println("Right: " + right[rightIn]);
        mergedArr[leftIn + rightIn] = right[rightIn];
        //System.out.println("Right Index: " + rightIn);
        rightIn++;
        if(rightIn == right.length){
          for (int i = leftIn; i < left.length; i++){
            mergedArr[leftIn + rightIn] = left[i];
            leftIn++;
          }
        }
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
    int[] temp = data;
    if (data.length > 1){
      int[] left = new int[data.length/2];
      int[] right = new int[data.length - left.length];
      for (int i = 0; i < data.length; i++){
        if (i < left.length){
          left[i] = data[i];
        } else{
          right[i - left.length] = data[i];
        }
      }
      //System.out.println("Left: "+Arrays.toString(left));
      //System.out.println("Right: "+Arrays.toString(right));
      temp = merge(mergesortH(left),mergesortH(right));
    }
    //System.out.println("mergesortH->"+Arrays.toString(temp));
    return temp;
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
    int [] data = {1,6,7,8};
    int [] data1 = {3,4,5,10,11};

    System.out.println("Left Array: "+Arrays.toString(data));
    System.out.println("Right Array: "+Arrays.toString(data1));
    System.out.println("Merge: "+Arrays.toString(merge(data,data1)));




    System.out.println("Original: "+Arrays.toString(data));
    mergesort(data);
    System.out.println("Sorted: "+Arrays.toString(data));


    //System.out.println("Original: "+Arrays.toString(data1));
    //mergesort(data1);
    //System.out.println("Sorted: "+Arrays.toString(data1));

  }
}
