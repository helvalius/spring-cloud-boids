package io.github.helvalius.boids.boid.rule;

import io.github.helvalius.boids.boid.IRule;
import io.github.helvalius.boids.data.Boid;
import io.github.helvalius.boids.data.Vector;
import io.github.helvalius.boids.data.VectorMath;

import java.util.List;
import java.util.stream.Collectors;

public class Cohesion implements IRule {
    private final double DISTANCE;

    public Cohesion(double distance) {
        this.DISTANCE = distance;
    }

    @Override
    public Vector consider(Boid b, List<Boid> flock) {
        final Vector change = b.getPosition().createCopy();

        List<Boid> collect = flock.stream()
                .filter(otherBoid -> !otherBoid.equals(b))
                .filter(otherBoid -> otherBoid.isInDistance(b,DISTANCE))
                .collect(Collectors.toList());

        collect.forEach( it -> change.add(it.getPosition()) );

        int i = collect.size()+ 1;

        return change.div(i).subtract(b.getPosition()).div(100);
    }
}
