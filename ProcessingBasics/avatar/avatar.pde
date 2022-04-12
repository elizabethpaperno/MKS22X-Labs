  int x,y;
  int MODE;
  void setup(){
           size(800,800);
           MODE = 2;
           x = width/2;
           y = height/2;
           
  }
  void avatar(int x, int y){
    fill(170);
    rect(x - 90, y + 30 , 20, 70); //left leg
    rect(x + 70, y + 30, 20, 70); // right leg
    circle(x, y, 200); //main body
    circle(x - 150 , y - 50 , 105); //left ear
    circle(x - 30 , y - 50 , 105); //right ear
    fill(240, 189, 217);
    circle(x - 150 , y - 50 , 75); // inner left ear
    circle(x - 30 , y - 50 , 75); // inner right ear
    fill(170);
    circle(x - 90 , y - 50 , 105); //head
    rect(x - 100, y - 30 , 15, 100); //elephan nose thing
    fill(255);
    circle(x - 108 , y - 50 , 30);
    circle(x - 78 , y - 50 , 30);
    fill(0);
    circle(x - 108 , y - 50 , 15);
    circle(x - 78 , y - 50 , 15);
    fill(170);
    triangle(x + 100, y, x + 110, y+ 30, x + 110 , y + 40);
  }
  void draw(){
           background(255);
           x = change(x);
           y = change(y);
           avatar(x,y);
           avatar(mouseX, mouseY); 
  }
  void mouseClicked() {
    MODE++; 
    if (MODE == 4) {
      MODE = 1;
    }
  }
  int change(int value){
    /**
     mode 1: return a random location on the screen.
     mode 2: change value by +1, 0, or -1 randomly
     mode 3: change value by +1 , but if it goes past the end of the screen ,
           wrap back around to the other end of the screen.
    */

    switch(MODE){
     case 1:
       return int(random(width + 1));
     case 2:
       return value + int(random(-2,2));
     case 3:
       value += 1; 
       if(value == width){
         value = 0;
       }
       return value;
     default:
       return width/2;
    }
  }
