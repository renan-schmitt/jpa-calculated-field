package br.com.renanschmitt.medium.jpa_calculated_field.api;

import br.com.renanschmitt.medium.jpa_calculated_field.dtos.PersonDTO;
import br.com.renanschmitt.medium.jpa_calculated_field.dtos.PersonRequestBody;
import br.com.renanschmitt.medium.jpa_calculated_field.services.PersonService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/person")
public class PersonController {
  private final PersonService personService;

  @PostMapping("/")
  @ResponseStatus(HttpStatus.CREATED)
  public void save(@RequestBody PersonRequestBody personRequestBody) {
    personService.save(personRequestBody);
  }

  @GetMapping("/")
  @ResponseBody
  public List<PersonDTO> getAll() {
    return personService.getAll();
  }
}
