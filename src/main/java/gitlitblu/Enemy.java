package gitlitblu;

import processing.core.PApplet;

/**
 * 
 * 
 * @author Khyber Sen
 */
public class Enemy extends Sprite {
    
    private final float radius;
    
    private String text;
    private boolean speaking;
    
    public Enemy(final PApplet app, final String imgName, final float x, final float y,
            final float radius) {
        super(app, imgName, x, y);
        this.radius = radius;
    }
    
    @Override
    public void display(final PApplet app) {
        super.display(app);
        if (speaking) {
            app.textSize(app.width * .1f);
            app.text(text, x, y);
            speaking = false;
        }
    }
    
    public void speak() {
        speaking = true;
        text = "Hello";
    }
    
    public boolean inRadius(final float x, final float y) {
        final float dx = this.x - x;
        final float dy = this.y - y;
        return dx * dx + dy * dy < radius * radius;
    }
    
}
