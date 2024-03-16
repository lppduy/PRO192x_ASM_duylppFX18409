package vn.funix.FX18409.java.asm02.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Bank {
    private String id;
    private List<Customer> customers;

    public Bank() {
        this.customers = new ArrayList<>();
        this.id = String.valueOf(UUID.randomUUID());
    }

    public void addCustomer(Customer newCustomer) {
        if (!isCustomerExisted(newCustomer.getCustomerId())) {
            customers.add(newCustomer);
        }
    }

    public void addAccount(String customerId, Account newAccount) {
        for (Customer customer : customers) {
            if (customer.getCustomerId().equals(customerId)) {
                customer.addAccount(newAccount);
                break;
            }
        }
    }

    public boolean isCustomerExisted(String customerId) {
        for (Customer customer : customers) {
            if (customer.getCustomerId().equals(customerId)) {
                return true;
            }
        }
        return false;
    }

    public List<Customer> getCustomers() {
        return customers;
    }
}