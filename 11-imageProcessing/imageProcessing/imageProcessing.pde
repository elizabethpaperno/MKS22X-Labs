public class Kernel {
  float[][]kernel;

  /**Constructor takes the kernel that will be applied to the image
   *This implementation only allows 3x3 kernels
   */
  public Kernel(float[][]init) {
    kernel = init; 
  }

  /**If part of the kernel is off of the image, return black, Otherwise
   *Calculate the convolution of r/g/b separately, and return that color\
   *if the calculation for any of the r,g,b values is outside the range
   *     0-255, then clamp it to that range (< 0 becomes 0, >255 becomes 255)
   */
  color calcNewColor(PImage img, int x, int y) {
    //Hint: start by always returning black.
    //This will let you test your apply method right away!
    float totRed = 0; 
    float totGreen = 0; 
    float totBlue = 0; 
    for(int r = x - 1; r < x + 2; r++){
      for (int c = y -1; c < y + 2; c++){
        totRed += red(img.get(r,c)) * kernel[][]; 
        totGreen += green(img.get(r,c)) * kernel[][]; 
        totBlue += blue(img.get(r,c)) * kernel[][]; 
      }
    }
  }

  /**You must write this method that applies the kernel to the source,
   *and saves the data to the destination.*/
  void apply(PImage source, PImage destination) {
  }
}

void setup() {
  size(1450, 500);
  PImage car = loadImage("redcar.png");
  PImage output = car.copy();
  Kernel k = new Kernel( new float[][] {
    {-1, -1, -1}, 
    {-1, 8, -1}, 
    {-1, -1, -1}
    } );
  Kernel k2 = new Kernel( new float[][] {
    {.11, .11, .11}, 
    {.11, .11, .11}, 
    {.11, .11, .11}
    } );
  k.apply(car, output);
  image(car, 0, 0);
  image(output, car.width, 0);
}
