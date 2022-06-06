package me.dio.academia.digital.entity.form;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AvaliacaoFisicaForm {

  @NotNull(message = "Preencha o campo corretamente.")
  @Positive(message = "O Id não pode ser negativo.")
  private Long alunoId;

  @NotNull(message = "Preencha o campo corretamente.")
  @Positive(message = "O Peso não pode ser negativo.")
  private double peso;

  @NotNull(message = "Preencha o campo corretamente.")
  @Positive(message = "A altura não pode ser negativa.")
  @DecimalMin(value = "150", message = "'${ValidatedValue}' precisa ser no mínimo {value}")
  private double altura;
}
