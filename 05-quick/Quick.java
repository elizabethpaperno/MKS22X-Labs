import java.util.*;
public class Quick {
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

/* ADD When data element are equal to the pivot,
place half of the equal values on the left side of
the pivot and half on the right.
You can alternate left and right as you find equal values
by maintaining a variable to keep track of this.*/
  public static int partition ( int [] data, int start, int end){
    Random rng = new Random();
    int pivotIn = rng.nextInt(end-start+1)+start;
    int pivot = data[pivotIn];
    //System.out.println(Arrays.toString(data));
    //System.out.println(pivot);
    swap(data, start, pivotIn);
    //System.out.println(Arrays.toString(data));
    pivotIn = start;
    int low = pivotIn + 1;
    int high = end;

    for(int i = start; i < end ; i++){
        if(data[low] < pivot){
          swap(data, pivotIn, low);
          pivotIn += 1;
          low += 1;
          //System.out.println(Arrays.toString(data));
        }else{
          swap(data, low, high);
          high--;
          //System.out.println(Arrays.toString(data));
        }
      }
      return pivotIn;
    }

        /*return the value that is the kth smallest value of the array.
    *@param data must have a length > 0
    *@param k is 0 to data.length-1 inclusive
    *@postcondition The array may be modified. */
    public static int quickselect(int []data, int k){
        return quickselect(data, k, 0, data.length - 1);
    }

    public static int quickselect(int []data, int k, int start, int end){
      int partition = partition(data, start, end);
      if (k - 1 == partition){
  			return data[partition];
      }else if (k - 1 > partition){
  			return quickselect(data, k, partition + 1, end);
      }else{
        return quickselect(data, k, start, partition - 1);
      }
    }
    public static void quicksort(int[]data){
      quicksort(data, 0, data.length - 1);
    }

    public static void quicksort(int []data, int start, int end){
      if (start < end){
        int piv = partition(data, start, end);
        quicksort(data, piv + 1, end);
        quicksort(data, start, piv - 1);
      }
    }
    public static void main(String[] args){
      int [] data = new int[] {4,3,2,1,0};

      System.out.println("Original: "+Arrays.toString(data));
      System.out.println(quickselect(data, 5));
      int pivot = partition( data , 0, 4);
      System.out.println("Pivot value: "+data[pivot]+ ", Pivot index: "+pivot);
      System.out.println("Modified: "+Arrays.toString(data));
      System.out.println();
      int [] data1 = new int[] {4,3,2,1,0,997,998,999};
      System.out.println("Original: "+Arrays.toString(data1));
      int pivot1 = partition( data1 , 0, 4);
      System.out.println("Pivot value: "+data1[pivot1]+ ", Pivot index: "+pivot1);
      System.out.println("Modified: "+Arrays.toString(data1));
      System.out.println();
      int [] data2 = new int[] {997,998,999,4,3,2,1,0};
      System.out.println("Original: "+Arrays.toString(data2));
      int pivot2 = partition( data2 , 3, 7);
      System.out.println("Pivot value: "+data2[pivot2]+ ", Pivot index: "+pivot2);
      System.out.println("Modified: "+Arrays.toString(data2));
      System.out.println();
      int [] data3 = new int[] {993,994,995,4,3,2,1,0,997,998,999};
      System.out.println("Original: "+Arrays.toString(data3));
      int pivot3 = partition( data3 , 0, 4);
      System.out.println("Pivot value: "+data3[pivot3]+ ", Pivot index: "+pivot3);
      System.out.println("Modified: "+Arrays.toString(data3));
      System.out.println();
    }

}
