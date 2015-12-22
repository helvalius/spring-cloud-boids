package io.github.helvalius.boids.boid;

import io.github.helvalius.boids.boid.rule.Alignment;
import io.github.helvalius.boids.boid.rule.Bounce;
import io.github.helvalius.boids.boid.rule.Cohesion;
import io.github.helvalius.boids.boid.rule.Separation;

public class MainTest {

    public static void main(String[] args) throws InterruptedException{
        Flock f = new Flock(20,8,300,-300,300,-300);
        Screen screen = new Screen(600,600,f);

        f.addRule(new Bounce(300,300,-300,-300,8));
        f.addRule(new Separation(30));
        f.addRule(new Cohesion(60));
        f.addRule(new Alignment(30));

        while(true){
            f.update();
            screen.repaint();
            Thread.sleep(25);
        }
    }
}
