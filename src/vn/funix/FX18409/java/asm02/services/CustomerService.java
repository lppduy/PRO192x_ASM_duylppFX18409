package vn.funix.FX18409.java.asm02.services;

import vn.funix.FX18409.java.asm02.models.Customer;

import java.util.Scanner;

import static vn.funix.FX18409.java.asm02.Asm02.bank;
public class CustomerService {

    private final CitizenIdServiceV2 citizenIdService = new CitizenIdServiceV2();

    public  void addCustomer() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhap ten khach hang: ");
        String customerName = sc.next();

        String customerId;
        do {
            System.out.println("Nhap so CCCD: ");
            customerId = sc.next();
            if (bank.isCustomerExisted(customerId)) {
                System.out.println("Khach hang voi CCCD nay da ton tai. Vui long nhap lai.");
                continue;
            }
            if (!citizenIdService.validateCitizenId(customerId)) {
                System.out.println("So CCCD khong hop le.");
                System.out.println("Vui long nhap lai hoac nhap 'No' de thoat:");
                if ("No".equalsIgnoreCase(customerId)) return;
            } else {
                break;
            }
        } while (true);

        // add new customer to bank
        Customer newCustomer = new Customer(customerName, customerId);
        bank.addCustomer(newCustomer);
        System.out.println("Da them khach hang " + customerId + " vao danh sach");
    }

    public void displayCustomers() {
        System.out.println("displayCustomers");
    }

    public void findCustomerByCitizenId() {
        System.out.println("findCustomerByCitizenId");
    }

    public void findCustomerByName() {
        System.out.println("findCustomerByName");
    }

}