package desafio.backend.loan.controller;

import desafio.backend.loan.domain.dto.CustomerLoanDto;
import desafio.backend.loan.domain.dto.UserDto;
import desafio.backend.loan.service.LoanService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/customer-loans")
public class LoanController {

    private final LoanService loanService;

    @PostMapping
    public CustomerLoanDto verifyCustomerLoans(@RequestBody @Valid UserDto userDto) {
        return loanService.verifyCustomerLoans(userDto);
    }
}
