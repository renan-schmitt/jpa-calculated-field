package br.com.renanschmitt.medium.jpa_calculated_field.repositories;

import br.com.renanschmitt.medium.jpa_calculated_field.model.Person;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends ListCrudRepository<Person, Long> {}
