package io.github.helvalius.boids.boid;

import io.github.helvalius.boids.data.Boid;
import io.github.helvalius.boids.data.Vector;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


public interface IBoidService {
    @RequestMapping(path = "/boid", method = RequestMethod.GET)
    Boid boid();

    @RequestMapping(path = "/boid", method = RequestMethod.POST)
    Boid updateBoid(@RequestBody Boid boid);

    @RequestMapping(path = "/move", method=RequestMethod.POST)
    Boid move(Vector change);
}
