package vn.funix.FX18409.java.asm02.tests;

import vn.funix.FX18409.java.asm02.models.Account;

public class AccountTest {
    public static void main(String[] args) {
        Account account = new Account();

        account.setAccountNumber("123456");
        account.setBalance(10_000_000);

        System.out.println(account.toString());
        System.out.println("Is this a premium account? " + (account.isPremiumAccount() ? "Yes" : "No"));
    }
}
