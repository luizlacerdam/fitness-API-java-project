package com.betrybe.fitness.service;

import com.betrybe.fitness.database.FakeFitnessDatabase;
import com.betrybe.fitness.dto.WorkoutCreationDto;
import com.betrybe.fitness.dto.WorkoutDto;
import java.util.List;
import java.util.Optional;
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
  public FitnessService(FakeFitnessDatabase fakeFitnessDatabase){
    this.fakeFitnessDatabase = fakeFitnessDatabase;
  }
  @Override
  public WorkoutDto saveWorkout(WorkoutCreationDto newWorkoutDto) {
    return null;
  }

  @Override
  public Optional<WorkoutDto> getWorkout(Long id) {
    return Optional.empty();
  }

  @Override
  public List<WorkoutDto> getAllWorkouts() {
    return null;
  }
}
