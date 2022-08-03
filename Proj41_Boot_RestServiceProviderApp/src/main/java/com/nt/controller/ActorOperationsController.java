package com.nt.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Actor;

@RestController
@RequestMapping("/actor")
public class ActorOperationsController {

	@GetMapping("/wish")
	public ResponseEntity<String> displayWishMessage(){
		return new ResponseEntity<>("Good Morning User...", HttpStatus.OK);
	}

	@GetMapping("/wish/{id}/{name}")
	public ResponseEntity<String> displayWishMessage(@PathVariable("id") Integer uid,
														@PathVariable String name){
		return new ResponseEntity<>("Good Morning ..."+uid+".."+name, HttpStatus.OK);
	}
	
	@PostMapping("/register")
	public ResponseEntity<String> registerActor(@RequestBody Actor actor){
		return new ResponseEntity<String>("Actor data : "+actor.toString(), HttpStatus.OK);
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<Actor>> fetchAllActors(){
		return new ResponseEntity<List<Actor>>(List.of(new Actor(101, "Raja", 25, "Hero"),
														new Actor(102, "Rahul", 26, "Hero"),
														new Actor(103,"Riya", 27, "Heroin")),
												HttpStatus.OK);
	}
}
