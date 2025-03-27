package desafio.backend.loan.domain.dto;

import desafio.backend.loan.domain.Loan;

import java.util.List;

public record CustomerLoanDto(String customer,
                              List<Loan> loans) {
}
