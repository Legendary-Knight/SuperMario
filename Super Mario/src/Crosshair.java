import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Crosshair{
	private Image img; 	
	private AffineTransform tx;
	private double x =0,y=0;
	public Crosshair() {
		img = getImage("/imgs/Crosshair.png"); //load the image for Tree
		//this.x=x;
		//this.y=y;

		
		tx = AffineTransform.getTranslateInstance(0, 0);
		update(); 				//initialize the location of the image
									//use your variables
	}

	public void changePicture(String newFileName) {
		img = getImage(newFileName);
		update();
	}
	
	public void paint(Graphics g) {
		//these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(img, tx, null);

		update();
		
	}



	private void update() {
		Point location = MouseInfo.getPointerInfo().getLocation();
        x = location.getX();
        y = location.getY();
		tx.setToTranslation(x-31,y-52);
		tx.scale(.1, .1);
	}
	public double getCrosshairY() {
		return (y);
	}
	public double getCrosshairX() {
		return (x);
	}
	
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(.2, .2);
	}

	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Crosshair.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}

}
