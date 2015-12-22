package io.github.helvalius.boids.boid.rule;

import io.github.helvalius.boids.boid.IRule;
import io.github.helvalius.boids.data.Boid;
import io.github.helvalius.boids.data.Vector;
import io.github.helvalius.boids.data.VectorMath;

import java.util.List;

public class Separation implements IRule {
    private final double DISTANCE;

    public Separation(double distance) {
        this.DISTANCE = distance;
    }

    @Override
    public Vector consider(Boid b, List<Boid> flock) {
        final Vector change = Vector.zero();
        flock
            .stream()
            .filter(otherBoid -> !otherBoid.equals(b))
            .filter(otherBoid -> otherBoid.isInDistance(b,DISTANCE))
            .forEach(otherBoid -> {
                change.subtract( VectorMath.sub(otherBoid.getPosition(), b.getPosition()));
            });


        return change.div(8);
    }
}
