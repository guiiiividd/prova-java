package com.fatec.city.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CityRequest(@NotBlank(message = "Nome não pode ser nulo!") String nome, @NotBlank(message = "Estado não pode ser nulo!") String estado, @NotNull(message = "População não pode ser nulo!") Integer populacao, @NotNull(message = "PIB não pode ser nulo!") Double pib) {}
