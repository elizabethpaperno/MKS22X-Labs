import java.util.*;
public class MyDeque<E>{
  private E[] data;
  private int size;
  private int start, end;

  //SHOULD BE SPECIAL CASE FOR EMPTY WHERE START ABD EBD ARE EQUAl
  public MyDeque(){
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[10];
    data = d;
    size = 0;
    //start = 10/2 - 1;
    //end = start + 1;
  }
  public MyDeque(int initialCapacity){
    @SuppressWarnings("unchecked")
    E[] d = (E[])new Object[initialCapacity];
    data = d;
    size = 0;
    //start = initialCapacity/2 - 1;
    //end = start + 1;
  }
  public int size(){
    return size;
  }
  public String toString(){
    //fill in later
    /*
    String str = "[";
    for(int i = start; i < this.size(); i++){
      str += data[i] + ", ";
    }

    return str;
    */
    return "";
  }
  public String toStringDebug(){
    return Arrays.toString(data);
  }
  public void addFirst(E element){
    if (size == 0){
      start = data.length/2 + 1;
      end = start;
      data[start] = element;
    }else {
      resize();
      //ADD CONDITION TO WRAP AROUND
      start -= 1;
      data[start] = element;
    }
  }
  public void addLast(E element){
    //ADD CONDITION TO WRAP AROUND
    if (size == 0){
      start = data.length/2 + 1;
      end = start;
      data[end] = element;
    }else {
      resize();
      end += 1;
      data[end] = element;
    }
  }
  public E removeFirst(){
    if(size() == 0){
      throw new NoSuchElementException("NoSuchElementException: the Deque is empty");
    }
    E first = data[start];
    data[start] = null;
    //ADD CONDITION TO WRAP AROUND
    start += 1;
    size -= 1;
    return first;
  }
  public E removeLast(){
    if(size() == 0){
      throw new NoSuchElementException("NoSuchElementException: the Deque is empty");
    }
    E last = data[end];
    data[end] = null;
    //ADD CONDITION TO WRAP AROUND
    end -= 1;
    size -= 1;
    return last;
  }
  public E getFirst(){
    if(size() == 0){
      throw new NoSuchElementException("NoSuchElementException: the Deque is empty");
    }
    return data[start];
  }
  public E getLast(){
    if(size() == 0){
      throw new NoSuchElementException("NoSuchElementException: the Deque is empty");
    }
    return data[end];
  }
  private void resize(){
    boolean foundEnd = false;
    if (this.size() == data.length){
      @SuppressWarnings("unchecked")
      E[] d = (E[])new Object[data.length * 2 + 1];
      for (int i = 0; i < this.size(); i++){
        d[i] = data[i];
        if (!foundEnd){
          if(d[i] == null){
            foundEnd = true;
            end = i;
          }
        }
      }
      this.data = d;
    }
  }
}
