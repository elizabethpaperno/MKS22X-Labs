import java.util.*;
import java.io.*;
public class Silver{
  private static int N, M, T;
  private static int[][] grid;
  public static void parseFile(String filename) throws FileNotFoundException{
    File input = new File(filename);
    Scanner s = new Scanner(input);

    N =s.nextInt();
    M = s.nextInt();
    T = s.nextInt();

    grid = new int[N][M];
    for(int i = 0; i < grid.length; i++){
      char[] row = s.nextLine().toCharArray();
      int[] rowNum = new int[row.length];
      for(int j = 0; j < row.length; j++){
        if(row[j] == '.'){
          rowNum[i] = 0;
        }else{
          rowNum[i] = -1;
        }
      }
      grid[i]=rowNum;
    }
    int R1 =s.nextInt();
    int C1 = s.nextInt();
    int R2 = s.nextInt();
    int C2 = s.nextInt();

    solve(T, R1, C1, R2, C2);
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

  public static long solve(int T, int R1, int C1, int R2, int C2){
    grid[R1][C1] = 1;
    return 1;
  }
}
