package gitlitblu;

import processing.core.PApplet;

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
        
    }
    
    @Override
    public void setup() {
        character = new Character(this);
    }
    
    @Override
    public void draw() {
        
    }
    
}
