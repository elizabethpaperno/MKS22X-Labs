public class Driver {
  public static void main(String[] args){
    MyDeque<Integer> nums = new MyDeque<Integer>();
    nums.addLast(1);
    System.out.println(nums.toStringDebug());
    nums.addLast(2);
    System.out.println(nums.toStringDebug());
    nums.addLast(3);
    System.out.println(nums.toStringDebug());
    nums.addLast(4);
    System.out.println(nums.toStringDebug());
    nums.addLast(5);
    System.out.println(nums.toStringDebug());
    nums.addLast(6);
    System.out.println(nums.toStringDebug());
    nums.addFirst(7);
    System.out.println(nums.toStringDebug());
    nums.addFirst(8);
    System.out.println(nums.toStringDebug());
    nums.addFirst(10);
    System.out.println(nums.toStringDebug());
    nums.addLast(11);
    System.out.println(nums.toStringDebug());
    nums.addLast(12);
    System.out.println(nums.toStringDebug());
  }
}
