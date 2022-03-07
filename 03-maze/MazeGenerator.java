import java.util.*;
public class MazeGenerator{
  public char[][] createWallMaze(int numRows, int numCols){
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
    if (maze[startrow + 1][startcol] == ' ' && startrow + 1!= 0 && startrow + 1 != maze.length - 1 && startcol != 0 && startcol == maze[startrow].length - 1) {
      numSafeCarve++;
    }
    if (maze[startrow - 1][startcol] == ' ' && startrow - 1!= 0 && startrow - 1 != maze.length - 1 && startcol != 0 && startcol == maze[startrow].length - 1) {
      numSafeCarve++;
    }
    if (maze[startrow][startcol + 1] == ' ' && startrow != 0 && startrow != maze.length - 1 && startcol + 1!= 0 && startcol + 1 == maze[startrow].length - 1) {
      numSafeCarve++;
    }
    if (maze[startrow][startcol - 1] == ' ' && startrow != 0 && startrow != maze.length - 1 && startcol - 1!= 0 && startcol - 1 == maze[startrow].length - 1) {
      numSafeCarve++;
    }

    ArrayList<Integer> randDirection = new ArrayList<Integer>(4);
    randDirection.add(0);
    randDirection.add(1);
    randDirection.add(2);
    randDirection.add(3);

    if (numSafeCarve < 2){
      if (startrow != 0 && startrow != maze.length - 1 && startcol != 0 && startcol == maze[startrow].length - 1){
        maze[startrow][startcol]= ' ';
      }
      int direction = (int)Math.random() * 4;
      randDirection.remove(direction);
      if (direction == 0){
        generate(maze, startrow + 1, startcol);
      }else if(direction == 1){
        generate(maze, startrow - 1, startcol);
      }else if(direction == 2){
        generate(maze, startrow, startcol-1);
      }else if(direction == 3){
        generate(maze, startrow + 1, startcol);
      }
    }
  }
}
