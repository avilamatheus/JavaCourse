package model.services;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService {
    OnlinePaymentService onlinePaymentService;

    public ContractService(OnlinePaymentService onlinePaymentService) {
        this.onlinePaymentService = onlinePaymentService;
    }

    public void processContract(Contract contract, Integer months) {
        double monthlyAmount = (contract.getTotalValue()/months);

        for (int i = 1; i <= months; i++) {
            double interestResult = onlinePaymentService.interest(monthlyAmount, i);
            double paymentFeeResult = onlinePaymentService.paymentFee(interestResult + monthlyAmount);
            double totalInstallmentAmount = monthlyAmount + interestResult + paymentFeeResult;

            Installment installment = new Installment(contract.getDate().plusMonths(i), totalInstallmentAmount);
            contract.addInstallment(installment);
        }
    }




}
