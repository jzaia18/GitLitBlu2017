package gitlitblu;

import java.util.ArrayList;
import java.util.List;

import processing.core.PApplet;
import processing.core.PConstants;

public class Touhou implements Displayable {
    
    private List<Bullet> bullets;
    
    private final float minX;
    private final float minY;
    private final float maxX;
    private final float maxY;
    
    private final Dodger player;
    
    public Touhou(final PApplet app) {
        bullets = new ArrayList<>();
        minX = app.width / 5;
        minY = app.height / 5;
        maxX = 4 * minX;
        maxY = 4 * minY;
        player = new Dodger((int) minX, (int) minY, (int) maxX, (int) maxY);
    }
    
    public Touhou(final int minX, final int minY, final int maxX, final int maxY) {
        bullets = new ArrayList<>();
        this.minX = minX;
        this.minY = minY;
        this.maxX = maxX;
        this.maxY = maxY;
        player = new Dodger(minX, minY, maxX, maxY);
    }
    
    public void clear() {
        bullets = new ArrayList<>();
    }
    
    @Override
    public void display(final PApplet app) {
        app.rect(minX, minY, maxX - minX, maxY - minY);
        createAtTop();
        for (final Bullet bullet : bullets) {
            bullet.display(app);
        }
        player.display(app);
    }
    
    public void update(final PApplet app) {
        for (int i = 0; i < bullets.size(); i++) {
            final Bullet bullet = bullets.get(i);
            if (PApplet.dist(bullet.x, bullet.y, player.x, player.y) < (player.size + bullet.size)
                    / 2) {
                System.exit(0); //REPLACE
            }
            bullet.update(app);
            if (bullet.x < minX || bullet.x > maxX || bullet.y < minY || bullet.y > maxY) {
                bullets.remove(i--);
            }
        }
    }
    
    protected void populateAtTop(int amount) {
        while (amount-- >= 0) {
            bullets.add(new Bullet((float) Math.random() * (maxX - minX) + minX,
                    (float) Math.random() * minY / 2 + minY, PConstants.PI / 2));
        }
    }
    
    protected void createAtTop() {
        if (Math.random() * 30 < 1) {
            bullets.add(new Bullet((float) Math.random() * (maxX - minX) + minX,
                    (float) Math.random() * minY / 2 + minY, PConstants.PI / 2));
        }
    }
    
    public void keyPressed(final Keys keys) {
        player.keys = keys;
    }
    
}
