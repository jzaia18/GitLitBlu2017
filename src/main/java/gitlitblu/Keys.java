package gitlitblu;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import processing.event.KeyEvent;

/**
 * 
 * 
 * @author Khyber Sen
 */
public class Keys {
    
    private final Map<Integer, KeyEvent> keysPressed = new HashMap<>();
    
    public Keys() {}
    
    public void keyPressed(final KeyEvent event) {
        keysPressed.put(event.getKeyCode(), event);
    }
    
    public void keyReleased(final KeyEvent event) {
        keysPressed.remove(event.getKeyCode());
    }
    
    public Collection<KeyEvent> keysPressed() {
        return keysPressed.values();
    }
    
}
