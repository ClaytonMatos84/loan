package desafio.backend.loan.domain.dto;

import desafio.backend.loan.domain.States;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record UserDto(@NotBlank String name,
                      @NotNull @Min(1) int age,
                      @NotBlank @Pattern(regexp = "\\d{3}.\\d{3}.\\d{3}-\\d{2}") String cpf,
                      @NotNull @Min(0) Long income,
                      States location) {
}
