public class OrbList {
  OrbNode first, last;

  //create a fixed orb
  OrbList() {
    first = new FixedOrbNode(0, height/5);
    last = new FixedOrbNode(width, height/5);
    //link them to eachother
    first.next = last;
    last.prev = first;
  }

  /**
  *complete this method
  */
  void add(OrbNode orb){
    //insert orb at the end of the list before the last node.
    orb.prev = last.prev;
    orb.next = last;
    last.prev.next = orb;
    last.prev = orb;
  }
  
  void add(int xcor,OrbNode toBeAdded){
    OrbNode current = first;
    while(current.x < xcor){
      current = current.next;
    }
    toBeAdded.prev = current.prev;
    toBeAdded.next = current;
    current.prev.next = toBeAdded;
    current.prev = toBeAdded;
  }
  
  OrbNode getNodeAt(int x, int y){
    OrbNode current = first;
    while (dist(current.x, current.y, x, y) != current.radius){
      current = current.next;
    }
    return current;
  }
  
  /**
  *complete this method
  *process all nodes by running move.
  */
  void processAll() {
    OrbNode current = first;
    //advance current to next until it is null, move() each of the nodes
    while(current.next != null){
      current = current.next;
      current.move();
    }
  }
  /**
  *complete this method
  *Display all nodes by running their display().
  */
  void display() {
    OrbNode current = first;
    //advance current to next until it is null, display() each of the nodes
    while(current.next != null){
      current = current.next;
      current.display();
    }
  }
}
