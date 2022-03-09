import java.util.*;
import java.io.*;
public class Bronze {
  private static int R,C,E,N;
  private static int[][] grid;
  public static void parseFile(String filename) throws FileNotFoundException{
    File input = new File(filename);
    Scanner s = new Scanner(input);
    String info = s.nextLine();
    R = Character.getNumericValue(info.charAt(0));
    C = Character.getNumericValue(info.charAt(2));
    E = Character.getNumericValue(info.charAt(4));
    N = Character.getNumericValue(info.charAt(6));
    grid = new int[R][C];
    for(int row = 0; row < grid.length; row++){
      for(int col = 0; col < grid[row].length; col++){
        grid[row][col] = s.nextInt();
      }
    }
    System.out.println(grid);
  }

  public String toString(){
    String str = "";
    for (int i = 0; i < grid.length; i++){
      for (int j = 0; j < grid[i].length; j++){
        str += grid[i][j] + " ";
      }
      str += "\n";
    }
    return str;
  }

  public static void main(String[] args){
    try {
      Bronze b = new Bronze();
      Bronze.parseFile("makelake");
      System.out.println(b);
    } catch (FileNotFoundException e){
      System.out.println("Invalid filename");
    }
  }
}
