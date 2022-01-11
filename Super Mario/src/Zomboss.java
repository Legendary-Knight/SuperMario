import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Zomboss{
	private Image img; 	
	private AffineTransform tx;
	private double [] zombie =  {0,0, (Math.random()*12)+5, (Math.random()*12)+5};
	/*
	private double zombie[0] =0,zombie[1]=0;
	private double zombie[2] = (Math.random()*12)+5, zombie[3] =(Math.random()*12)+5;
	*/
	public Zomboss(double x, double y) {
		img = getImage("/imgs/Zomboss.png"); //load the image for Tree
		zombie[0] = x;
		zombie[1]= y;

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
		zombie[0]-=zombie[2];
		zombie[1]+=zombie[3];
		if (zombie[0] >= 740||zombie[0] <=5) {
			zombie[2]*=-1;
		}
		if (zombie[1] >= 385|| zombie[1] <= 5 ) {
			zombie[3]*=-1;
		}
		update();
		
	}
	
	private void update() {
		tx.setToTranslation(zombie[0],zombie[1]);
		tx.scale(.3, .3);
	}
	
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(.25, .25);
	}
	public double getBZombieX() {
		return zombie[0];
	}
	public double getBZombieY() {
		return zombie[1];
	}
	public double getBZombieSpeedX() {
		return zombie[2];
	}
	public double getBZombieSpeedY() {
		return zombie[3];
	}
	public void setBZombieSpeedX(double newXSpeed) {
		zombie[2] = newXSpeed;
	}
	public void setBZombieSpeedY(double newYSpeed) {
		zombie[3] = newYSpeed;
	}
	/*
	public void zombieFloat() {
		zombie[2] =0;
		while (zombie[1]>=-100) {
			zombie[1]-=5;
		}
	}
	*/
	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Zomboss.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}

}
