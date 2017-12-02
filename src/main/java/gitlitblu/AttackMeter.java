package gitlitblu;

import processing.core.PApplet;

public class AttackMeter {
    
    public Slider slider;
    public float hitLeft;
    public float hitRight;
    public Boolean hit;
    
    public AttackMeter(final PApplet app) {
        slider = new Slider();
        hitLeft = app.width / 4;
        hitRight = app.width - app.width / 4;
    }
    
    public void display(final PApplet app) {
        app.rect(0, app.height / 3, app.width, app.height / 3); //creates meter
        app.fill(0, 255, 0);
        app.rect(hitLeft, app.height / 3, app.width / 2, app.height / 3);
        //creates hit rang	e in meter, centered
        slider.display(app);
    }
    
    public void go() {
        slider.slide();
        hit = slider.hit;
        //        System.out.println(hit);
    }
    
    public void keyPressed(final Keys keys) {
        slider.keys = keys;
    }
}