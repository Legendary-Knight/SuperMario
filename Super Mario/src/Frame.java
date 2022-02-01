import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/*Comments
 * 
 * 
 * very yum
 * 
 * I like the terrain generation
 * 
 * nicep roject
 * legendary game 
 * vwery cool, cvan't beat boweser
 * 
 * good game but clouds spawn on the ground
 * very well made
 * w
 */


/*
 * control
 * arrow keys to move
 * press down at pipe to go to boss fight
 * jump fast
 * I WONNNNNNNNNNNN
 */
public class Frame extends JPanel implements ActionListener, MouseListener, KeyListener {

	Background b = new Background(0,0);
	BowserC bc = new BowserC(0,-380);
	Blackness black =new Blackness(-2100,0);
	Blackness black2 =new Blackness(2200,0);
	Pipe p1= new Pipe(92,450);
	ArrayList<BFire> fire = new ArrayList<BFire>();
	
	
	Pipe[] pipes = {new Pipe(92,450), new Pipe(1000,450),new Pipe(5600,450), };
	MarioWL MWL = new MarioWL(200,500);
	MarioWR MWR = new MarioWR(200,500);
	MarioJL MJL = new MarioJL(200,500);
	MarioJR MJR = new MarioJR(200,500);
	StillMario sm = new StillMario(500,500);
	ArrayList<Background> ground = new ArrayList<Background>();
	ArrayList<Background> wall = new ArrayList<Background>();
	ArrayList<Sky> sky = new ArrayList<Sky>();
	Goomba[] goombas = {new Goomba(800,500), new Goomba(46*6,500), new Goomba(46*9,500), new Goomba(46*55,500), new Goomba(46*60,500), new Goomba(46*65,500) , new Goomba(46*70,500), new Goomba(46*96,50), new Goomba(46*102,50), new Goomba(46*108,50)};
	Bowser bowser = new Bowser(1200, 225);
	ArrayList<Brick> bricks = new ArrayList<Brick>();
	
	//Brick[] bricks = {new Brick(300-24,350),new Brick(346-24,350), new Brick(438-24,350), new Brick(484-24,350)};
	boolean reset=false;
	int BH=3;
	int wait2=1000;
	boolean jumpF=false, jumpF2=false;
	double bowserJ=0;
	boolean bowserJU= false;
	boolean bowserS=false;
	int fireIt=0;
	int countA=0;
	double lastD=-1;
	int time=100;
	double MSpeedX=0;
	double MSpeedY=6;
	int marioJump=100;
	boolean world2= false;
	boolean collisionL=false;
	boolean collisionR=false;
	boolean collisionB=false;
	boolean collisionT=false;
	boolean MarioDead=false;
	boolean stop=false;

	/*
	LawnMower L = new LawnMower(0,0);
	LawnMower L1 = new LawnMower(10, 425);
	LawnMower L2 = new LawnMower(60, 425);
	LawnMower L3 = new LawnMower(110, 425);
	LawnMower L4 = new LawnMower(160, 425);
	LawnMower L5 = new LawnMower(210, 425);
	LawnMower L6 = new LawnMower(260, 425);
	LawnMower L7 = new LawnMower(310, 425);
	LawnMower L8 = new LawnMower(360, 425);
	LawnMower L9 = new LawnMower(410, 425);
	LawnMower L10 = new LawnMower(460, 425);
	*/
	

	
	

