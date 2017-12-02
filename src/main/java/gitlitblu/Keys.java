package gitlitblu;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import processing.event.KeyEvent;

/**
 * 
 * 
 * @author Khyber Sen
 */
public class Keys {
    
    private final Map<Integer, KeyEvent> keys = new HashMap<>();
    
    private boolean newKey;
    
    public Keys() {}
    
    public void keyPressed(final KeyEvent event) {
        if (event == null) {
            return;
        }
        newKey = keys.putIfAbsent(event.getKeyCode(), event) == null;
        //        System.out.println("newKey: " + newKey + " (" + event.getKey() + ")");
    }
    
    public void keyReleased(final KeyEvent event) {
        keys.remove(event.getKeyCode());
    }
    
    public Collection<KeyEvent> keysPressed() {
        return keys.values();
    }
    
    public boolean newKeyPressed() {
        return newKey;
    }
    
    public boolean anyMatch(final Function<KeyEvent, Boolean> keyEventMatcher) {
        for (final KeyEvent keyEvent : keysPressed()) {
            if (keyEventMatcher.apply(keyEvent)) {
                return true;
            }
        }
        return false;
    }
    
}
