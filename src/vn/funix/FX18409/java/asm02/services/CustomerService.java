package vn.funix.FX18409.java.asm02.services;

import vn.funix.FX18409.java.asm02.models.Customer;

import java.util.ArrayList;
import java.util.List;
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

    public void findCustomerByCitizenId() { // searchCustomerByCCCD
        String customerId = setCustomerId();
        if (customerId != null) {
            displayCustomerByCitizenId(customerId);
        }
    }

    private String setCustomerId() {
        Scanner sc = new Scanner(System.in);
        String customerId = null;

        while (true) {
            try {
                System.out.println("+----------+--------------------+----------+");
                System.out.println("Nhap CCCD khach hang can tim (12 ky tu): ");
                customerId = sc.next();

                if (citizenIdService.validateCitizenId(customerId) && bank.isCustomerExisted(customerId)) {
                    break;
                } else {
                    System.out.println("CCCD chua chinh xac hoac khong ton tai vui long nhap lai (12 ky tu): ");
                }
            } catch (Exception e) {
                System.out.println("Co loi xay ra. Vui long thu lai.");
            }
        }

        return customerId;
    }

    private  void displayCustomerByCitizenId(String customerId) {
        for (int i = 0; i < bank.getCustomers().size(); i++) {
            if (customerId.equals(bank.getCustomers().get(i).getCustomerId())) {
                System.out.println("+----------+--------------------+----------+-----------------+");
                bank.getCustomers().get(i).displayInformation();
            }
        }
        System.out.println("+----------+--------------------+----------+-----------------+");
    }

    public void findCustomerByName() {
        Scanner sc = new Scanner(System.in);
        System.out.println("+----------+--------------------+----------+");

        // Enter customerName
        System.out.println("Nhap ten khach hang can tim: ");
        String customerName = sc.next();

        // searchCustomerByName
        List<Customer> matchedCustomers = findCustomersByName(customerName);

        if (matchedCustomers.isEmpty()) {
            System.out.println("Khong tim thay khach hang co ten : " + customerName);
        } else {
            for (Customer customer : matchedCustomers) {
                customer.displayInformation();
            }
        }

        System.out.println("+----------+--------------------+----------+-----------------+");
    }

    private List<Customer> findCustomersByName(String customerName) {
        List<Customer> matchedCustomers = new ArrayList<>();
        for (Customer customer : bank.getCustomers()) {
            if (customer.getName().toLowerCase().contains(customerName.toLowerCase())) {
                matchedCustomers.add(customer);
            }
        }
        return matchedCustomers;
    }

}