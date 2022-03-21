public class Merge {
  public static int [] merge(int [] left, int[] right){
    //return a new array that is the merged version of left and right
  }

  public static void mergesort(int[] data){
    int [] temp  =  mergeSortH(data);
    //copy temp into data
    for(int i = 0; i < temp.length(); i++){
      temp[i] = data[i];
    }
  }

  public static int[] mergesortH(int[] data){
    if (data.length > 0){
      int[] left = new int[data.length/2];
      for (int i = 0; i < left.length; i++){
        left[i] = data[i];
      }
      int[] right = new int[data.length - left.length];
      int dataIn = (data.length - left.length) - 1;
      for (int i = 0; i < left.length; i++){
        left[i] = data[dataIn];
        dataIn += 1;
      }
      //left = copy half of data
      //right = copy other half of data
      return merge(mergesortH(left),mergesortH(right));
    }
  }
}
