import java.util.*;
public class BurnTrees{
  private int[][]map;
  private int ticks;
  private static final int TREE = 2;
  private static final int FIRE = 1;
  private static final int ASH = 3;
  private static final int SPACE = 0;
  private Frontier frontier;


  /*Determine if the simulation is still burning
   *@return false if any fires are still burning, true otherwise
   */
  public boolean done(){
    //YOU MUST IMPLEMENT THIS METHOD
    //(BEFORE WRITING ANY CODE READ ALL OF THE CODE AND SEE HOW IT FITS TOGETHER)
    //HINT: do not check the board for fire which is an n^2 operation
    return (frontier.size() == 0);//placeholder for compilation purposes
  }


  /*This is the core of the simulation. All of the logic for advancing to the next round goes here.
   *All existing fires spread new fires, and turn to ash
   *new fires should remain fire, and not spread.
   */
  public void checkSurround (int[] ogCord, int xinc, int yinc){
    //ADD CHECK FOR OUT OF BOUNDS
    if (map[ogCord[0] + xinc][ogCord[1] + yinc] == TREE){
      int[] newCord = {ogCord[0] + xinc, ogCord[1] + yinc};
      map[newCord[0]][newCord[1]] = FIRE;
      frontier.add(newCord);
    }
  }
  public void tick(){
    ticks++;//leave this here.
    int ogSize = frontier.size();
    for (int i = 0; i < ogSize; i++){
      int[] ogCord = frontier.remove();
      map[ogCord[0]][ogCord[1]] = ASH;
      if (ogCord[1] < map[ogCord[0]].length - 1){
        checkSurround(ogCord, 0,1);
      }
      if (ogCord[0] < map.length - 1) {
        checkSurround(ogCord, 1,0);
      }
      if (ogCord[0] > 0) {
        checkSurround(ogCord, -1,0);
      }
      if (ogCord[1] > 0) {
        checkSurround(ogCord, 0,-1);
      }
    }
    //YOU MUST IMPLEMENT THE REST OF THIS METHOD
    //(BEFORE WRITING ANY CODE READ ALL OF THE CODE AND SEE HOW IT FITS TOGETHER)
  }

  /***********************YOU MIGHT UPDATE THIS**************************/

  /*Initialize the simulation.
   *If you add more instance variables you can add more here,
   *otherwise it is complete
   */
  public BurnTrees(int width,int height, double density){
    map = new int[height][width];
    frontier = new Frontier();
    for(int r=0; r<map.length; r++ ){
      for(int c=0; c<map[r].length; c++ ){
        if(Math.random() < density){
           map[r][c]=2;
         }
       }
     }
     start();//set the left column on fire.
  }


  /*
   *Sets the trees in the left column of the forest on fire
   */
  public void start(){
    //If you add more instance variables you can add more here,
    //otherwise it is complete.
    for(int i = 0; i < map.length; i++){
      if(map[i][0]==TREE){
        int[] cord = {i,0};
        frontier.add(cord);
        map[i][0]=FIRE;
      }
    }
  }

  public static double avgNtimes (int numRuns, int width, double den) {
    double sum = 0;
    for (int i = 0; i < numRuns; i++) {
      BurnTrees b = new BurnTrees(width,width,den);
      sum += b.run();
    }
    return sum / numRuns;
  }

