ArrayList<Orb>orbList;
Orb attractor;
void setup() {
  size(1000, 700);
  

  orbList = new ArrayList<Orb>();
}
void mouseClicked() {
  //add a new Orb to the orbList, constructed as follows:
  //The x and y positions are the same as the mouse
  //the radius should be between in the range [20.0,70.0)
  //the xSpeed and ySpeed should be in the range [-3.0,3.0)
   Orb o = new Orb(mouseX, mouseY, random(-3,3), random(-3,3), random(19, 70));
   orbList.add(o);
}
void draw() {
  background(255);
  /*bounce
  for (Orb o : orbList) {
    o.move();
    o.display();
  }
  */
  attractor = new Orb(width/2,height/2,0,0, 100);
  attractor.display();
  for (Orb o : orbList) {
    o.attract(attractor);
    o.display();
  }
  fill(0);
  text(frameRate, 20, 20);
  text(orbList.size(), 20, 40);
}
