import java.util.*;
import java.io.*;
public class Silver{
  private static int N, M, T;
  private static int R1, C1, R2, C2;
  private static long[][] grid;
  public static void parseFile(String filename) throws FileNotFoundException{
    File input = new File(filename);
    Scanner s = new Scanner(input);

    N =s.nextInt();
    M = s.nextInt();
    T = s.nextInt();
    //System.out.println(T);

    grid = new long[N][M];
    s.nextLine();
    for(int i = 0; i < N; i++){
      //System.out.println(i);
      char[] row = s.nextLine().toCharArray();

      long[] rowNum = new long[row.length];
      //System.out.println(Arrays.toString(row));
      for(int j = 0; j < row.length; j++){
        if(row[j] == '.'){
          rowNum[j] = 0;
        }else{
          rowNum[j] = -1;
        }
      }
      grid[i]=rowNum;
    }

    R1 =s.nextInt() - 1;
    C1 = s.nextInt()- 1;
    R2 = s.nextInt()- 1;
    C2 = s.nextInt()- 1;

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
    //System.out.println(prnt(grid));
    long[][] array2 = new long[N][M];
    for (int t = 1; t <= T; t++){
      //System.out.println("T: " + t);

      array2 = new long[N][M];
      for (int i = 0; i < N; i++){
        for(int j = 0; j < M; j++){
          long up = 0;
          long down = 0;
          long right = 0;
          long left = 0;
          if(grid[i][j] == -1){
            array2[i][j] = -1;
          }else if (grid[i][j] == 0){
            if(i > 0){
              if (grid[i-1][j] != -1){
                up = grid[i-1][j];
              }
            }
            if (i < N - 1){
              if (grid[i+1][j] != -1){
                down = grid[i+1][j];
              }
            }
            if(j < M - 1){
              if (grid[i][j+1] != -1){
                right = grid[i][j+1];
              }
            }
            if (j > 0){
              if (grid[i][j-1] != -1){
                left = grid[i][j-1];
              }
            }
            array2[i][j] = right + left + up + down;
          }
        }
      }
      //System.out.println(prnt(grid));
      grid = array2.clone();
      //System.out.println(prnt(array2));
    }
    return array2[R2][C2];
  }
  public static long solve(String filename){
    try{
      parseFile(filename);
      return solve(T, R1, C1, R2, C2);
    }catch(FileNotFoundException e){
      System.out.println("Invalid filename");
      return -1;
    }
  }

  public static void main(String[] args){
    Silver S = new Silver();
    System.out.println(Silver.solve("ctravel.2.in"));
    System.out.println(S);
  }
}