	int wait =0;
	int score=0;
	boolean[] zombieKilled = {false,false};
	int lives = 3;
	int timer = 1000;
	int i =0;
	int j =0;
	int dead =0;
	
	
	public void paint(Graphics g) {
		super.paintComponent(g);
		if(reset) {
			j=0;
			i=0;
			reset = false;
			MarioDead=false;
			world2=false;
			BH=3;
			score=0;
			sm.reset();
			bowser.reset();
			bc.reset();
			black.reset();
			black2.reset();
			for(int i=0; i<goombas.length; i++) {
				goombas[i].reset();
				goombas[i].setSpeedX(5);
			}
			for(int i=0; i<pipes.length; i++) {
				pipes[i].reset();
			}
			while(ground.size()!=0) {
				ground.remove(0);
			}
			while(wall.size()!=0) {
				wall.remove(0);
			}
			while(ground.size()!=0) {
				ground.remove(0);
			}
			while(sky.size()!=0) {
				sky.remove(0);
			}
			while(fire.size()!=0) {
				fire.remove(0);
			}
			while(bricks.size()!=0) {
				bricks.remove(0);
			}
		}
		//System.out.println(goombas[0].getX());
		
		
		if(!world2) {
			if(j==0) {
				for(int x=400; x<=400+46; x+=46) {
					bricks.add(new Brick(x,350));
				}
				for(int x=538; x<=538+46; x+=46) {
					bricks.add(new Brick(x,350));
				}
				for(int x=88; x<92; x++) {
					bricks.add(new Brick(x*46,350));
				}
				for(int x=94; x<110; x++) {
					bricks.add(new Brick(x*46,100));
				}
				for(int x=112; x<116; x++) {
					bricks.add(new Brick(x*46,350));
				}
				
				
				for(int y=0; y<3; y++) {
					for(int x=0; x<28; x++) {
						ground.add(new Background(x*46,580+y*46));
					}
					for(int x=32; x<60; x++) {
						ground.add(new Background(x*46,580+y*46));
					}
					for(int x=64; x<92; x++) {
						ground.add(new Background(x*46,580+y*46));
					}
					for(int x=112; x<200; x++) {
						ground.add(new Background(x*46,580+y*46));
					}
				}
				
				for(int y=-20; y<2; y++) {
					for(int x=-10; x<0; x++) {
						ground.add(new Background(x*46,580+y*46));
					}
				}
				for(int y=0; y<2; y++) {
					for(int x=-1; x<10; x++) {
						sky.add(new Sky(x*900,y*525));
					}
				}
				
				j++;
			}
			
			
			
			for(int i=sky.size()-1; i>=0; i--) {
				sky.get(i).paint(g);
			}
	
			
			
			//b.paint(g);
			//p1.paint(g);
			for(int a=0; a<pipes.length; a++) {
				pipes[a].paint(g);
			}
			
			/*
			for(int i=0; i<bricks.length;i++) {
				bricks[i].paint(g);
			}
			*/
	
			//bowser.paint(g);
	
			
			for(int i=0; i<goombas.length;i++) {
				goombas[i].paint(g);
				//System.out.println("goomba");
				if(goombas[i].getX()<-500 || goombas[i].getX()>1500) {
					goombas[i].setSpeedX(0);
				}
				else {
					if(goombas[i].getSpeedX()==0) {
						goombas[i].setSpeedX(goombas[i].getGoombaL()*5);
					}
				}
				
				
			}
	
			
	
			for(Brick thisG: bricks) {
				thisG.paint(g);
			}
			for(Background thisG: ground) {
				thisG.paint(g);
			}
			
			
			
			
			if(MSpeedX!=0) {
				lastD= MSpeedX;
			}
			
			MWL.setX(sm.getX());
			MWL.setY(sm.getY());
			MWR.setX(sm.getX());
			MWR.setY(sm.getY());
			
			MJL.setX(sm.getX());
			MJL.setY(sm.getY());
			MJR.setX(sm.getX());
			MJR.setY(sm.getY());
			 
			
			//sm.paint(g);
			
			if( !collisionB) {
				if((MSpeedX)>0 || lastD>0) {
					MJL.paint(g);  
				}
				else if(MSpeedX<=0 || lastD<0) {
					MJR.paint(g);
				}
			}
			else { 
				if((MSpeedX)>0) {
					MWL.paint(g);  
				}
				else if(MSpeedX<0) {
					MWR.paint(g);
				} 
				else if(collisionB){
					sm.paint(g);
				}
			}
			
			
			/*
			System.out.println("z1 " + health[0]+ "   ");
			System.out.println(zombieKilled[0]+ "   ");
			System.out.println("z2 " +health[1]+ "   ");
			System.out.println(zombieKilled[1]+ "   ");
			*/
			
			/*
			for(Background thisG: ground) {
				if(thisG.getX()+46>sm.getX()) {
					collisionL =true;
				}
			}
			*/
			collisionL=false;
			collisionR=false;
			collisionT=false;
			collisionB=false;
			
			for(int x=0; x<goombas.length;x++) {
				collision(sm.getX()+46,sm.getX(),sm.getY(),sm.getY()+70,goombas[x].getX()+46,goombas[x].getX(),goombas[x].getY()-10,goombas[x].getY()+46, true);
				
				//System.out.println(collisionB);
				
				if(!collisionT&&!collisionR && !collisionL &&collisionB) {
					goombas[x].setX(-100);
					goombas[x].setY(1000);
					collisionB=false;
					MSpeedY=10;
				
				}
			}
			if(sm.getY()>=700) {
				MarioDead=true;
			}
	
			if((collisionR || collisionL || collisionT &&!collisionB)||MarioDead) {
				if(countA<1) {
					MSpeedY=20;
					Music MD = new Music("MDeathBoost.wav",false);
					MD.play();
				}
				for(int i=0; i<goombas.length;i++) {
					goombas[i].setSpeedX(0);
				}
				countA++;
				MarioDead=true;
					
				MSpeedY-=2;
				sm.setY(sm.getY()-MSpeedY);
				MSpeedX=0;
	
				/*
				for(int i=0; i<4000; i++) {
					if(i%50==0) {
						sm.setY(sm.getY()-MSpeedY);
						if(MSpeedY>-20) {
							MSpeedY-=1;
						}
					}
				}
				*/
				
			}
			else {
				collisionL=false;
				collisionR=false;
				collisionT=false;
				collisionB=false;
				
				for(int x=0; x<goombas.length;x++) {
					for(int a=0; a<pipes.length; a++) {
						collision(goombas[x].getX()+46,goombas[x].getX(),goombas[x].getY(),goombas[x].getY()+66,p1.getX()+92,pipes[a].getX(),pipes[a].getY(),pipes[a].getY()+250, false);
					}
					//System.out.println(collisionL);
					//System.out.println(collisionR);		
					for(int i=0; i<bricks.size();i++) {
						collision(goombas[x].getX()+46,goombas[x].getX(),goombas[x].getY(),goombas[x].getY()+60,bricks.get(i).getX()+46,bricks.get(i).getX(),bricks.get(i).getY(),bricks.get(i).getY()+46, false);
					}
					for(Background thisG: ground) { 
						collision(goombas[x].getX()+46,goombas[x].getX(),goombas[x].getY(),goombas[x].getY()+60,thisG.getX()+46,thisG.getX(),thisG.getY(),thisG.getY()+46, false);
	
					}
					if((collisionB==false)) {
						goombas[x].setY(goombas[x].getY()+10);
						//collisionB=false;
					}
					if(collisionL || collisionR) {
						goombas[x].setSpeedX(goombas[x].getSpeedX()*-1);
						collisionL=false;
						collisionR=false;
					}
					collisionB=false;
				}
					//collisionB=false;
					//System.out.println(collisionB);
			}
	
	
				
				collisionL=false;
				collisionR=false;
				collisionT=false;
				collisionB=false;
				
				
				for(int a=0; a<pipes.length; a++) {
					collision(sm.getX()+46,sm.getX(),sm.getY(),sm.getY()+70,pipes[a].getX()+92,pipes[a].getX(),pipes[a].getY(),pipes[a].getY()+250, true);
				}
				//System.out.println(collisionL);
				//System.out.println(collisionR);		
				for(int i=0; i<bricks.size();i++) {
					collision(sm.getX()+40,sm.getX(),sm.getY(),sm.getY()+70,bricks.get(i).getX()+46,bricks.get(i).getX(),bricks.get(i).getY(),bricks.get(i).getY()+46, true);
				}
				for(Background thisG: ground) { 
					collision(sm.getX()+40,sm.getX(),sm.getY(),sm.getY()+70,thisG.getX()+46,thisG.getX(),thisG.getY(),thisG.getY()+46, true);
				}
				//System.out.println(collisionB);
				
				/*
				if(marioJump<50) {
					for(Background thisG: ground) {
						thisG.setY((thisG.getY()+MSpeedY));
					}
					p1.setY(p1.getY()+MSpeedY);
					marioJump++;
				}
				else if(collisionB==false && stop==false) {
					for(Background thisG: ground) {
						thisG.setY((thisG.getY()-5));
					}
					p1.setY(p1.getY()-5);
				}
				else {
					MSpeedY=0;
				}
				*/
				/*
				if(time<=10) {
					time++;
				}
				else {
					if(MSpeedX>=2) {
						MSpeedX-=2;
					}
					else {
						MSpeedX=0;
					}
				}
				*/
				if( (collisionL==false && MSpeedX>0) || (collisionR==false && MSpeedX<0)) {
					for(Background thisG: ground) {
						thisG.setX((thisG.getX()+MSpeedX));
					}
					for(int a=0; a<pipes.length; a++) {
						pipes[a].setX((pipes[a].getX()+MSpeedX));
					}
					for(int i=0; i<bricks.size();i++) {
						bricks.get(i).setX(bricks.get(i).getX()+MSpeedX);
					}
					p1.setX(p1.getX()+MSpeedX);
					for(int i=0; i<goombas.length; i++) {
						goombas[i].setX(goombas[i].getX()+MSpeedX);
					}
					for(int i=sky.size()-1; i>=0; i--) {
						sky.get(i).setX(sky.get(i).getX()+MSpeedX);
					}
					//bowser.setX(bowser.getX()+MSpeedX);
				}
				
				
				if((collisionB==false) || (marioJump<1)) {
					/*
					for(Background thisG: ground) {
						thisG.setY((thisG.getY()+MSpeedY));
					}
					for(int i=0; i<bricks.length;i++) {
						bricks[i].setY(bricks[i].getY()+MSpeedY);
					}
					p1.setY(p1.getY()+MSpeedY);
					MSpeedY-=1;
					marioJump++;
					*/
					sm.setY(sm.getY()-MSpeedY);
					MSpeedY-=.8;
					marioJump++;
					
		
					
				}
				else {
					MSpeedY=0;
				}
		}
		
		
		
		else {
			
			
			
			
			
			black2.paint(g);
			bc.paint(g);
			black.paint(g);
			if(wall.size()<9){
				for(int y=-23; y<46*11; y+=46) {
					wall.add(new Background(1950, y));
				}
			}
			if(BH!=0) {
				for(int i=0; i<wall.size();i++) {
					wall.get(i).paint(g);
				}
			}
			
			if(MSpeedX!=0) {
				lastD= MSpeedX;
			}
			
			/*
			for(int i=0; i<1000; i++) {
				if(i%100==0) {
					fire.add(new BFire(bowser.getX(), Math.random()*400+200));
				}
			}
			*/
			if(fireIt%70==0 && !bowserJU && !bowserS && !MarioDead) {
				score++;
				if(fireIt%700==0) {
					bowserJ=sm.getX();
					bowserJU=true;
					jumpF= false;
					jumpF2= false;
					wait=0;
				}
				
				else if(fireIt%350==0) {
					/*
					fire.add(new BFire(bowser.getX(), 200));
					fire.add(new BFire(bowser.getX(), 345));
					fire.add(new BFire(bowser.getX(), 480));
					*/
					fire.add(new BFire(bowser.getX(), Math.random()*140+200));
					fire.get(fire.size()-1).setSpeedY(2);
					fire.add(new BFire(bowser.getX(), Math.random()*140+340));
					fire.get(fire.size()-1).setSpeedY(-2);
				}
				else {
					fire.add(new BFire(bowser.getX(), Math.random()*280+200));
				}
				
			}
			fireIt++;
			
			/*
			System.out.println(bowserJ);
			if((bowser.getX()+100>bowserJ || bowser.getY()>=-100) && bowserJU) {
				bowser.setSpeedX(10);
				if(bowser.getY()>=-100) {
					bowser.setSpeedY(-15);
				}
				else {
					bowser.setSpeedY(0);
				}
			}
			else if((bowser.getX()<bc.getX()+1580 || bowser.getY()>=-100) && bowserS) {
				bowser.setSpeedX(-10);
				if(bowser.getY()>=-100) {
					bowser.setSpeedY(-15);
				}
				else {
					bowser.setSpeedY(0);
				}
			}
			else {
				if(bowser.getY()<225) {
					bowser.setSpeedY(30);
				}
				else {
					if(bowser.getSpeedX()==30) {
						bowserS=true;
					}
					bowser.setSpeedY(0);
				}
				bowserJU=false;
				bowser.setSpeedX(0);
			}
			*/
			//System.out.println(bowser.getY());
			if(bowserJU) {
				if(bowser.getX()+100>bowserJ || bowser.getY()>=-100 && !jumpF) {
					bowser.setSpeedX(10);
					if(bowser.getY()>=-100) {
						bowser.setSpeedY(-15);
					}
					
					else {
						bowser.setSpeedY(0);
					}
				}
				else {
					jumpF= true;
					if(bowser.getY()<=225) {
						bowser.setSpeedY(30);
					}
					else {
						bowser.setSpeedY(0);
						if(bowser.getY()>=225) {
							bowserJU=false;
							bowserS=true;
						}
					}
					bowser.setSpeedX(0);
				}
			}
			else if(bowserS && wait>=200) {
				if(bowser.getX()<bc.getX()+1630 || bowser.getY()>=-100 && !jumpF2 ) {
					bowser.setSpeedX(-10);
					if(bowser.getY()>=-100) {
						bowser.setSpeedY(-15);
					}
					else {
						bowser.setSpeedY(0);
					}
				}
				else {
					jumpF2= true;
					if(bowser.getY()<=225) {
						bowser.setSpeedY(30);
					}
					else {
						bowser.setSpeedY(0);
						bowserS=false;
					}
					bowser.setSpeedX(0);
				}
			}
			else {
				wait++;
			}

			
			
			
			for(int i=0; i<fire.size(); i++) {
				if(fire.get(i).getY()<190) {
					fire.get(i).setSpeedY(2);
				}
				else if(fire.get(i).getY()>500) {
					fire.get(i).setSpeedY(-2);
				}
				fire.get(i).paint(g);
				/*
				g.setColor(new Color (200, 0, 0));
				g.drawRect((int)fire.get(i).getX(),(int)fire.get(i).getY()+50, 200,50);
				*/
			}
			
			MWL.setX(sm.getX());
			MWL.setY(sm.getY());
			MWR.setX(sm.getX());
			MWR.setY(sm.getY());
			
			MJL.setX(sm.getX());
			MJL.setY(sm.getY());
			MJR.setX(sm.getX());
			MJR.setY(sm.getY());
			 
			
			//sm.paint(g);
			
			if( !collisionB) {
				if((MSpeedX)>0 || lastD>0) {
					MJL.paint(g);  
				}
				else if(MSpeedX<=0 || lastD<0) {
					MJR.paint(g);
				}
			}
			else { 
				if((MSpeedX)>0) {
					MWL.paint(g);  
				}
				else if(MSpeedX<0) {
					MWR.paint(g);
				} 
				else if(collisionB){
					sm.paint(g);
				}
			}
			g.setColor(new Color (200, 0, 0));
			g.drawRect(250, 600, 800, 100);
			g.fillRect(250, 600, (int) (800/3 * BH), 100);
			if(BH>0) {
				bowser.paint(g);
			}
			
			
			collisionL=false;
			collisionR=false;
			collisionT=false;
			collisionB=false;
			
			
			g.setColor(new Color (200, 0, 0));
			g.drawRect((int)bowser.getX(),(int)bowser.getY(), 150,200);
			g.drawRect((int)bowser.getX()+150,(int)bowser.getY()+80, 150,200);
			
			collision(sm.getX()+46,sm.getX(),sm.getY(),sm.getY()+70,bowser.getX()+150,bowser.getX(),bowser.getY(),bowser.getY()+200, true);
			collision(sm.getX()+46,sm.getX(),sm.getY(),sm.getY()+70,bowser.getX()+300,bowser.getX()+150,bowser.getY()+80,bowser.getY()+280, true);
			if(collisionB && bowserS && wait2>=300) {
				wait2=0;
				BH-=1;
				MSpeedY=10;
			}
			wait2++;
			System.out.println(wait2);
			if(BH==0) {
				bowser.setX(-2000);
				bowser.setY(-2000);
			}
			collisionB=false;
			for(int x=0; x<fire.size();x++) {
				collision(sm.getX()+46,sm.getX(),sm.getY(),sm.getY()+70,fire.get(x).getX()+200,fire.get(x).getX(),fire.get(x).getY()+50,fire.get(x).getY()+100, true);
				
				//System.out.println(collisionB);
			}
			if(collisionL || collisionR || collisionB || collisionT) {
				MarioDead=true;
			}
			if(sm.getY()>=700) {
				MarioDead=true;
			}
	
			if(MarioDead) {
				if(countA<1) {
					MSpeedY=20;
					Music MD = new Music("MDeathBoost.wav",false);
					MD.play();
				}
				countA++;
				MarioDead=true;
					
				MSpeedY-=2;
				sm.setY(sm.getY()-MSpeedY);
				MSpeedX=0;
	
				/*
				for(int i=0; i<4000; i++) {
					if(i%50==0) {
						sm.setY(sm.getY()-MSpeedY);
						if(MSpeedY>-20) {
							MSpeedY-=1;
						}
					}
				}
				*/
				
			}
			
			collisionL=false;
			collisionR=false;
			collisionT=false;
			collisionB=false;

			collision(sm.getX()+40,sm.getX(),sm.getY(),sm.getY()+70,bc.getX()+2200,bc.getX()+125,bc.getY()+911,bc.getY()+1000, true);
			if(BH!=0) {
				for(int i=0; i<wall.size();i++) {
					collision(sm.getX()+40,sm.getX(),sm.getY(),sm.getY()+70,wall.get(i).getX()+46,wall.get(i).getX(),wall.get(i).getY(),wall.get(i).getY()+46, true);
				}
			}
			if( (collisionL==false && MSpeedX>0) || (collisionR==false && MSpeedX<0)) {
				bc.setX(bc.getX()+MSpeedX);
				black.setX(black.getX()+MSpeedX);
				black2.setX(black2.getX()+MSpeedX);
				bowser.setX(bowser.getX()+MSpeedX);
				for(int i=0; i<fire.size(); i++) {
					fire.get(i).setX(fire.get(i).getX()+MSpeedX);
				}
				bowserJ+=MSpeedX;
				for(int i=0; i<wall.size();i++) {
					wall.get(i).setX(wall.get(i).getX()+MSpeedX);
				}
				
			}
			
			
			if((collisionB==false) || (marioJump<1)) {
				/*
				for(Background thisG: ground) {
					thisG.setY((thisG.getY()+MSpeedY));
				}
				for(int i=0; i<bricks.length;i++) {
					bricks[i].setY(bricks[i].getY()+MSpeedY);
				}
				p1.setY(p1.getY()+MSpeedY);
				MSpeedY-=1;
				marioJump++;
				*/
				sm.setY(sm.getY()-MSpeedY);
				MSpeedY-=.8;
				marioJump++;
				
	
				
			}
			else {
				MSpeedY=0;
			}
			
		}
		g.setFont(new Font("ComicSans", Font.PLAIN, 30));
		//prints the score
		g.setColor(new Color (200, 0, 0));
		g.drawString("Score: " + score, 500, 50);
		
		
		if(MarioDead) {
			g.setFont(new Font("ComicSans", Font.PLAIN, 60));
			//prints the score
			g.setColor(new Color (200, 0, 0));
			g.drawString("Press Up to Reset" , 300, 300);
		}
		if(BH==0) {
			g.setFont(new Font("ComicSans", Font.PLAIN, 80));
			//prints the score
			g.setColor(new Color (200, 0, 0));
			g.drawString("YOU WIN!!!!!" , 300, 300);
		}
		//g.drawString("Timer: " + timer, 50, 50);

		
	}
	
