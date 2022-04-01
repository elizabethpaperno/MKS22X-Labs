import java.util.*;
import java.io.*;
public class Calculator{
  /*Evaluate a postfix expression stored in s.
  *Assume valid postfix notation, of ints doubles and operators separated by spaces.
  *Valid operators are + - / * and % (remainder not modulo)
  *All results are doubles even if the operands are both int.
  *@throws IllegalArgumentException when there are too many or too few operands.
  *        Use the string parameter of your exception to indicate what happened.
  *        Either "too many operands" or "too few operands for operation _" replace _ with +,- etc.
  */
  public static double eval(String s){
    ArrayDeque<Double> stack = new ArrayDeque<Double>();
    ArrayList<String> list = new ArrayList<String>();
    Scanner str = new Scanner(s);

    while(str.hasNext()){
      list.add(str.next());
    }

    System.out.println(list);
    for(int i = 0; i < list.size(); i++){
      if (list.get(i).equals("*")){
        //multiplication
        stack.addLast(stack.pop() * stack.pop());
      }else if (list.get(i).equals("+")){
        //addition
        stack.addLast(stack.pop() + stack.pop());
      }else if (list.get(i).equals("/")){
        //subtraction
        double pop1 = stack.pop();
        double pop2 = stack.pop();
        stack.addLast(pop1 / pop2);
      }else if (list.get(i).equals("-")){
        //subtraction
        double pop1 = stack.pop();
        double pop2 = stack.pop();
        stack.addLast(pop1 - pop2);
      }else if (list.get(i).equals("%")){
        double pop1 = stack.pop();
        double pop2 = stack.pop();
        stack.addLast(pop1 % pop2);
      }else{
        stack.addLast(Double.parseDouble(list.get(i)));
      }
      System.out.println(stack);
    }
    return stack.getFirst();
  }
  public static void main(String[] args){
    System.out.println(eval("11 3 - 4 + 2.5 *"));
    System.out.println(eval("10 2.0 +"));
  }
}
