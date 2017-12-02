package gitlitblu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import processing.core.PApplet;
import processing.event.KeyEvent;

/**
 * 
 * 
 * @author Khyber Sen
 */
public class GitLitBlu extends PApplet {
    
    private final Keys keys = new Keys();
    
    private MainCharacter mainCharacter;
    
    private final List<Enemy> enemies = new ArrayList<>();
    
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
        mainCharacter = new MainCharacter(this, "Alphys.png", width * 0.5f, height * 0.5f);
        enemies.add(new Enemy(this, "Froggit.png", 100, 100, 200));
        enemies.get(0).setPreText(Arrays.asList("Hello"));
        //    	t = new Touhou();
        //    	t.populateAtTop(this, 10);
    }
    
    public void nextScreen() {
        for (final Enemy enemy : enemies) {
            enemy.moveRandom();
        }
    }
    
    public void startBattle() {
        System.out.println("starting battle");
        // TODO
    }
    
    @Override
    public void draw() {
        fill(150);
        clear();
        mainCharacter.checkNearEnemies(enemies);
        mainCharacter.display(this);
        for (final Enemy enemy : enemies) {
            enemy.display(this);
        }
        
        mainCharacter.keysPressed(keys);
        for (final Enemy enemy : enemies) {
            enemy.keysPressed(keys);
        }
        //        t.display(this);
    }
    
    @Override
    public void keyPressed(final KeyEvent event) {
        super.keyPressed(event);
        keys.keyPressed(event);
    }
    
    @Override
    public void keyReleased(final KeyEvent event) {
        super.keyReleased(event);
        keys.keyReleased(event);
    }
    
}
