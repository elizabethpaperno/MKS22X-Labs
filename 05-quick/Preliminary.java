import java.util.*;
public class Preliminary {
    /*Modify the array such that:
  *1. A random index from start to end inclusive is chosen, the
  * corresponding element is designated the pivot element.
  *2. all elements in range that are smaller than the pivot element
  * are placed before the pivot element.
  *3. all elements in range that are larger than the pivot element are
  *placed after the pivot element.
  *4. Only the indices from start to end inclusive are considered in range
  *@return the index of the final position of the pivot element.
  */
  static void swap(int[] arr, int i1, int i2){
    int ogVal = arr[i1];
    arr[i1] = arr[i2];
    arr[i2] = ogVal;
  }

  public static int partition ( int [] data, int start, int end){
    Random rng = new Random();
    int pivotIn = rng.nextInt(end-start+1)+start;
    int pivot = data[pivotIn];
    System.out.println(pivot);
    swap(data, start, pivot);
    pivotIn = 0;
    for(int first = start + 1; first < end; first++){
        if(data[first] < data[end]){
          pivotIn += 1;
          swap(data, pivotIn, first);
        }else{
          swap(data, start, pivotIn);
        }
      }
      return pivotIn;
    }

    public static void main(String[] args){
      int[] t1 = {999,999,999,4,3,2,1,0,999,999,999};
      partition(t1, 0, 10);
      System.out.println(Arrays.toString(t1));
    }

}
