package com.betrybe.fitness.service;

import com.betrybe.fitness.database.FakeFitnessDatabase;
import com.betrybe.fitness.dto.WorkoutCreationDto;
import com.betrybe.fitness.dto.WorkoutDto;
import com.betrybe.fitness.model.Workout;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Classe FitnesseService
 */
@Service
public class FitnessService implements FitnessServiceInterface{
  private FakeFitnessDatabase fakeFitnessDatabase;

  /**
   * Construtor da classe.
   * @param fakeFitnessDatabase
   */
  @Autowired
  public FitnessService(FakeFitnessDatabase fakeFitnessDatabase){
    this.fakeFitnessDatabase = fakeFitnessDatabase;
  }
  @Override
  public WorkoutDto saveWorkout(WorkoutCreationDto newWorkoutDto) {
    Workout newWorkout = new Workout();
    newWorkout.setName(newWorkoutDto.name());
    newWorkout.setRepetitions(newWorkoutDto.repetitions());
    newWorkout.setSecretTechnique(newWorkoutDto.secretTechnique());

    Workout workout = fakeFitnessDatabase.saveWorkout(newWorkout);

    return new WorkoutDto(workout.getId(),
        workout.getName(), workout.getRepetitions());
  }

  @Override
  public Optional<WorkoutDto> getWorkout(Long id) {
    Optional<Workout> workoutOptional = fakeFitnessDatabase.getWorkout(id);

    if (workoutOptional.isEmpty()) {
      return Optional.empty();
    }
    Workout workout = workoutOptional.get();
    WorkoutDto workoutDto = new WorkoutDto(workout.getId(),
        workout.getName(), workout.getRepetitions());

    return Optional.of(workoutDto);

  }

  @Override
  public List<WorkoutDto> getAllWorkouts() {
    return null;
  }
}
