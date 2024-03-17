package vn.funix.FX18409.java.asm02;

import vn.funix.FX18409.java.asm02.controllers.ProgramController;
import vn.funix.FX18409.java.asm02.models.Account;
import vn.funix.FX18409.java.asm02.models.Bank;
import vn.funix.FX18409.java.asm02.models.Customer;

public class Asm02 {
    public static final Bank bank = new Bank();  //  set public because other class will use this bank object
    public static void main(String[] args) {

        // for testing
        Customer customer1 = new Customer("David", "037456789111");
        bank.addCustomer(customer1);
        Account account1 = new Account("123456", 1000000);
        bank.addAccount("037456789111", account1);

        Customer customer2 = new Customer("Even", "037456789112");
        bank.addCustomer(customer2);
        Account account2 = new Account("234567", 10000000);
        Account account3 = new Account("345678", 2000000);
        bank.addAccount("037456789112", account2);
        bank.addAccount("037456789112", account3);

        ProgramController program = new ProgramController();
        program.run();  // CitizenId to test: 037153000257 (valid), 015198232323 (valid)
    }
}