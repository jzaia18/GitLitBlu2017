package gitlitblu;

import processing.core.PApplet;

public class Bullet implements Displayable{

	public float x, y, heading;
	private int r, g, b;
	
	Bullet(float x, float y, float heading){
		this.x=x;
		this.y=y;
		this.heading=heading;
		r = (int)(Math.random()*255);
		g = (int)(Math.random()*255);
		b = (int)(Math.random()*255);
	}
	
	public void update(PApplet app) {
		int speed = 5;
		x+= speed*PApplet.cos(heading);
		y+= speed*PApplet.sin(heading);
	}
	
	public void display(PApplet app) {
		app.fill(r, g, b);
		app.ellipse(x, y, 10, 10);
	}
	
}
