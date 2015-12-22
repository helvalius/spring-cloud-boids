package io.github.helvalius.boids.boid.rule;

import io.github.helvalius.boids.boid.IRule;
import io.github.helvalius.boids.data.Boid;
import io.github.helvalius.boids.data.Vector;

import java.util.List;
import java.util.stream.Collectors;

public class Alignment implements IRule {
    private final double DISTANCE;

    public Alignment(double distance) {
        this.DISTANCE = distance;
    }

    @Override
    public Vector consider(Boid b, List<Boid> flock) {
        final Vector velocityChange = b.getVelocity().createCopy();

        List<Boid> collect = flock.stream()
                .filter(otherBoid -> !otherBoid.equals(b))
                .filter(otherBoid -> otherBoid.isInDistance(b,DISTANCE))
                .collect(Collectors.toList());

        collect.forEach( it ->  velocityChange.add(it.getVelocity()));

        int i = collect.size()+ 1;

        return velocityChange.div(i).subtract(b.getVelocity()).div(8);
    }
}
