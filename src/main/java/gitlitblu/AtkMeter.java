package gitlitblu;

import processing.core.PApplet;

public class AtkMeter{
    private float x;//init coordinates
    private float y;
    public Slider s;
    
    public AtkMeter() {
    	s = new Slider();
    }

    public void display(PApplet app) {
        app.rect(0, (app.height / 3), app.width, (app.height / 3)); //creates meter
        app.fill(0, 255, 0);
        app.rect((app.width / 4), (app.height / 3), (app.width / 2), (app.height / 3)); //creates hit range in meter, centered
        s.display(app);
    }
    
    public void go() {
    	s.slide();
    }
}