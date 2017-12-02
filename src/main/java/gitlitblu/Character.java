package gitlitblu;

import processing.core.PApplet;
import processing.core.PImage;
import processing.event.KeyEvent;

/**
 * 
 * 
 * @author Khyber Sen
 */
public class Character implements Displayable {
    
    private final PApplet app;
    
    private final PImage img;
    
    private float speed;
    
    private float x;
    private float y;
    
    public Character(final PApplet app, final String imgName, final float x, final float y) {
        this.app = app;
        img = app.loadImage("images/" + imgName);
        this.x = x;
        this.y = y;
        speed = 1;
    }
    
    public void setSpeed(final float speed) {
        this.speed = speed;
    }
    
    public void keyPressed(final KeyEvent event) {
        //        System.out.println(event.getKey());
        //        System.out.println(x + ", " + y);
        switch (event.getKey()) {
            case 'a':
                x -= speed;
                break;
            case 'd':
                x += speed;
                break;
            case 'w':
                y -= speed;
                break;
            case 's':
                y += speed;
                break;
        }
    }
    
    public void keyReleased(final KeyEvent event) {
        
    }
    
    public void display(final PApplet app) {
        app.image(img, x, y);
    }
    
}
