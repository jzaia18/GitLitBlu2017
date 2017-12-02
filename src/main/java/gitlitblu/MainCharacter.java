package gitlitblu;

import java.util.List;

import processing.event.KeyEvent;

/**
 * 
 * 
 * @author Khyber Sen
 */
public class MainCharacter extends Sprite {
    
    private boolean frozen = false;
    
    private float speed;
    
    private Enemy currentEnemy = null;
    
    public MainCharacter(final GitLitBlu app, final String imgName,
            final float x, final float y) {
        super(app, imgName, x, y);
        speed = app.width * app.height * (1.0f / 80000);
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
        // all edges are walls,
        // except if you move to the right, you go to the next screen
        
        if (x < 0) {
            x += speed;
        } else if (x > app.width) {
            x -= app.width;
            app.nextScreen();
        }
        
        if (y < 0) {
            y += speed;
        } else if (y > app.height) {
            y -= speed;
        }
    }
    
    public void checkNearEnemies(final List<Enemy> enemies) {
        if (currentEnemy != null) {
            frozen = currentEnemy.isSpeaking();
            if (!frozen && !currentEnemy.inRadius(x, y)) {
                frozen = false;
            }
            return;
        }
        
        for (final Enemy enemy : enemies) {
            if (enemy.inRadius(x, y)) {
                currentEnemy = enemy;
                enemy.speak();
                checkNearEnemies(null);
                return;
            }
        }
    }
    
}
