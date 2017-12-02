package gitlitblu;

import processing.core.PApplet;
import processing.core.PImage;

/**
 * 
 * 
 * @author Khyber Sen
 */
public class Sprite implements Displayable {
    
    protected final GitLitBlu app;
    
    protected final PImage img;
    
    protected float x;
    protected float y;
    
    public Sprite(final GitLitBlu app, final String imgName, final float x, final float y) {
        this.app = app;
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
