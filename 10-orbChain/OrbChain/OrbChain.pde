static int SPRING = 2;
static float SPRING_LENGTH = 50;
static float SPRING_DAMPEN = 0.990;
static float SPRING_CONSTANT = 0.015;
static int MODE = SPRING;
static double GRAVITY = 0.35;
static int add = 0;
static int insert = 1; 
static int delete = 2; 
static int CLICK_MODE = insert;

OrbList orbs;
void setup() {
  size(1000, 800);
  orbs = new OrbList();
}
void mouseClicked() {
  if (CLICK_MODE == add){
    orbs.add(new OrbNode(mouseX,mouseY,0,0,30));
  }else if(CLICK_MODE == insert){
    orbs.add(mouseX,new OrbNode(mouseX,mouseY,0,0,30));
  }
}

void keyPressed(){
  if (key == '1'){
    SPRING_CONSTANT += .1 * SPRING_CONSTANT;
  } else if (key == '2'){
    if (.9 *  SPRING_CONSTANT >= 0){
      SPRING_CONSTANT -= .1 * SPRING_CONSTANT;
    }
  } else if (key == '3'){
    if (1.1 * SPRING_DAMPEN <= 1){
      SPRING_DAMPEN += .1 * SPRING_DAMPEN;
    }
  } else if (key == '4'){
    if (.9 *  SPRING_DAMPEN >= 0){
      SPRING_DAMPEN -= .1 * SPRING_DAMPEN;
    }
  } else if (key == '5'){
    SPRING_LENGTH += .1 * SPRING_LENGTH;
  } else if (key == '6'){
    if (.9 *  SPRING_LENGTH >= 0){
       SPRING_LENGTH -= .1 * SPRING_LENGTH;
    }
  } else if (key == '7'){
    GRAVITY += .1 * GRAVITY;
  } else if (key == '8'){
    if (.9 *  GRAVITY >= 0){
      GRAVITY -= .1 * GRAVITY;
    }
  } 
}
void draw() {
  background(255);
  orbs.processAll();
  orbs.display();
  text("SPRING_CONSTANT: " + SPRING_CONSTANT, 20, 10);
  text("SPRING_DAMPEN: " + SPRING_DAMPEN, 220, 10); 
  text("SPRING_LENGTH: " + SPRING_LENGTH, 420, 10); 
  text("GRAVITY: " + GRAVITY, 620, 10);
}
   
