import java.util.*;
public class MazeGenerator{
  public static char[][] createWallMaze(int numRows, int numCols){
    char[][] maze = new char[numRows][numCols];
    for (int i = 0; i < maze.length; i++){
      for (int j = 0; j < maze[i].length; j++){
        maze[i][j]= '#';
      }
    }
    return maze;
  }
  public static void generate(char[][]maze, int startrow, int startcol) {
    int numSafeCarve = 0;
    maze[startrow][startcol] = 'S';
    if (maze[startrow][startcol] != ' ' && startrow < maze.length - 1 && startrow > 0 && startcol < maze[0].length - 1 && startcol > 0){
      if (maze[startrow + 1][startcol] == ' ') {
        numSafeCarve++;
      }
      if (maze[startrow - 1][startcol] == ' ') {
        numSafeCarve++;
      }
      if (maze[startrow][startcol + 1] == ' ') {
        numSafeCarve++;
      }
      if (maze[startrow][startcol - 1] == ' ') {
        numSafeCarve++;
      }


    if (numSafeCarve < 2){
      maze[startrow][startcol]= ' ';
      System.out.println(startrow + " " + startcol);
      ArrayList<Integer> randDirection = new ArrayList<Integer>(4);
      randDirection.add(0);
      randDirection.add(1);
      randDirection.add(2);
      randDirection.add(3);
      while(randDirection.size() != 0){
        int direction = (int)(Math.random() * randDirection.size());

        if (randDirection.get(direction) == 0 ){
          generate(maze, startrow + 1, startcol);
        }else if(randDirection.get(direction) == 1 ){
          generate(maze, startrow - 1, startcol);
        }else if(randDirection.get(direction) == 2 ){
          generate(maze, startrow, startcol-1);
        }else if(randDirection.get(direction) == 3 ){
          generate(maze, startrow, startcol + 1);
        }
        randDirection.remove(direction);
      }
    }
  }
    return;
  }

  public static String toString(char[][] maze){
    String str = "";
    for (int i = 0; i < maze.length; i++){
      for (int j = 0; j < maze[i].length; j++){
        str += maze[i][j];
      }
      str += "\n";
    }
    return str;
  }

  public static void main(String[] args){
    char[][]maze = createWallMaze(5,5);
    generate(maze, 1, 1);
    System.out.println(toString(maze));
  }
}
