package gitlitblu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import processing.core.PApplet;

/**
 * 
 * 
 * @author Khyber Sen
 */
public class Enemy extends Sprite {
    
    // prevent inlining
    private static final String QUESTION = "Do you want to battle? (Y/N)".toString();
    
    private final float radius;
    
    private final List<String> texts = new ArrayList<>();
    private Iterator<String> nextText;
    private String text;
    
    public Enemy(final GitLitBlu app, final String imgName, final float x, final float y,
            final float radius) {
        super(app, imgName, x, y);
        this.radius = radius;
        texts.add(QUESTION);
    }
    
    public Enemy(final GitLitBlu app, final String imgName, final float radius) {
        this(app, imgName, 0, 0, radius);
        moveRandom();
    }
    
    public void setPreText(final List<String> texts) {
        this.texts.clear();
        this.texts.addAll(texts);
        this.texts.add(QUESTION);
    }
    
    public void moveRandom() {
        x = app.random(app.width);
        y = app.random(app.height);
    }
    
    @Override
    public void display(final PApplet app) {
        super.display(app);
        if (text != null) {
            app.textSize(app.width * .05f);
            app.text(text, x, y);
            return;
        }
        if (nextText == null) {
            return;
        }
        if (!nextText.hasNext()) {
            nextText = null;
            return;
        }
        text = nextText.next();
        display(app);
    }
    
    public void keysPressed(final Keys keys) {
        if (!isSpeaking()) {
            return;
        }
        //        System.out.println("enemy keyPressed");
        // text == null signals that nextText should be used
        if (text == QUESTION) {
            //            System.out.println("question");
            if (keys.anyMatch(event -> event.getKey() == 'y')) {
                app.startBattle();
                text = null;
            } else if (keys.anyMatch(event -> event.getKey() == 'n')) {
                text = null;
            }
        } else {
            if (keys.newKeyPressed()
                    && keys.anyMatch(event -> "aswd".indexOf(event.getKey()) == -1)) {
                text = null;
                //                System.out.println("nulling text");
            }
        }
    }
    
    public void speak() {
        nextText = texts.iterator();
    }
    
    public boolean isSpeaking() {
        return nextText != null;
    }
    
    public boolean inRadius(final float x, final float y) {
        final float dx = this.x - x;
        final float dy = this.y - y;
        return dx * dx + dy * dy < radius * radius;
    }
    
}
