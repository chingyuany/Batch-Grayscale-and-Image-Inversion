
/**
 * Write a description of BatchInversions here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.io.*;
public class BatchInversions {
       public ImageResource makeInversion(ImageResource inImage) {
		//I made a blank image of the same size
		ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
		//for each pixel in outImage
		for (Pixel pixel: outImage.pixels()) {
			//look at the corresponding pixel in inImage
			Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
			//compute inPixel's red + inPixel's blue + inPixel's green
			//divide that sum by 3 (call it average)
			int invertred = 255 - inPixel.getRed();
			int invertblue = 255 - inPixel.getBlue();
			int invertgreen = 255 - inPixel.getGreen();
			
			//set pixel's red to average
			pixel.setRed(invertred);
			//set pixel's green to average
			pixel.setGreen(invertblue);
			//set pixel's blue to average
			pixel.setBlue(invertgreen);
		}
		//outImage is your answer
		return outImage;
	}

	public void selectAndConvert () {
		DirectoryResource dr = new DirectoryResource();
		for (File f : dr.selectedFiles()) {
			ImageResource inImage = new ImageResource(f);
			ImageResource invert = makeInversion(inImage);
			String fname = inImage.getFileName();
			String newName = "Inverted-" + fname;
			invert.setFileName(newName);
			invert.draw();
			invert.save();
		}
	}
}
