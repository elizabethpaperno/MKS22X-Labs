import java.util.*;
import java.io.*;
public class Maze{
  private char[][]maze;
  private boolean animate;//false by default
  private int startRow,startCol;

  /*Constructor loads a maze text file, and sets animate to false by default.
  When the file is not found then:
  throw a FileNotFoundException

  You may assume the file contains a rectangular ascii maze, made with the following 4 characters:
  '#' - Walls - locations that cannot be moved onto
  ' ' - Empty Space - locations that can be moved onto
  'E' - the location of the goal if any (0 or more per file)
  'S' - the location of the start(exactly 1 per file)

  You may also assume the maze has a border of '#' around the edges.
  So you don't have to check for out of bounds!
  Some text editors always include a newline at the end of a file, but that is not always present.
  Make sure your file reading is able to handle this.
  */
  public Maze(String filename) throws FileNotFoundException{
    //COMPLETE CONSTRUCTOR
    File mz = new File(filename);
    Scanner s = new Scanner(mz);
    ArrayList<String> lines = new ArrayList<String>();
    while (s.hasNextLine()){
      String line = s.nextLine();
      if (line != ""){
        lines.add(line);
      }
    }
    //System.out.println(lines);
    int height = lines.size();
    int width = lines.get(0).length();
    maze = new char[height][width];
    for (int i = 0; i < lines.size(); i++){
      char[] row = lines.get(i).toCharArray();
      //System.out.println(Arrays.toString(row));
      maze[i] = row;
    }
    boolean cont = true;
    for (int i = maze.length - 1; i >= 0 && cont; i--){
      for (int j = maze[i].length - 1; j >= 0 && cont; j--){
        if (maze[i][j] == 'S'){
          startRow = i;
          startCol = j;
          cont = false;
        }
      }
    }

  }

  private void wait(int millis){
    try {
      Thread.sleep(millis);
    }
    catch (InterruptedException e) {
    }
  }

  public void setAnimate(boolean b){
    animate = b;
  }

  public static void clearTerminal(){
    //erase terminal
    System.out.println("\033[2J");
  }
  public static void gotoTop(){
    //go to top left of screen
    System.out.println("\033[1;1H");
  }

  /*Return the string that represents the maze.
  It should look like the text file with some characters replaced.
  */
  public String toString(){
    String str = "";
    for (int i = 0; i < maze.length; i++){
      for (int j = 0; j < maze[i].length; j++){
        str += maze[i][j];
      }
      str += "\n";
    }
    return str;
  }

  /*Wrapper Solve Function returns the helper function
  Note the helper function has the same name, but different parameters.
  Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.
  */
  public int solve(){
    //only clear the terminal if you are running animation
    if(animate){
      clearTerminal();
    }
    //System.out.println(startRow);
    //System.out.println(startCol);
    //start solving at the location of the s.
    return solve(startRow,startCol);

  }

  /*
  Recursive Solve function:

  A solved maze has a path marked with '@' from S to E.

  Returns the number of @ symbols from S to E when the maze is solved,
  Returns -1 when the maze has no solution.

  Postcondition:
  The 'S' is replaced with '@'
  The 'E' remain the same
  All visited spots that were not part of the solution are changed to '.'
  All visited spots that are part of the solution are changed to '@'
  */
  private int solve(int row, int col){ //you can add more parameters since this is private
    //automatic animation! You are welcome.
    if (maze[row][col] == 'E'){
      return 0;
    }
    else if(maze[row][col] == '@' || maze[row][col] == '#' || maze[row][col] == '.'){
      return -1;
    }
    //when solved return 1 + solve()
    maze[row][col] = '@';

    if(animate){
      gotoTop();
      System.out.println(this);
      wait(50);
    }
    int dir1 = solve(row + 1, col);
    if(dir1 > -1){
      return dir1 + 1;
    }
    int dir2 = solve(row - 1, col);
    if(dir2 > -1){
      return dir2 + 1;
    }
    int dir3 = solve(row, col + 1);
    if(dir3 > -1){
      return dir3 + 1;
    }
    int dir4 = solve(row, col - 1);
    if(dir4 > -1){
      return dir4 + 1;
    }
    maze[row][col] = '.';
    if(animate){
      gotoTop();
      System.out.println(this);
      wait(50);
    }
    return -1;
  }

}
