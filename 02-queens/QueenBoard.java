public class QueenBoard{
  private int[][]board;
  private boolean animated = false;
  private int delay = 1000;

  public QueenBoard(int size){
    board = new int[size][size];
  }
  /**
  *@return The output string formatted as follows:
  *All numbers that represent queens are replaced with 'Q'
  *all others are displayed as underscores '_'
  *There are spaces between each symbol:
  *_ _ Q _
  *Q _ _ _
  *_ _ _ Q
  *_ Q _ _
  *excludes the characters up to the comment(*)
  */
  public String toString(){
    String str = "";
    for (int i = 0; i < board.length; i++){
      for (int j = 0; j < board[i].length; j++){
        if(board[i][j]== -1){
          str += "Q ";
        }else {
          str += "_ ";
        }
      }
      str += "\n";
    }
    return str;
    //for testing
    /*
    String str = "";
    for (int i = 0; i < board.length; i++){
      for (int j = 0; j < board.length; j++){
        if(board[i][j]== -1){
          str += "Q";
        }else {
          str += board[i][j] + " ";
        }
      }
      str += "\n";
    }
    return str;
    */
  }

  /**
  *@return true when the queen added correctly, false Otherwise
  *@precondition r and c are valid indices of the board array
  *@postcondition the board is only changed when the function returns true
  * in which case the queen is added and all it's threatened positions are incremented
  */
  private boolean addQueen(int r, int c){
    if (board[r][c] == 0){
      //-1 indicates a queen is at that position
      board[r][c] = -1;

      //down direction
      for (int i = r + 1; i < board[r].length; i++){
        board[i][c] += 1;
      }
      //diagonal right down
      for (int j = 1; j < board.length - r && j < board[r].length - c; j++){
        board[r + j][c + j] += 1;
      }
      //diagonal left down
      for (int k = 1; r + k < board.length && c - k >= 0; k++){
        board[r + k][c - k] += 1;
      }
      return true;
    }
    return false;
  }

  /**Remove the queen that was added to r,c
  *@precondition r and c are valid indices of the board array and there is a queen at position r,c
  *@postcondition the board is modified to remove that queen and all it's
  *threatened positions are decremented
  */
  private void removeQueen(int r, int c){
    board[r][c] += 1;
      //down direction
    for (int i = r + 1; i < board[r].length; i++){
      board[i][c] -= 1;
    }

    for (int j = 1; j < board.length - r && j < board[r].length - c; j++){
      board[r + j][c + j] -= 1;
    }

    for (int k = 1; r + k < board.length && c - k >= 0; k++){
      board[r + k][c - k] -= 1;
    }
  }

  /**Find the first solution configuration possible for this size board. Start by placing
  *  the 1st queen in the top left corner, and each new queen in the next ROW. When backtracking
  *  move the previous queen to the next valid space. This means everyone will generate the same
  *  first solution.
  *@postcondition: the board remains in a solved state.
  *@return false when the board is not solveable and leaves the board filled with zeros;
  *        returns true when the board is solveable, and leaves the board in a solved state
  *@throws IllegalStateException when the board starts with any non-zero value (e.g. you solved a 2nd time.)
  */
  public boolean solve(){
    for (int i = 0; i < board.length; i++){
      for (int j = 0; j < board[i].length; j++){
        if (board[i][j] != 0){
           throw new IllegalStateException ("IllegalStateException: board must be empty to solve.");
        }
      }
    }
    return solve(0);
  }

  //wrapper method
  public boolean solve(int row){
    if (row >= board.length){
      return true;
    }else{
      for (int col = 0; col < board[row].length; col++){
        if(addQueen(row,col)){
          if(animated){
            System.out.println(Text.go(1,1));
            System.out.println(this);//can modify here
            Text.wait(delay);
          }
          if(solve(row+1)){
            return true;
          }
          removeQueen(row,col);
          if(animated){
            System.out.println(Text.go(1,1));
            System.out.println(this);//can modify here
            Text.wait(delay);
          }
        }
      }
      return false;
    }
  }

  /**Find all possible solutions to this size board.
  *@return the number of solutions found, and leaves the board filled with only 0's
  *@throws IllegalStateException when the board starts with any non-zero value (e.g. you ran solve() before this method)
  */
  public int countSolutions(){
    return 0;
  }

  public void setAnimate(boolean newValue){
    this.animated = newValue;
  }
  public void setDelay(int newValue){
    this.delay = newValue;
  }
}
