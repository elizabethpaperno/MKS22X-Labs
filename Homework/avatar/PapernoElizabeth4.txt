/** Avatar: a function that draws a face/character/animal/object,

 *at a particular x,y location.


 */
void avatar(int x, int y){
  //your code here
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


//The code should draw 3 avatars, one of them moves.
int xp,yp;
void setup(){
  size(800,600);
  xp = 0;
  yp = 0;
}
void draw(){
  background(255);
  avatar(xp,yp);
  xp++;
  yp++;
  avatar(100,100);
  avatar(600,300);
}
