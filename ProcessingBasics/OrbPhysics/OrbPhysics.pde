ArrayList<Orb>orbList;
Orb attractor;
String MODE; 
void setup() {
  size(1000, 800);
  orbList = new ArrayList<Orb>();
  
}
void mouseClicked() {
  //add a new Orb to the orbList, constructed as follows:
  //The x and y positions are the same as the mouse
  //the radius should be between in the range [20.0,70.0)
  //the xSpeed and ySpeed should be in the range [-3.0,3.0)
   Orb o = new Orb(mouseX, mouseY, 5, 0, 20);
   orbList.add(o);
}
void keyPressed() {
  if (keyCode == BACKSPACE) {
    orbList = new ArrayList<Orb>();;
  } else if (key == ' '){
    if (MODE == "GRAVITY"){
      MODE = "ORBIT";
    }else{
      MODE = "GRAVITY";
    }
  }
}
void draw() {
  background(255);
  fill(0,0,255);
  attractor = new Orb(width/2,height/2,0,0, 10);
  attractor.display();
  /*bounce
  for (Orb o : orbList) {
    o.move();
    o.display();
  }
  */
  
  for (Orb o : orbList) {
    o.attract(attractor);
    o.display();
  }
  fill(0);
  text(frameRate, 20, 20);
  text(orbList.size(), 20, 40);
}
