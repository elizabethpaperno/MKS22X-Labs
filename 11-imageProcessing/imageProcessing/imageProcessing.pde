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
    for (int i = - 1; i < 2; i++) {
      for (int j = -1; j < 2; j++) {
        if (x + i <= 0 || y + j <= 0 || x + i >= img.width - 1 || y + j >= img.height - 1) {
          totRed += red(img.get(x + i, y + j)) * kernel[i + 1][j + 1]; 
          totGreen += green(img.get(x + i, y + j)) * kernel[i + 1][j + 1]; 
          totBlue += blue(img.get(x + i, y + j)) * kernel[i + 1][j + 1];
        }
      }
    }
    if (totRed > 255){
      totRed = 255;
    } 
    if (totGreen > 255){
      totGreen = 255;
    }
    if (totBlue > 255){
      totBlue = 255;
    }
    if (totRed < 0){
      totRed = 0;
    } 
    if (totGreen < 0){
      totGreen = 0;
    }
    if (totBlue < 0){
      totBlue = 0;
    }
    
    color c = color(totRed, totGreen, totBlue);
    return c;
  }

  /**You must write this method that applies the kernel to the source,
   *and saves the data to the destination.*/
  void apply(PImage source, PImage destination) {
    for (int r = 0; r < source.width; r++) {
      for (int c = 0; c < source.height; c++) {
        color col = calcNewColor(source, r, c); 
        destination.set(r, c, col);
      }
    }
  }
}

String[]names;
Kernel[]kernels;
int currentKernel;

void setup() {
  currentKernel = 0;
  names = new String[]{
    "Identity", "Blur", "Sharpen", 
    "Outline", "Left Sobel", "Right Sobel", 
    "Top Sobel", "Emboss"
  };

  kernels = new Kernel[] {
    new Kernel( new float[][] {
      {0, 0, 0}, 
      {0, 1, 0}, 
      {0, 0, 0}
    }), 
    new Kernel( new float[][] {
      {.111, .111, .111}, 
      {.111, .111, .111}, 
      {.111, .111, .111}
    }), 
    new Kernel( new float[][] {
      {0, -1, 0}, 
      {-1, 5, -1}, 
      {0, -1, 0}
    }), 
    new Kernel( new float[][] {
      {-1, -1, -1}, 
      {-1, 8, -1}, 
      {-1, -1, -1}
    }), 
    new Kernel( new float[][] {
      {1, 0, -1}, 
      {2, 0, -2}, 
      {1, 0, -1}
    }), 
    new Kernel( new float[][] {
      {-1, 0, 1}, 
      {-2, 0, 2}, 
      {-1, 0, 1}
    }), 
    new Kernel( new float[][] {
      {1, 2, 1}, 
      {0, 0, 0}, 
      {-1, -2, -1}
    }), 
    new Kernel( new float[][] {
      {-2, -1, 0}, 
      {-1, 1, 1}, 
      {0, 1, 2}
    })
  };
}

void keyPressed(){
  currentKernel += 1;
  if(currentKernel > kernels.length -1){
    currentKernel = 0;
  }
}
