import java.util.*;
import java.io.*;
public class Bronze {
  private int R,C,E,N;
  private int[][] grid;
  public static void parseFile(String filename) throws FileNotFoundException{
    File input = new File(filename);
    Scanner s = new Scanner(input);
    String info = s.nextLine();
    R = Character.getNumericValue(info.charAt(0));
    C = Character.getNumericValue(info.charAt(2));
    E = Character.getNumericValue(info.charAt(4));
    N = Character.getNumericValue(info.charAt(6));

  }
}
