package main.java.framework;


import org.sikuli.*;

	
public class Sikuli {
	private Screen screen;
	
	// verify that image is visible
	public boolean verifyImageOnScreen() {

		// Create a screen region object that corresponds to the default monitor in full screen 
        ScreenRegion s = new DesktopScreenRegion();
                        
        // Specify an image as the target to find on the screen
        URL imageURL = new URL("http://code.google.com/images/code_logo.gif");                
        Target imageTarget = new ImageTarget(imageURL);
                        
        // Wait for the target to become visible on the screen for at most 5 seconds
        // Once the target is visible, it returns a screen region object corresponding
        // to the region occupied by this target
        ScreenRegion r = s.wait(imageTarget,5000);
                        
        // Display "Hello World" next to the found target for 3 seconds
        Canvas canvas = new DesktopCanvas();
        canvas.addLabel(r, "Hello World").display(3);
        
        // Click the center of the found target
        Mouse mouse = new DesktopMouse();
        mouse.click(r.getCenter());
	}
	
	// click on image center
	public void clickOnImage() {
		
	}
	
	
	// get coordinates of image
	
	
}
