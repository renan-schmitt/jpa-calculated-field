package br.com.renanschmitt.medium.jpa_calculated_field.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Formula;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Person {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String firstName;
  private String lastName;

  @Column(name = "birth_date")
  private LocalDate birthDate;

  @Formula(
      "year(now()) - year(birth_date) - "
          + "CASE "
          + " WHEN month(now()) < month(birth_date)"
          + " OR ( month(now()) = month(birth_date) AND day(now()) < day(birth_date)) "
          + " THEN 1 "
          + " ELSE 0 "
          + "END")
  private Integer age;
}
