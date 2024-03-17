package vn.funix.FX18409.java.asm02.services;

import vn.funix.FX18409.java.asm02.models.Customer;

import java.util.Scanner;

import static vn.funix.FX18409.java.asm02.Asm02.bank;
public class CustomerService {

    private final CitizenIdService citizenIdService = new CitizenIdService();

    public void addCustomer() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhap ten khach hang: ");
        String customerName = sc.next();

        String customerId = citizenIdService.getAndValidateCitizenIdFromUser();
        if (customerId == null) return;

        // add new customer to bank
        Customer newCustomer = new Customer(customerName, customerId);
        bank.addCustomer(newCustomer);
        System.out.println("Da them khach hang " + customerId + " vao danh sach");
    }

    public void displayCustomers() {
        System.out.println("+----------+--------------------+----------+-----------------+");
        for (int i = 0; i < bank.getCustomers().size(); i++) {
            bank.getCustomers().get(i).displayInformation();
            System.out.println("+----------+--------------------+----------+-----------------+");
        }
    }

    public void findCustomerByCitizenId() {
        System.out.println("findCustomerByCitizenId");
    }

    public void findCustomerByName() {
        System.out.println("findCustomerByName");
    }


}