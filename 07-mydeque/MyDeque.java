import java.util.*;
public class MyDeque<E>{
  private E[] data;
  private int size;
  private int start, end;

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
    String str = "[";
    int dequeIndex = start;
    for(int i=0; i < size();i++){
      if (dequeIndex == data.length){
        dequeIndex = 0;
      }
      str += data[dequeIndex];
      if (dequeIndex != end){
        str += ", ";
      }
      dequeIndex += 1;
    }
    return str + "]";
  }

  public String toStringDebug(){
    return Arrays.toString(data);
  }
  public void addFirst(E element){
    if(element == null){
      throw new NullPointerException("NullPointerException: cannot add null element to deque");
    }
    resize();
    if (size() == 0){
      start = data.length/2;
      end = start;
      data[start] = element;
    }else {
      if (start == 0){
        start = data.length - 1;
      }else{
        start -= 1;
      }
      data[start] = element;
    }
    size += 1;
  }
  public void addLast(E element){
    if(element == null){
      throw new NullPointerException("NullPointerException: cannot add null element to deque");
    }
    resize();
    if (size() == 0){
      start = data.length/2;
      end = start;
      data[end] = element;
    }else {
      if (end == data.length - 1){
        end = 0;
      }else{
        end += 1;
      }
      data[end] = element;
    }
    size += 1;
  }
  public E removeFirst(){
    if(size() == 0){
      throw new NoSuchElementException("NoSuchElementException: the Deque is empty");
    }
    E first = data[start];
    data[start] = null;
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

  //CHANGE THIS TO MAKE START AT INDEX 0 and end at inde end
  private void resize(){
    if (this.size() == data.length){
      @SuppressWarnings("unchecked")
      E[] d = (E[])new Object[data.length * 2 + 1];
      int dequeIndex = start;
      for (int i = 0; i < this.size(); i++){
        if (dequeIndex == data.length){
          dequeIndex = 0;
        }
        d[i] = data[dequeIndex];
        dequeIndex += 1;
      }
      this.data = d;
      start = 0;
      end = size - 1;
    }
  }
}
