package desafio.backend.loan.service;

import desafio.backend.loan.domain.Loan;
import desafio.backend.loan.domain.LoanType;
import desafio.backend.loan.domain.States;
import desafio.backend.loan.domain.dto.CustomerLoanDto;
import desafio.backend.loan.domain.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoanService {

    public CustomerLoanDto verifyCustomerLoans(UserDto userDto) {
        List<Loan> loans = new ArrayList<>();
        if (checkLoanPersonal(userDto)) loans.add(new Loan(LoanType.PERSONAL, LoanType.PERSONAL.getRate()));
        if (checkLoanGuaranteed(userDto)) loans.add(new Loan(LoanType.GUARANTEED, LoanType.GUARANTEED.getRate()));
        if (checkLoanConsignment(userDto)) loans.add(new Loan(LoanType.CONSIGNMENT, LoanType.CONSIGNMENT.getRate()));

        return new CustomerLoanDto(userDto.name(), loans);
    }

    private Boolean checkLoanPersonal(UserDto userDto) {
        if (userDto.income() <= 3000L) return true;
        return userDto.income() > 3000 && userDto.income() <= 5000 &&
                userDto.location().equals(States.SP)  && userDto.age() < 30;
    }

    private Boolean checkLoanGuaranteed(UserDto userDto) {
        if (userDto.income() <= 3000L) return true;
        return userDto.income() > 3000 && userDto.income() <= 5000 &&
                userDto.location().equals(States.SP) && userDto.age() < 30;
    }

    private Boolean checkLoanConsignment(UserDto userDto) {
        return userDto.income() >= 5000;
    }
}
