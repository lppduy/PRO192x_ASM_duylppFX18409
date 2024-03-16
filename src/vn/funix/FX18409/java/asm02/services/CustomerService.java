package vn.funix.FX18409.java.asm02.services;

import java.util.Scanner;

public class CustomerService {

    private final CitizenIdServiceV2 citizenIdService = new CitizenIdServiceV2();

    public  void addCustomer() {
        Scanner sc = new Scanner(System.in);

        // Enter customer name and customerId
        System.out.println("Nhap ten khach hang: ");
        String customerName = sc.next();
        System.out.println("Nhap so CCCD: ");
        String customerId = sc.next();

        boolean isValid = citizenIdService.validateCitizenId(customerId);
        System.out.println(isValid);

    }
}
