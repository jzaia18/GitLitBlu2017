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
    
    private boolean inTouhou;
    private boolean inAttack;
    
    private MainCharacter mainCharacter;
    
    private final List<Enemy> enemies = new ArrayList<>();
    
    private Touhou touhou;
    
    private AttackMeter attackMeter;
    
    public long time;
    
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
        enemies.add(new Enemy(this, "Froggit.png", 100, 100, 100));
        enemies.add(new Enemy(this, "Froggit.png", 500, 500, 100));
        enemies.get(0).setPreText(Arrays.asList("Hello"));
        touhou = new Touhou(this);
        touhou.populateAtTop(10);
    }
    
    public void nextScreen() {
        for (final Enemy enemy : enemies) {
            enemy.moveRandom();
        }
    }
    
    public void startBattle() {
        inTouhou = true;
        touhou.clear();
        time = System.currentTimeMillis();
        System.out.println("starting battle");
    }
    
    public void endBattle(final boolean hit) {
        inAttack = false;
        attackMeter = null;
        if (hit) {
            enemies.remove(mainCharacter.currentEnemy());
        } else {
            inTouhou = true;
            time = System.currentTimeMillis();
        }
        touhou = new Touhou(this);
        touhou.populateAtTop(10);
    }
    
    private void drawOverworld() {
        mainCharacter.checkNearEnemies(enemies);
        mainCharacter.display(this);
        for (final Enemy enemy : enemies) {
            enemy.display(this);
        }
        
        mainCharacter.keysPressed(keys);
        for (final Enemy enemy : enemies) {
            enemy.keysPressed(keys);
        }
    }
    
    private void drawTouhou() {
        touhou.update(this);
        touhou.display(this);
        if (System.currentTimeMillis() > time + 3000) {
            inTouhou = false;
            inAttack = true;
        }
    }
    
    private void drawAttack() {
        if (attackMeter == null) {
            attackMeter = new AttackMeter(this);
        }
        attackMeter.keyPressed(keys);
        attackMeter.display(this);
        attackMeter.go();
        if (attackMeter.hit != null) {
            endBattle(attackMeter.hit);
        }
    }
    
    @Override
    public void draw() {
        fill(150);
        clear();
        
        if (!inTouhou && !inAttack) {
            drawOverworld();
        } else if (inTouhou) {
            drawTouhou();
        } else {
            drawAttack();
        }
    }
    
    @Override
    public void keyPressed(final KeyEvent event) {
        super.keyPressed(event);
        keys.keyPressed(event);
        touhou.keyPressed(keys);
    }
    
    @Override
    public void keyReleased(final KeyEvent event) {
        super.keyReleased(event);
        keys.keyReleased(event);
    }
    
}
