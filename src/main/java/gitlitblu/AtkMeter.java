package gitlitblu;

import processing.core.PApplet;


public class AtkMeter{
    public Slider slider;
    
    public AtkMeter() {
    	slider = new Slider();
    }

    public void display(PApplet app) {
        app.rect(0, (app.height / 3), app.width, (app.height / 3)); //creates meter
        app.fill(0, 255, 0);
        app.rect((app.width / 4), (app.height / 3), (app.width / 2), (app.height / 3)); 
        //creates hit range in meter, centered
        slider.display(app);
    }
    
    public void go() {
    	slider.slide();
    }
    
    public void keyPressed(Keys keys) {
    	slider.keys = keys;
    }   
}