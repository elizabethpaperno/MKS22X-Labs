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

    grid = new long[N][M];
    for(int i = 0; i < N; i++){
      //System.out.println(i);
      char[] row = s.nextLine().toCharArray();

      long[] rowNum = new long[row.length];
      for(int j = 0; j < M; j++){
        if(row[j] == '.'){
          rowNum[j] = 0;
        }else{
          rowNum[j] = -1;
        }
      }
      grid[i]=rowNum;
    }

    R1 =s.nextInt();
    C1 = s.nextInt();
    R2 = s.nextInt();
    C2 = s.nextInt();

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
    long[][] array2 = new long[N][M];
    long up;
    long down;
    long right;
    long left;
    for (int t = 1; t < T; t++){
      array2 = new long[N][M];
      for (int i = 0; i < N; i++){
        for(int j = 0; j < M; j++){
          if(j == 0){
            left = 0;
          }else{
            left = grid[i-1][j];
          }
          if (j == M - 1){
            right = 0;
          }else{
            right = grid[i+1][j];
          }
          if(i == 0){
            up = 0;
          }else{
            up = grid[i][j+1];
          }
          if (i == N - 1){
            down = 0;
          }else{
            down = grid[i][j-1];
          }
          array2[i][j] = right + left + up + down;
        }
      }
      grid = array2.clone();
    }
    return array2[R2][C2];
  }
  public static long solve(String filename){
    try{
      parseFile(filename);
      //return solve(T, R1, C1, R2, C2);
      return 1;
    }catch(FileNotFoundException e){
      System.out.println("Invalid filename");
      return -1;
    }
  }

  public static void main(String[] args){
    Silver S = new Silver();
    System.out.println(Silver.solve("ctravel.1.in"));
    System.out.println(S);
  }
}