    public static void main(String[]args){
      /*
      int WIDTH = 20;
      int HEIGHT = 20;
      int DELAY = 200;
      double DENSITY = .7;
      if(args.length > 1){
        WIDTH = Integer.parseInt(args[0]);
        HEIGHT = Integer.parseInt(args[1]);
        DENSITY = Double.parseDouble(args[2]);
      }
      if(args.length > 3){
        DELAY = Integer.parseInt(args[3]);
      }
      BurnTrees b = new BurnTrees(WIDTH,HEIGHT,DENSITY);


      int ans = b.animate(DELAY);//animate all screens
      System.out.println(ans);//print the final answer

      //int ans = b.outputAll();//print all screens one after another
      //System.out.println(ans);//print the final answer
      */

      System.out.println("Board Size: 300, Reps: 150");
      for (double den = .05; den < 1; den += .05){
        double ans = avgNtimes(150, 300, den);
        System.out.println("|" + den * 100 + "%| "+ ans + "|");
      }
      System.out.println("Board Size: 300, Reps: 250");
      for (double den = .55; den <= .65; den += .01){
        double ans = avgNtimes(250, 300, den);
        System.out.println("|" + (int) (den * 100) + "%| "+ ans + "|");
      }

      /*
      System.out.println("Board Size: 100");
      for (double den = .05; den < 1; den += .05){
        double ans = avgNtimes(100, 100, den);
        System.out.println("|" + den * 100 + "%| "+ ans + "|");
      }
      for (double den = .55; den < .65; den += .01){
        double ans = avgNtimes(100, 100, den);
        System.out.println("|" + (int) (den * 100) + "%| "+ ans + "|");
      }

      System.out.println("Board Size: 450, Inc: 5%, Reps: 150");
      for (double den = .05; den < 1; den += .05){
        double ans = avgNtimes(150, 450, den);
        System.out.println("|" + (int) (den * 100) + "%| "+ ans + "|");
      }
      System.out.println("Board Size: 450, Inc: 1%, Reps: 150");
      for (double den = .55; den < .65; den += .01){
        double ans = avgNtimes(150, 450, den);
        System.out.println("|" + (int) (den * 100) + "%| "+ ans + "|");
      }

      System.out.println("Board Size: 1000, Reps: 100");
      for (double den = .05; den < 1; den += .05){
        double ans = avgNtimes(100, 1000, den);
        System.out.println("|" + (int) (den * 100) + "%| "+ ans + "|");
      }
      for (double den = .55; den < .65; den += .01){
        double ans = avgNtimes(100, 1000, den);
        System.out.println("|" + (int) (den * 100) + "%| "+ ans + "|");
      }
      */
    }




  /***********************DO NOT UPDATE THINGS BELOW HERE**************************/

  /*DO NOT UPDATE THIS
   *PLEASE READ SO YOU SEE HOW THE SIMULATION IS SUPPOSED TO WORK!!!
   */
  public int run(){
    while(!done()){
      tick();
    }
    return getTicks();
  }


  /*DO NOT UPDATE THIS*/
  public int getTicks(){
    return ticks;
  }

  /*DO NOT UPDATE THIS*/
  public String toString(){
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < map.length; i++) {
      for (int c = 0; c < map[i].length; c++) {
        if(map[i][c]==SPACE)
          builder.append(" ");
        else if(map[i][c]==TREE)
          builder.append("@");
        else if(map[i][c]==FIRE)
          builder.append("w");
        else if(map[i][c]==ASH)
          builder.append(".");
      }
      builder.append("\n");
    }
    return builder.toString();
  }

  /*DO NOT UPDATE THIS*/
  public String toStringColor(){
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < map.length; i++) {
      for (int c = 0; c < map[i].length; c++) {
        if(map[i][c]==0)
          builder.append(" ");
        else if(map[i][c]==2)
          builder.append(Text.color(Text.GREEN)+"@");
        else if(map[i][c]==1)
          builder.append(Text.color(Text.RED)+"w");
        else if(map[i][c]==3)
          builder.append(Text.color(Text.DARK)+".");
      }
      builder.append("\n"+Text.RESET);
    }
    return builder.toString()+ticks+"\n";
  }

  /*DO NOT UPDATE THIS*/
  public int animate(int delay) {
    System.out.print(Text.CLEAR_SCREEN);
    System.out.println(Text.go(1,1)+toStringColor());
    Text.wait(delay);
    while(!done()){
      tick();
      System.out.println(Text.go(1,1)+toStringColor());
      Text.wait(delay);
    }
    return getTicks();
  }

  /*DO NOT UPDATE THIS*/
  public int outputAll(){
    System.out.println(toString());
    while(!done()){
      tick();
      System.out.println(toString());
    }
    return getTicks();
  }
}
