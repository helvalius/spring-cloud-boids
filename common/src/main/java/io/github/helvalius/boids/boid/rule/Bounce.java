package io.github.helvalius.boids.boid.rule;

import io.github.helvalius.boids.boid.IRule;
import io.github.helvalius.boids.data.Boid;
import io.github.helvalius.boids.data.Vector;

import java.util.List;

public class Bounce implements IRule {
    private final int MAXX,MAXY, MINX,MINY;
    private final double BOUNCE_SPEED;

    public Bounce(int MAXX, int MAXY, int MINX, int MINY, double BOUNCE_SPEED) {
        this.MAXX = MAXX;
        this.MAXY = MAXY;
        this.MINX = MINX;
        this.MINY = MINY;
        this.BOUNCE_SPEED = BOUNCE_SPEED;
    }


    @Override
    public Vector consider(Boid b, List<Boid> flock) {
        final Vector change = Vector.zero();

        if(b.getPosition().x() > MAXX){
            change.x(-BOUNCE_SPEED);
        } else if (b.getPosition().x()< MINX){
            change.x(BOUNCE_SPEED);
        }

        if(b.getPosition().y()>MAXY){
            change.y(-BOUNCE_SPEED);
        } else if (b.getPosition().y()<MINY){
            change.y(BOUNCE_SPEED);
        }

        return change;
    }
}
