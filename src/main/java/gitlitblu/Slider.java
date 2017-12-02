package gitlitblu;

import processing.core.PApplet;

public class Slider {
	private float x;
	
	public Slider() {
		x = (float) 1;
	}
	public void display(PApplet app) {
		app.fill(255);
		app.rect(x, (app.height / 3), 20, (app.height / 3));
	}
	
	public void slide() { //movement of slider
		x *= (float) 1.1;
	}
}