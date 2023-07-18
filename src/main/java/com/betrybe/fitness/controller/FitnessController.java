package com.betrybe.fitness.controller;

import com.betrybe.fitness.dto.WorkoutDto;
import com.betrybe.fitness.service.FitnessService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fitness")
public class FitnessController implements FitnessControllerInterface {

  private FitnessService service;
  @Autowired
  public FitnessController(FitnessService service) {
    this.service = service;
  }

  @GetMapping
  public String getRoot() {
    return "Boas vindas à API de Fitness!";
  }

  @GetMapping("/workouts/{id}")
  public ResponseEntity<WorkoutDto> getWorkout(@PathVariable Long id) {
    Optional<WorkoutDto> workoutDto = service.getWorkout(id);
    if (workoutDto.isEmpty()) {
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok(workoutDto.get());
  }

}
