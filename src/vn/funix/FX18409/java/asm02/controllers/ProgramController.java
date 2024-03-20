package vn.funix.FX18409.java.asm02.controllers;

import vn.funix.FX18409.java.asm02.services.BankService;
import vn.funix.FX18409.java.asm02.services.CustomerService;
import vn.funix.FX18409.java.asm02.services.UserInterfaceService;

public class ProgramController {

    private final UserInterfaceService userInterfaceService = new UserInterfaceService();
    private final CustomerService customerService = new CustomerService();
    private final BankService bankService = new BankService();

    public void run() {
        while (true) {
            int choice = userInterfaceService.displayMenuAndGetChoice();
            handleChoice(choice);
        }
    }

    private void handleChoice(int choice) {
        switch (choice) {
            case 1:
                customerService.addCustomer(); // TODO: Add feature 'add Account' for new customer
                break;
            case 2:
                bankService.addAccountForCustomer(); // TODO: handle 2 separate case: new and existing customer
                break;
            case 3:
                customerService.displayCustomers();
                break;
            case 4:
                customerService.findCustomerByCitizenId();
                break;
            case 5:
                customerService.findCustomerByName();
                break;
            case 0:
                System.out.println("Cam on ban da su dung dich vu cua chung toi!");
                System.exit(0);
        }
    }

}