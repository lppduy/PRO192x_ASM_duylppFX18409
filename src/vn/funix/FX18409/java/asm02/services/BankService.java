package vn.funix.FX18409.java.asm02.services;

import vn.funix.FX18409.java.asm02.models.Account;
import vn.funix.FX18409.java.asm02.utils.CurrencyFormatter;

import java.util.Scanner;

import static vn.funix.FX18409.java.asm02.Asm02.bank;

public class BankService {

    private final CitizenIdService citizenIdService = new CitizenIdService();
    private final CustomerService customerService = new CustomerService();


    public void addAccountForCustomer() {
        Scanner sc = new Scanner(System.in);
        String customerId = null;
        do {
            System.out.println("Nhap ma CCCD:");
            customerId = sc.next();
            if (!citizenIdService.validateCitizenId(customerId) || !bank.isCustomerExisted(customerId)) {
                System.out.println("Khach hang voi CCCD nay khong ton tai. Vui long nhap lai.");
                continue;
            } else {
                break;
            }
        } while (true);

        Account newAccount = AccountService.createAccountForCustomer();
        bank.addAccount(customerId, newAccount);
        System.out.println("Them thanh cong STK " + newAccount.getAccountNumber() + " voi so du : " + CurrencyFormatter.format(newAccount.getBalance()) + " vao khach hang co ma CCCD : " + customerId );
    }

}