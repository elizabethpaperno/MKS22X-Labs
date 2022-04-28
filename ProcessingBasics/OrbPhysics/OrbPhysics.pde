final float SPRING_LENGTH = 130; 
final float SPRING_DAMPEN = .995;
final float SPRING_CONSTANT = 0.005;
final int GRAVITY = 0;
final int ORBIT = 1;
final int SPRING = 2;
ArrayList<Orb>orbList;
Orb attractor;
int MODE = 0; 

boolean g = true; 
boolean b = true; 
void setup() {
  size(1000, 800);
  orbList = new ArrayList<Orb>();
  attractor = new Orb(width/2,height/2,0,0, 20);
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
    MODE += 1; 
    if (MODE == 3){
      MODE = 0;
    }
  } else if (key == 'g'){
    g = !g;
  } else if (key == 'b'){
    b = !b;
  }
}
void draw() {
  if (b){
    background(255);
  }
  fill(0,0,255);
  attractor.display();
  if (MODE == GRAVITY){
    for (Orb o : orbList) {
      o.move();
      o.display();
    }
  }
  
  if (MODE == ORBIT){
    for (Orb o : orbList) {
      attractor.attract(o);
      o.display();
    }
  }
  
  if (MODE == SPRING){
    for (Orb o : orbList) {
      attractor.attractSpring(o);
      o.display();
    }
  }
  
  fill(255); 
  stroke(255);
  rect(0,0, 400, 20); 
  fill(0);
  if (MODE == GRAVITY){
    text("MODE: GRAVITY", 20, 10);
  } else if (MODE == SPRING){
    text("MODE: SPRING", 20, 10);
  } else {
    text("MODE: ORBIT", 20, 10);
  } 
  if (g) {
    text("Gravity: On", 160, 10);
  } else {
     text("Gravity: Off", 160, 10);
  }
  if (b) {
     text("Background: Off", 260, 10);
  }else{
    text("Background: On", 260, 10);
  }
  
  //text(frameRate, 20, 20);
  //text(orbList.size(), 20, 40);
}