	public static void main(String[] arg) {
		/*
		Music pvz = new Music("PVZRemix.wav",true);
		Music ARS = new Music("Air-raid-siren.wav",true);
		ARS.play();
		pvz.play();
		*/
		Music MJ = new Music("MJump.wav",false);
		Music M = new Music("Super Mario Bros. Theme Song.wav",false);
		M.play();
		
		Frame f = new Frame();

	}
	
	public Frame() {
		JFrame f = new JFrame("Duck Hunt");
		f.setSize(new Dimension(1288, 700));
		f.setBackground(Color.blue);
		f.add(this);
		f.setResizable(false);
		f.setLayout(new GridLayout(1,2));
		f.addMouseListener(this);
		f.addKeyListener(this);
		Timer t = new Timer(8, this);
		t.start();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	
	
	@Override
	public void mouseClicked(MouseEvent arg0) {

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		//this.setCursor(Toolkit.getDefaultToolkit()
		
	    Toolkit toolkit = Toolkit.getDefaultToolkit();
	    Point hotSpot = new Point(0,0);
	    BufferedImage cursorImage = new BufferedImage(1, 1, BufferedImage.TRANSLUCENT); 
	    Cursor invisibleCursor = toolkit.createCustomCursor(cursorImage, hotSpot, "InvisibleCursor");        
	    setCursor(invisibleCursor);
	    
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		/*
		Music ss = new Music("Sniper.wav",false);
		ss.play();
		*/
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		repaint();
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		//System.out.println(arg0.getKeyCode());
		if(arg0.getKeyCode() == 39 && collisionR==false) {
			MSpeedX=-11;
			time=0;
			
			/*
			for(Background thisG: ground) {
				thisG.setX((thisG.getX()+MSpeedX));
			}
			for(int i=0; i<bricks.length;i++) {
				bricks[i].setX(bricks[i].getX()+MSpeedX);
			}
			p1.setX(p1.getX()+MSpeedX);
			*/
			
		}
		else if(arg0.getKeyCode() == 37 && collisionL==false) {
			MSpeedX=11;
			time=0;
			
			/*
			for(Background thisG: ground) {
				thisG.setX((thisG.getX()+MSpeedX));
			}
			for(int i=0; i<bricks.length;i++) {
				bricks[i].setX(bricks[i].getX()+MSpeedX);
			}
			p1.setX(p1.getX()+MSpeedX);
			*/
			
		}
		else{
			/*
			if(MSpeedX>=2) {
				MSpeedX-=2;
			}
			else {
				MSpeedX=0;
			}
			*/
		}
		if(arg0.getKeyCode() == 38 && collisionB==true && !MarioDead) {
			marioJump=0;
			MSpeedY=23;
			Music MJ = new Music("MJump.wav",false);
			MJ.play();
			/*
			for(Background thisG: ground) {
				thisG.setY((thisG.getY()+MSpeedY));
			}
			p1.setY(p1.getY()+MSpeedY);
			*/
			
			//stop=true;
		}
		if(arg0.getKeyCode() == 38 && MarioDead) {
			reset=true;
		}
		
		if(arg0.getKeyCode() == 40) {
			/*
			if(collision(sm.getX()+46,sm.getX(),sm.getY(),sm.getY()+70,pipes[2].getX()+92,pipes[2].getX(),pipes[2].getY(),pipes[2].getY()+250, true,true)) {
				world2=true;
			}*/
			sm.setY(400);
			world2=true;
		}
	}
	

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
		if(arg0.getKeyCode() == 39 || arg0.getKeyCode() == 37) {
			MSpeedX=0;
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void collision(double MarioR, double MarioL, double MarioT, double MarioB, double ObjR,double ObjL, double ObjT, double ObjB, boolean Mario) {
		//System.out.println(MSpeedY);
		boolean col = false;
		MarioB-=9;
		if(MarioR>ObjL && MarioL<ObjR & Mario) {
			double distance = ObjT-(MarioB-5);
			if(Math.abs(MSpeedY) > distance  && MSpeedY<0 && distance>1) {
				MSpeedY=(int) (Math.abs(distance)*-1);
			}
		}
		

		if(ObjR>MarioL && MarioB-5>ObjT && MarioT<ObjB && ObjR<MarioR) {
			collisionL =true;
			col =true;
		}
		if(ObjL<MarioR && MarioB-5>ObjT && MarioT<ObjB && ObjL>MarioL) {
			collisionR =true;
			col =true;
		}
		if(ObjT<MarioB && MarioR>ObjL && MarioL<ObjR && ObjB>MarioB) {
			collisionB = true;
			col =true;
		}
		if(ObjB>MarioT && MarioR>ObjL && MarioL<ObjR && ObjT<MarioT) {
			collisionT = true;
			col =true;
			if(MSpeedY>0) {
				MSpeedY=0;
			}
		}
	}
	public boolean collision(double MarioR, double MarioL, double MarioT, double MarioB, double ObjR,double ObjL, double ObjT, double ObjB, boolean Mario, boolean bool) {
		//System.out.println(MSpeedY);
		boolean col = false;


		if(ObjR>MarioL && MarioB-5>ObjT && MarioT<ObjB && ObjR<MarioR) {
			col =true;
		}
		if(ObjL<MarioR && MarioB-5>ObjT && MarioT<ObjB && ObjL>MarioL) {
			col =true;
		}
		if(ObjT<MarioB && MarioR>ObjL && MarioL<ObjR && ObjB>MarioB) {
			col =true;
		}
		if(ObjB>MarioT && MarioR>ObjL && MarioL<ObjR && ObjT<MarioT) {
			col =true;
		}
		return col;
	}

}