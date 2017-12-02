package gitlitblu;

import processing.core.PApplet;
import processing.event.KeyEvent;

public class Dodger implements Displayable {

	public Keys keys;
	
	int size;
	float x, y;
	double minX, minY, maxX, maxY;
	
	public Dodger(int minX, int minY, int maxX, int maxY) {
		this.size = 20;
		this.minX = minX;
		this.minY = minY;
		this.maxX = maxX;
		this.maxY = maxY;
		this.x = (minX + maxX) / 2;
		this.y = maxY - size*2;
	}
	
	public void display(PApplet app) {
		keysPressed(keys);
		app.fill(0, 200, 200);
		app.ellipse(x, y, size, size);
	}

	public void keysPressed(final Keys keys) {
		if (keys == null)
			return;
		
		int speed = 5;
		
        for (final KeyEvent event : keys.keysPressed()) {
            switch (event.getKey()) {
                case 'a':
                	if (x > minX + size/2)
                		x -= speed;
                    break;
                case 'd':
                	if (x < maxX - size/2)
                		x += speed;
                    break;
                case 'w':
                	if (y > minY + size/2)
                		y -= speed;
                    break;
                case 's':
                	if (y < maxY - size/2)
                		y += speed;
                    break;
            }
        }
	}
}
