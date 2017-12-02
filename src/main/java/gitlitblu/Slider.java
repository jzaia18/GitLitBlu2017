package gitlitblu;

import processing.core.PApplet;
import processing.event.KeyEvent;

public class Slider {
	private float x;
	private boolean isMoving;
	private boolean hit;
	public Keys keys;
	
	public Slider() {
		x = (float) 1;
		isMoving = true;
	}
	public void display(PApplet app) {
		keysPressed(keys);
		app.fill(255);
		app.rect(x, (app.height / 3), 20, (app.height / 3));
	}
	
	public void slide() { //movement of slider
		if (isMoving) {
			x *= (float) 1.1;
		}
	}
	
	public void keysPressed(Keys keys) {
    	if (keys == null) {
    		return ;
    	}
    	for (KeyEvent event : keys.keysPressed()) {
    		System.out.println(event.getKeyCode());
    		if (event.getKeyCode() == ' ') {
        		isMoving = false;
    		}
    	}
    }
	
	public void attack(PApplet app) {
		float hitLeft = (app.width / 4);
		float hitRight = (app.width - (app.width / 4));
    	if (isMoving == false) {
    		if (x > hitLeft && x < hitRight) {
    			hit = true;
    		}
    		else {
    			hit = false;
    		}
    	}
    	else
    		hit = false;
	}
}