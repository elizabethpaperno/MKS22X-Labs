static int SPRING = 2;
static float SPRING_LENGTH = 50;
static float SPRING_DAMPEN = 0.990;
static float SPRING_CONSTANT = 0.015;
static int MODE = SPRING;
static double GRAVITY = 0.35;
OrbList orbs;
void setup() {
  size(1000, 800);
  orbs = new OrbList();
}
void mouseClicked() {
  orbs.add(new OrbNode(mouseX,mouseY,0,0,30));
}

void keyPressed(){
  if (key == 1){
    SPRING_CONSTANT += .1 * SPRING_CONSTANT;
  } else if (key == 2){
    SPRING_CONSTANT -= .1 * SPRING_CONSTANT;
  } else if (key == 3){
    SPRING_DAMPEN += .1 * SPRING_DAMPEN;
  } else if (key == 4){
    SPRING_DAMPEN -= .1 * SPRING_DAMPEN;
  } else if (key == 5){
    SPRING_LENGTH += .1 * SPRING_LENGTH;
  } else if (key == 6){
     SPRING_LENGTH -= .1 * SPRING_LENGTH;
  } else if (key == 7){
    GRAVITY += .1 * GRAVITY;
  } else if (key == 8){
    GRAVITY -= .1 * GRAVITY;
  } 
}
void draw() {
  background(255);
  orbs.processAll();
  orbs.display();
  text("SPRING_CONSTANT: " + SPRING_CONSTANT, 20, 10);
  text("SPRING_DAMPEN: " + SPRING_DAMPEN, 160, 10); 
  text("SPRING_LENGTH: " + SPRING_LENGTH, 300, 10); 
  text("GRAVITY: " + GRAVITY, 440, 10);
}
   
