import java.util.*;
import java.io.*;
public class Driver{
  public static void main(String[] args){
    try {
      Maze Maze1 = new Maze("Maze1.txt");
      System.out.println(Maze1);
    }catch(FileNotFoundException e){
      System.out.println("bad file name");
    }
  }
}
