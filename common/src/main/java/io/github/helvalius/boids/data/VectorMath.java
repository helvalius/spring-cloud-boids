package io.github.helvalius.boids.data;

public class VectorMath {

    public static Vector add(Vector v1, Vector v2) {
        double x = v1.x() + v2.x();
        double y = v1.y() + v2.y();
        return Vector.with(x,y);
    }

    public static Vector sub(Vector v1, Vector v2) {
        double x = v1.x() - v2.x();
        double y = v1.y() - v2.y();
        return Vector.with(x, y);
    }


    public static Vector normToUnit(double unit, Vector vector){
        return vector.div(vector.norm()).mult(unit);
    }

}
