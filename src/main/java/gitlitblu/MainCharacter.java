package gitlitblu;

import java.util.List;

import processing.core.PApplet;
import processing.event.KeyEvent;

/**
 * 
 * 
 * @author Khyber Sen
 */
public class MainCharacter extends Sprite {
    
    private boolean frozen = false;
    
    private float speed;
    
    public MainCharacter(final PApplet app, final String imgName,
            final float x, final float y) {
        super(app, imgName, x, y);
        speed = app.width * app.height * (1.0f / 50000);
    }
    
    public void setSpeed(final float speed) {
        this.speed = speed;
    }
    
    public void freeze(final boolean freeze) {
        frozen = freeze;
    }
    
    public void keysPressed(final Keys keys) {
        //        System.out.println(event.getKey());
        //        System.out.println(x + ", " + y);
        if (frozen) {
            return;
        }
        for (final KeyEvent event : keys.keysPressed()) {
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
    }
    
    public void checkNearEnemies(final List<Enemy> enemies) {
        frozen = false;
        for (final Enemy enemy : enemies) {
            if (enemy.inRadius(x, y)) {
                frozen = true;
                enemy.speak();
            }
        }
    }
    
}
