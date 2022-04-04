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

    //create list of vals
    while(str.hasNext()){
      list.add(str.next());
    }
    //System.out.println(list);

    //throw exception for case of empty string
    if (list.size() == 0){
      throw new IllegalArgumentException("too few operands");
    }

    //if one value just return it
    if (list.size() == 1){
      return Double.parseDouble(list.get(0));
    }

    for(int i = 0; i < list.size(); i++){
      String val = list.get(i);
      switch(val){
        case "*":
          if (stack.size() < 2){
            throw new IllegalArgumentException("too few operands for operation *");
          }
          stack.addLast(stack.removeLast() * stack.removeLast());
          break;
        case "+":
          if (stack.size() < 2){
            throw new IllegalArgumentException("too few operands for operation +");
          }
          stack.addLast(stack.removeLast() + stack.removeLast());
          break;
        case "/":
          if (stack.size() < 2){
            throw new IllegalArgumentException("too few operands for operation /");
          }
          double removeLast1 = stack.removeLast();
          double removeLast2 = stack.removeLast();
          stack.addLast(removeLast2 / removeLast1);
          break;
        case "-":
          if (stack.size() < 2){
            throw new IllegalArgumentException("too few operands for operation -");
          }
          double removeLast3 = stack.removeLast();
          double removeLast4 = stack.removeLast();
          stack.addLast(removeLast4 - removeLast3);
          break;
        case "%":
          if (stack.size() < 2){
            throw new IllegalArgumentException("too few operands for operation %");
          }
          double removeLast5 = stack.removeLast();
          double removeLast6 = stack.removeLast();
          stack.addLast(removeLast6 % removeLast5);
          break;
        default:
          stack.addLast(Double.parseDouble(list.get(i)));
        }
        //System.out.println(stack);
      }

      if (stack.size() > 1){
        throw new IllegalArgumentException("too many operands");
      }
      return stack.getFirst();
    }

  public static void main(String[] args){
    System.out.println(eval("11 3 - 4 + 2.5 *"));
    System.out.println(eval("10 2.0 +"));
    System.out.println(eval("8 2 + 99 9 - * 2 + 9 -")); //NOT CORRECT
    System.out.println(eval("1 2 3 4 5 + * - -")); //NOT CORRect
    //System.out.println(eval("4 2 3 5 1 - + * + *"));
    //System.out.println(eval("5 3 7 9 + +"));
    //System.out.println(eval("25"));
    System.out.println(eval(""));
    //System.out.println(eval("1 1 1 +"));
    //System.out.println(eval("1 1 1 - * +"));
  }

}
