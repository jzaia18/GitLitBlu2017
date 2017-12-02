package gitlitblu;

import processing.core.PApplet;
import processing.event.KeyEvent;

public class Slider {
    
    private float x;
    private boolean isMoving;
    public Boolean hit;
    public Keys keys;
    
    public Slider() {
        x = 1;
        isMoving = true;
    }
    
    public void display(final PApplet app) {
        keysPressed(keys);
        app.fill(255);
        app.rect(x, app.height / 3, 20, app.height / 3);
    }
    
    public void slide() { //movement of slider
        if (isMoving) {
            if (x < 700) {
                x *= (float) 1.1;
            } else {
                hit = false;
            }
        }
    }
    
    public void keysPressed(final Keys keys) {
        if (keys == null) {
            return;
        }
        for (final KeyEvent event : keys.keysPressed()) {
            System.out.println(event.getKeyCode());
            if (event.getKeyCode() == ' ') {
                isMoving = false;
            }
        }
    }
    
    public void attack(final PApplet app) {
        if (isMoving == false) {
            if (x > 0 && x < 700) {
                hit = true;
            } else {
                hit = false;
            }
        } else {
            hit = false;
        }
    }
}