public class Driver {
  public static void main(String[] args){
    QueenBoard board1 = new QueenBoard(8);
    //board1.addQueen(0,1) ;
    //board1.addQueen(2,5) ;
    //System.out.println(board1);
    //board1.removeQueen(0,1) ;
    //System.out.print(board1);
    System.out.println(Text.CLEAR_SCREEN);
    System.out.println(Text.HIDE_CURSOR);
    System.out.println(Text.go(1,1));
    board1.solve();
    System.out.println(Text.RESET);
  }
}
