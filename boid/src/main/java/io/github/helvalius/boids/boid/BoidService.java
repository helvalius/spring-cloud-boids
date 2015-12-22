package io.github.helvalius.boids.boid;

import io.github.helvalius.boids.data.Boid;
import io.github.helvalius.boids.data.Vector;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoidService implements IBoidService {
    private Boid boid = null;

    @Override
    @RequestMapping(path = "/boid", method = RequestMethod.GET)
    public Boid boid(){
        return boid;
    }

    @Override
    @RequestMapping(path = "/boid", method = RequestMethod.POST)
    public Boid updateBoid(@RequestBody Boid boid){
        this.boid = boid;
        return boid;
    }

    @Override
    @RequestMapping(path = "/move", method=RequestMethod.POST)
    public Boid move(Vector change){
        boid.setVelocity(change);
        boid.move();
        return boid;
    }


}
