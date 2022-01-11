import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class DeadZombie{
	private Image img; 	
	private AffineTransform tx;
	private double x =0,y=0;
	private double xSpeed = 0, ySpeed =0;
	public DeadZombie(double x, double y, double newXSpeed, double newYSpeed) {
		img = getImage("/imgs/Charred_Zombie.png"); //load the image for Tree
		this.x = x;
		this.y= y;
		xSpeed = newXSpeed;
		ySpeed = newYSpeed;

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
	
		x-=xSpeed;


		y+=ySpeed;

		if (x >= 740||x <=5) {
			xSpeed*=-1;
		}
		if (y >= 385|| y <= 5 ) {
			ySpeed*=-1;
		}
		update();
		
	}
	
	private void update() {

		tx.setToTranslation(x,y);
		tx.scale(.15, .15);
	}
	
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(.25, .25);
	}
	public double getDeadZombieX() {
		return x;
	}
	public double getDeadZombieY() {
		return y;
	}	
	public double getDeadZombieSpeedX() {
		return xSpeed;
	}
	public double getDeadZombieSpeedY() {
		return ySpeed;
	}
	public void DeadZombieSet(double x, double y, double newXSpeed, double newYSpeed) {
		img = getImage("/imgs/Charred_Zombie.png"); //load the image for Tree
		this.x = x;
		this.y= y;
		xSpeed = newXSpeed;
		ySpeed = newYSpeed;

		tx = AffineTransform.getTranslateInstance(0, 0);
		update(); 				//initialize the location of the image
									//use your variables
	}
	
	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = DeadZombie.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}

}
