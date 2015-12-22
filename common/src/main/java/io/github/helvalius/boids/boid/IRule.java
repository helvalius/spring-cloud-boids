package io.github.helvalius.boids.boid;

import io.github.helvalius.boids.data.Boid;
import io.github.helvalius.boids.data.Vector;

import java.util.List;

public interface IRule {
    Vector consider(Boid b, List<Boid> flock);
}
