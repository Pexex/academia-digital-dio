package me.dio.academia.digital.entity.form;

import java.time.LocalDate;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlunoUpdateForm {

  @Size(min = 3, max = 50, message = "'${ValidatedValue}' de ter entre {min} e {max} caracteres.")
  private String nome;


  @Size(min = 3, max = 50, message = "'$ValidatedValue}' deve ter entre {min} e {max} caracteres.")
  private String bairro;

  @Past(message = "Data '${ValidatedValue}' inválida.")
  private LocalDate dataDeNascimento;
}
