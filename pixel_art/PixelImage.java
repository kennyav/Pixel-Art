//package com.javacodegeeks.snippets.desktop;

import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
 
//import java.awt.Color;
//import java.awt.Graphics2D;


public class PixelImage {


   public static void main(String args[]) throws IOException{

      // total pixels are 204800
      int height = 15;
      int width = 15;

      // creating the buffered image object img
      BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

      File f = null;

      for (int i = 0; i < height; i++){
         int redRate = 15;
         int greenRate = 200;
         int blueRate = 10;
         for (int j = 0; j < width; j++){
            int a = (int)(.8*256); // alpha
            int r = redRate; // red
            int g = greenRate; // green
            int b = blueRate; // blue

            redRate += 15;
            greenRate -= 5;
            blueRate ++;

            int p = (a << 24) | (r << 20) | (g << 8)| (b << 2); // pixel

            img.setRGB(j, i, p);
         }
      }

      // write image
      try{
         f = new File("RandomPixe.png");
         ImageIO.write(img, "png", f);
      }catch(IOException e){
         System.out.println("Error: " + e);
      }
   }
}