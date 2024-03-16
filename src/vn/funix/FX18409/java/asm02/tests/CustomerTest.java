package vn.funix.FX18409.java.asm02.tests;

import vn.funix.FX18409.java.asm02.models.Account;
import vn.funix.FX18409.java.asm02.models.Customer;

public class CustomerTest {
    public static void main(String[] args) {
        Customer customer = new Customer("FUNIX", "001215000001");

        Account account1 = new Account("123456", 1_000_000);
        Account account2 = new Account("234567", 10_000_000);
        Account account3 = new Account("345678", 100_000);

        customer.addAccount(account1);
        customer.addAccount(account2);
        customer.addAccount(account3);

        customer.displayInformation();
    }
}