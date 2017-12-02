package gitlitblu;

import processing.core.PApplet;
import processing.event.KeyEvent;

/**
 * 
 * 
 * @author Khyber Sen
 */
public class GitLitBlu extends PApplet {
    
    private Character character;
    private Touhou t;
    
    public static void main(final String[] args) {
        PApplet.main(GitLitBlu.class.getName());
    }
    
    @Override
    public void settings() {
        size(720, 720);
    }
    
    @Override
    public void setup() {
    	t = new Touhou();
    	t.populateAtTop(this, 10);
        character = new Character(this, "Alphys.png", width * 0.5f, height * 0.5f);
    }
    
    @Override
    public void draw() {
    	fill(150);
        clear();
        t.display(this);
        //        character.display(this);
    }
    
    @Override
    public void keyPressed(final KeyEvent event) {
        super.keyPressed(event);
        character.keyPressed(event);
    }
    
    @Override
    public void keyReleased(final KeyEvent event) {
        super.keyReleased(event);
        character.keyReleased(event);
    }
    
}
