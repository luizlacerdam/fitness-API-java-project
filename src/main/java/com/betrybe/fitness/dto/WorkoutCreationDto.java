package com.betrybe.fitness.dto;

/**
 * CreationDto classe.
 */
public record WorkoutCreationDto(
    String name,
    Integer repetitions,
    String secretTechnique
) { }
