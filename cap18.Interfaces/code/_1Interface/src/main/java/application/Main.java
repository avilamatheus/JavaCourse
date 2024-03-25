package application;

import model.entities.Contract;
import model.entities.Installment;
import model.services.ContractService;
import model.services.PaypalService;
import utils.DateTimeBr;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Contract contract = new Contract(8028,
                LocalDate.parse("25/06/2018", DateTimeBr.getLocalDateFormatter()),
                600.00);

        ContractService contractService = new ContractService(new PaypalService());
        contractService.processContract(contract, 3);

        System.out.println("Parcelas: ");
        for (Installment installment: contract.getInstallments()) {
            String output = installment.getDueDate().format(DateTimeBr.getLocalDateFormatter()) + " - $" + installment.getAmount();
            System.out.println(output);
        }
    }
}