public class Orb {
  float x, y;
  float xSpeed, ySpeed;
  float radius;
  color c;

  public Orb(float x_, float y_, float xSpeed_, float ySpeed_, float radius_ ) {
    x = x_;
    y = y_;
    xSpeed = xSpeed_;
    ySpeed = ySpeed_;
    radius = radius_;
    //random color... why not.
    c = color(random(255), random(255), random(255));
  }


  void display() {
    //Part 1:
    //draw a ellipse at the x,y position, with the correct radius.
    //make sure it is the correct color
    //make sure you read the parameters of ellipse, so that you have the correct size.
    //radius is NOT one of the parameters of ellipse by default.
    fill(c);
    
    ellipse(x, y, radius, radius);
    line(x, y, x + 5 * xSpeed, y + 5 * ySpeed); 
  }

  void move() {
    //PART 2
    //change the x based on the xSpeed
    //change the y based on the ySpeed
      if (x + radius/2 >= width || x - radius/2 <= 0){
        xSpeed = -1 * xSpeed;
      }
      x += xSpeed;
      //PART 3
      //Change the speed when you collide with the end of the screen (all 4 sides)
      if (y + radius/2 >= height || y - radius/2<= 0){
        ySpeed = -1 * ySpeed;
      }
      y += ySpeed;
    //Part 4
    //Add a small adjustment for gravity. Gravity is a ySpeed acceleration...
    //You don't need a variable for this if every object experiences the same
    //gravitational constant.
    if (g){
      ySpeed = 0.15 + ySpeed;
    }
  }
  
  void attract(Orb other){
    float dist = dist(x,y, other.x, other.y);
    other.xSpeed += 20 * (other.x - x)/(dist * dist); 
    other.x += xSpeed;
    other.ySpeed += 20 * (other.y - y)/(dist * dist);
    other.y += ySpeed;
    if (g){
      ySpeed = 0.15 + ySpeed;
    }
  }
  
  void attractSpring(Orb other){
    float dist = dist(x,y, other.x, other.y);
    force = (dist - SPRING-LENGTH) * SPRING-CONSTANT; 
    other.xSpeed = force * ((x.other - x)/dist);
    other.xSpeed *= SPRING_DAMPEN;
    other.ySpeed = force * ((y.other - y)/dist);
    other.ySpeed *= SPRING_DAMPEN;
    if (g){
      ySpeed = 0.15 + ySpeed;
    }
  }
