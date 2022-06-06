package me.dio.academia.digital.entity.form;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AvaliacaoFisicaUpdateForm {


  @Positive(message = "O Peso não pode ser negativo.")
  private Double peso;


  @Positive(message = "A altura não pode ser negativa.")
  @DecimalMin(value = "150", message = "'${ValidatedValue}' precisa ser no mínimo {value}")
  private Double altura;
}
