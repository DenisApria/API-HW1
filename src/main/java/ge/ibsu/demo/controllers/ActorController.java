package ge.ibsu.demo.controllers;

import ge.ibsu.demo.dto.ActorFullName;
import ge.ibsu.demo.entities.Actor;
import ge.ibsu.demo.services.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/actor")
public class ActorController {
    private final ActorService actorService;

    @Autowired
    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @RequestMapping(value = "/allActorNames", method = RequestMethod.GET,produces = {"application/json"})
    public List<ActorFullName> getAllActorNames() {
        return actorService.getAllActorNames();
    }
}
