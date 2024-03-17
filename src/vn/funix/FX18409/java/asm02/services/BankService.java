package vn.funix.FX18409.java.asm02.services;

import vn.funix.FX18409.java.asm02.models.Account;
import vn.funix.FX18409.java.asm02.utils.CurrencyFormatter;

import java.util.Scanner;

import static vn.funix.FX18409.java.asm02.Asm02.bank;

public class BankService {

    private final CitizenIdService citizenIdService = new CitizenIdService();

    public void addAccountForCustomer() {
        String customerId = citizenIdService.getAndValidateCitizenIdFromUser();
        Account  newAccount = AccountService.createAccountForCustomer();
        bank.addAccount(customerId, newAccount);
        System.out.println("Them thanh cong STK " + newAccount.getAccountNumber() + " voi so du : " + CurrencyFormatter.format(newAccount.getBalance()) + " vao khach hang co ma CCCD : " + customerId );
    }

}