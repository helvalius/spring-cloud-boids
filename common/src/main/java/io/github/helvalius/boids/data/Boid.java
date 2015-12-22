package io.github.helvalius.boids.data;


import lombok.Data;
import lombok.NonNull;
import lombok.ToString;

@Data
@ToString
public class Boid {
    @NonNull private Vector position;
    @NonNull private Vector velocity;

    public void move(){
        position = position.add(velocity);
    }

    public void limitedVelocity(Vector change, double maxSpeed){
        velocity = velocity.add(change);
        if(velocity.norm() > maxSpeed){
            velocity = VectorMath.normToUnit(maxSpeed,velocity);
        }

    }

    public boolean isInDistance(Boid b, double distance){
        return VectorMath.sub(this.getPosition(), b.getPosition()).norm() < distance;
    }
}
