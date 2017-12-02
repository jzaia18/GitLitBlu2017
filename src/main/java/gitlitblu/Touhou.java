package gitlitblu;

import processing.core.PApplet;
import java.util.ArrayList;

public class Touhou extends PApplet implements Displayable{

	private ArrayList<Bullet> bullets;
	
	public Touhou(){
		bullets = new ArrayList<Bullet>();
	}
	
	// Main method for use
	public void display(PApplet app) {
		app.rect(app.width/5, app.height/5, 3*app.width/5, 3*app.height/5);
		for (Bullet b: bullets)
			b.display(app);
	}
	
	public void update(PApplet app) {
		for (int i = 0; i < bullets.size(); i++) {
			Bullet b = bullets.get(i);
			b.update(app);
			if (b.x < app.width/5 || b.x > 4*app.width/5 || b.y < app.height/5 || b.y > 4*app.height/5)
				bullets.remove(i--);
		}
	}
	
	protected void populateAtTop(PApplet app, int amt) {
		while (amt-- >= 0) {
			bullets.add(new Bullet((float)Math.random()*3*app.width/5+app.width/5, (float)Math.random()*app.height/10+app.height/5, PApplet.PI/2));
		}
	}
	
}
