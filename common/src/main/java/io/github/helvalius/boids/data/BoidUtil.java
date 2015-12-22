package io.github.helvalius.boids.data;

public class BoidUtil {
   public static Boid random(double maxSpeed, int maxX, int minX, int maxY, int minY){

       double x = (Math.random()* (maxX-minX)) + minX;
       double y = (Math.random()* (maxY-minY)) + minY;

       Vector position = Vector.with(x,y);

       double minSpeed = maxSpeed * -1;
       double xVelocity = Math.random() * maxSpeed;
       double yVelocity = Math.random() * maxSpeed;

       Vector velocity = Vector.with(xVelocity,yVelocity);

       double norm = velocity.norm();
       if(norm >maxSpeed){
           velocity = VectorMath.normToUnit(norm,velocity);
       }

       return new Boid(position, velocity);
   }

}
