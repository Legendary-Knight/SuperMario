import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Goomba{
	private Image img; 	
	private AffineTransform tx;
	private double x =0,y=0,XI,YI;
	private double xSpeed = 5, ySpeed =0, goombaL=1;
	public Goomba(double x, double y) {
		img = getImage("/imgs/Goomba1.png"); //load the image for Tree
		this.x = x; 
		this.y= y;
		XI=x;
		YI=y;
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
		/*
		if (x >= 740||x <=5) {
			xSpeed*=-1;
		}
		if (y >= 385|| y <= 5 ) {
			ySpeed*=-1;
		}
		*/
		update();
		
	}
	
	private void update() {
		tx.setToTranslation(x,y);
		tx.scale(.055, .055);
	}
	
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(.25, .25);
	}
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	public double getSpeedX() {
		return xSpeed;
	}
	public double getSpeedY() {
		return ySpeed;
	}


	public void setY(double y) {
		this.y = y;
	}
	public double getGoombaL() {
		return goombaL;
	}
	public void setSpeedX(double newXSpeed) {
		
		if(newXSpeed!=0) {
			goombaL=xSpeed/(Math.abs(xSpeed));
		}
		
		xSpeed = newXSpeed;
	}
	public void setpeedY(double newYSpeed) {
		ySpeed = newYSpeed;
	}
	/*
	public void zombieFloat() {
		xSpeed =0;
		while (y>=-100) {
			y-=5;
		}
	}
	*/
	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Goomba.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}

	public void setX(double d) {
		// TODO Auto-generated method stub
		x=d;
	}
	public void reset() {
		x=XI;
		y=YI;
	}
		

}