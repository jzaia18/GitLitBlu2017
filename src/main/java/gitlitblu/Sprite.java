package gitlitblu;

import processing.core.PApplet;
import processing.core.PImage;

/**
 * 
 * 
 * @author Khyber Sen
 */
public class Sprite implements Displayable {
    
    private final PImage img;
    
    protected float x;
    protected float y;
    
    public Sprite(final PApplet app, final String imgName, final float x, final float y) {
        img = app.loadImage("images/" + imgName);
        this.x = x;
        this.y = y;
    }
    
    public float x() {
        return x;
    }
    
    public float y() {
        return y;
    }
    
    @Override
    public void display(final PApplet app) {
        app.image(img, x, y);
    }
    
}
