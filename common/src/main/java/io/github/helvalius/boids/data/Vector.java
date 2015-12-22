package io.github.helvalius.boids.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;
import lombok.experimental.Accessors;

@Data
@Accessors(fluent = true)
@AllArgsConstructor(staticName = "with")
public class Vector {
    private  double x;
    private  double y;

    public Vector add(Vector v2) {
        this.x += v2.x;
        this.y += v2.y;
        return this;
    }

    public Vector subtract(Vector v2){
        this.x -= v2.x;
        this.y -= v2.y;
        return this;
    }


    public double norm() {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }


    public Vector mult(double scalar) {
        return Vector.with(scalar * this.x, scalar * this.y);
    }

    public Vector div(double scalar) {
        return Vector.with(this.x / scalar, this.y / scalar);
    }

    public static Vector zero(){
        return Vector.with(0.0,0.0);
    }

    public Vector createCopy(){
        return Vector.with(x,y);
    }




}