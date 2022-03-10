import java.util.*;
import java.io.*;
public class Bronze {
  private static int R,C,E,N;
  private static int[][] grid;
  public static void parseFile(String filename) throws FileNotFoundException{
    File input = new File(filename);
    Scanner s = new Scanner(input);

    R =s.nextInt();
    C = s.nextInt();
    E = s.nextInt();
    N = s.nextInt();
    grid = new int[R][C];
    for(int row = 0; row < grid.length; row++){
      for(int col = 0; col < grid[row].length; col++){
        grid[row][col] = s.nextInt();
      }
    }
    for(int i = 0; i < N; i++){
      stomp(s.nextInt(), s.nextInt(), s.nextInt());
    }
  }
  public static long solve(String filename){
    try {
      parseFile(filename);
    }catch(FileNotFoundException e){
      System.out.println("Invalid filename");
    }
    long total = 0;

    return total;
  }

  public static void stomp(int Rs, int Cs, int Ds){
    int maxVal = 0;
    for (int r  = Rs - 1; r < Rs + 4; r++){
      for (int c = Ds - 1; c<  Rs + 4; c++ ){
        if (grid[r][c] > maxVal){
          maxVal = grid[r][c];
        }
      }
    }
    int finalVal = maxVal - Ds;
    for (int r = Rs; r < Rs + 4; r++){
      for (int c = Ds; c<  Rs + 4; c++ ){
        if (grid[r][c] > finalVal){
          System.out.println(grid[r][c]);
          grid[r][c] = finalVal;
        }
      }
    }
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
