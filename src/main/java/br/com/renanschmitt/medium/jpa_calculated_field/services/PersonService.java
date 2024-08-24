package br.com.renanschmitt.medium.jpa_calculated_field.services;

import br.com.renanschmitt.medium.jpa_calculated_field.dtos.PersonDTO;
import br.com.renanschmitt.medium.jpa_calculated_field.dtos.PersonRequestBody;
import br.com.renanschmitt.medium.jpa_calculated_field.model.Person;
import br.com.renanschmitt.medium.jpa_calculated_field.repositories.PersonRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonService {
  private final PersonRepository personRepository;

  public void save(PersonRequestBody personRequestBody) {
    var person = new Person();
    person.setFirstName(personRequestBody.firstName());
    person.setLastName(personRequestBody.lastName());
    person.setBirthDate(personRequestBody.birthDate());

    personRepository.save(person);
  }

  public List<PersonDTO> getAll() {
    return personRepository.findAll().stream().map(this::toDto).toList();
  }

  private PersonDTO toDto(Person person) {
    return PersonDTO.builder()
        .firstName(person.getFirstName())
        .lastName(person.getLastName())
        .birthDate(person.getBirthDate())
        .age(person.getAge())
        .build();
  }
}
