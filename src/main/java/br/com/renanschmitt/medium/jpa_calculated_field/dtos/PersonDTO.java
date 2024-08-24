package br.com.renanschmitt.medium.jpa_calculated_field.dtos;

import java.time.LocalDate;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PersonDTO {
  private final String firstName;
  private final String lastName;
  private final LocalDate birthDate;
  private final Integer age;
}
