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
    
    public static void main(final String[] args) {
        PApplet.main(GitLitBlu.class.getName());
    }
    
    @Override
    public void settings() {
        size(720, 720);
    }
    
    @Override
    public void setup() {
        character = new Character(this, "Alphys.png", width * 0.5f, height * 0.5f);
    }
    
    @Override
    public void draw() {
        clear();
        character.display(this);
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
