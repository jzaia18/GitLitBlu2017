package gitlitblu;

import processing.core.PApplet;

import java.util.ArrayList;

public class Touhou implements Displayable{

	private ArrayList<Bullet> bullets;
	int minX, minY, maxX, maxY;
	Dodger player;
	
	private Touhou() {
		clear();
	}
	
	public Touhou(PApplet app){
		this();
		minX = app.width/5;
		minY = app.height/5;
		maxX = 4*minX;
		maxY = 4*minY;
		player = new Dodger(minX, minY, maxX, maxY);
	}
	
	public Touhou(int minX, int minY, int maxX, int maxY) {
		this();
		this.minX = minX;
		this.minY = minY;
		this.maxX = maxX;
		this.maxY = maxY;
		player = new Dodger(minX, minY, maxX, maxY);
	}
	
	public void clear() {
		bullets = new ArrayList<Bullet>();
	}
	
	public void display(PApplet app) {
		app.rect(minX, minY, maxX-minX, maxY-minY);
		createAtTop();
		for (Bullet b: bullets)
			b.display(app);
		player.display(app);
	}
	
	public void update(PApplet app) {
		for (int i = 0; i < bullets.size(); i++) {
			Bullet b = bullets.get(i);
			if (PApplet.dist(b.x, b.y, player.x, player.y) < (player.size+b.size)/2)
				System.exit(0); //REPLACE
			b.update(app);
			if (b.x < minX || b.x > maxX || b.y < minY || b.y > maxY)
				bullets.remove(i--);
		}
	}
	
	protected void populateAtTop(int amt) {
		while (amt-- >= 0)
			bullets.add(new Bullet((float)Math.random()*(maxX-minX)+minX, (float)Math.random()*minY/2+minY, PApplet.PI/2));
	}
	
	protected void createAtTop() {
		if (Math.random() * 30 < 1)
			bullets.add(new Bullet((float)Math.random()*(maxX-minX)+minX, (float)Math.random()*minY/2+minY, PApplet.PI/2));
	}
	
	
    public void keyPressed(Keys keys) {
    	player.keys=keys;
    }
	
}
