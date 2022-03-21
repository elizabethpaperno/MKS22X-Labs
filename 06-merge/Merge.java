public class Merge {
  int [] merge(int [] left, int[] right){
    //return a new array that is the merged version of left and right
  }

  void mergesort(int[] data){
    int [] temp  =  mergeSortH(data);
    //copy temp into data
    for(int i = 0; i < temp.length(); i++){
      temp[i] = data[i];
    }
  }

  int[] mergesortH(data){
    if more than 1 element{
      //left = copy half of data
      //right = copy other half of data
      return merge(mergesortH(left),mergesortH(right))
    }
  }
}
