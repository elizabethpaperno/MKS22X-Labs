import java.util.Random;
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
  public static int partition ( int [] data, int start, int end){
    Random rng = new Random();
    int pivotIn = rng.nextInt(end-start+1)+start;
    int pivot = data[pivotIn];
    System.out.println(pivot);
    int ogVal = data[start];
    data[start] = pivot;
    data[pivotIn] = ogVal;
    int first = start + 1;
    int last = end;
    while(first <= last){
        if(data[first] < pivot){
          ogVal = data[first];
          data[first] = data[pivotIn];
          data[pivotIn] = ogVal;
          first++;
        }else{
          ogVal = data[first];
          data[first] = data[last];
          data[last] = ogVal;
          last--;
        }
      }
      return first;
    }
}
