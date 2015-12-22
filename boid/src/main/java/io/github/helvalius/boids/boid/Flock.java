package io.github.helvalius.boids.boid;

import com.google.common.collect.Lists;
import io.github.helvalius.boids.data.Boid;
import io.github.helvalius.boids.data.BoidUtil;
import io.github.helvalius.boids.data.Vector;
import lombok.Getter;
import lombok.experimental.Accessors;

import java.util.List;

@Accessors(fluent = true)
public class Flock {
    @Getter private final List<Boid> flock;

    private final List<IRule> rules = Lists.newArrayList();
    private final double maxSpeed;
    public Flock(int flockSize, double maxSpeed, int maxX, int minX, int maxY, int minY ) {
        this.flock = Lists.newArrayListWithCapacity(flockSize);
        this.maxSpeed = maxSpeed;

        for(int i=0; i<flockSize; i++){
            flock.add(BoidUtil.random(maxSpeed,maxX,minX,maxY,minY));
        }
    }

    public void update(){
        flock.forEach(this::modifyVelocity);
        flock.forEach(Boid::move);
    }


    private void modifyVelocity(Boid b) {
        Vector diff = Vector.zero();
        for(IRule rule: rules){
            diff = diff.add(rule.consider(b,flock));
        }

        b.limitedVelocity(diff, maxSpeed);

    }

    public void addRule(IRule rule){
        rules.add(rule);
    }

}
