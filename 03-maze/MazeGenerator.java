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

  }
}
