package vn.funix.FX18409.java.asm02;

import vn.funix.FX18409.java.asm02.controllers.ProgramController;
import vn.funix.FX18409.java.asm02.models.Account;
import vn.funix.FX18409.java.asm02.models.Bank;
import vn.funix.FX18409.java.asm02.models.Customer;

public class Asm02 {
    public static final Bank bank = new Bank();  //  set public because other class will use this bank object
    public static void main(String[] args) {

        // for testing the existing customer case, existing account case
        Customer existingCustomer = new Customer("Duy", "051097222222");
        bank.addCustomer(existingCustomer);
        Account existingAccount = new Account("007272", 100000);
        bank.addAccount("051097222222", existingAccount);

        ProgramController program = new ProgramController();
        program.run();  // CitizenId to test: 037153000257 (valid), 015198232323 (valid)
    }
}