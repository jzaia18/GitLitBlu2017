package gitlitblu;

import processing.core.PApplet;
import processing.event.KeyEvent;

/**
 * 
 * 
 * @author Khyber Sen
 */
public class GitLitBlu extends PApplet {
    
    private final Keys keys = new Keys();
    
    private Sprite mainCharacter;
    //    private Touhou t;
    
    public static void main(final String[] args) {
        PApplet.main(GitLitBlu.class.getName());
    }
    
    @Override
    public void settings() {
        size(720, 720);
    }
    
    @Override
    public void setup() {
        mainCharacter = new Sprite(this, "Alphys.png", width * 0.5f, height * 0.5f);
        //    	t = new Touhou();
        //    	t.populateAtTop(this, 10);
    }
    
    @Override
    public void draw() {
        fill(150);
        clear();
        mainCharacter.display(this);
        //        t.display(this);
    }
    
    @Override
    public void keyPressed(final KeyEvent event) {
        super.keyPressed(event);
        keys.keyPressed(event);
        mainCharacter.keyPressed(keys);
    }
    
    @Override
    public void keyReleased(final KeyEvent event) {
        super.keyReleased(event);
        keys.keyReleased(event);
    }
    
}
