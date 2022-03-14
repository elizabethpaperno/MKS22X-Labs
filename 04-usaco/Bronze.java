import java.util.*;
import java.io.*;
public class Bronze {
  private static int R,C,E,N;
  private static int[][] grid;
  public static void parseFileStomp(String filename) throws FileNotFoundException{
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
      parseFileStomp(filename);
      return getVol();
    }catch(FileNotFoundException e){
      System.out.println("Invalid filename");
      return -1;
    }
  }

  public static void stomp(int Rs, int Cs, int Ds){
    int maxVal = 0;
    for (int r  = Rs - 1; r < Rs + 3 && r < grid.length; r++){
      for (int c = Cs - 1; c<  Cs + 3 && c < grid[r].length; c++ ){
        if (grid[r][c] > maxVal){
          maxVal = grid[r][c];
        }
      }
    }
    int finalVal = maxVal - Ds;
    for (int r = Rs - 1; r < Rs + 3 && r < grid.length; r++){
      for (int c = Cs - 1; c <  Cs + 3 && c < grid[r].length; c++){
        if (grid[r][c] > finalVal){
          grid[r][c] = finalVal;
        }
      }
    }
  }

  public static int getVol() {
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        if (grid[i][j] > E) {
          grid[i][j] = 0;
        } else {
          grid[i][j] = E - grid[i][j];
        }
      }
    }

    int depth= 0;
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[i].length; j++) {
        depth += grid[i][j];
      }
    }
    return (depth * 72 * 72);
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
    Bronze b = new Bronze();
    System.out.println(Bronze.solve("makelake"));
    System.out.println(b);
  }
}
