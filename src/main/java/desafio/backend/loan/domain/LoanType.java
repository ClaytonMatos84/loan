package desafio.backend.loan.domain;

import lombok.Getter;

@Getter
public enum LoanType {
    PERSONAL(4),
    GUARANTEED(3),
    CONSIGNMENT(2);

    private final int rate;

    LoanType(int rate) {
        this.rate = rate;
    }
}
