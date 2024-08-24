package br.com.renanschmitt.medium.jpa_calculated_field.dtos;

import java.time.LocalDate;

public record PersonRequestBody(String firstName, String lastName, LocalDate birthDate) {}
