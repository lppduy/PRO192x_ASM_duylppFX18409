package vn.funix.FX18409.java.asm02.controllers;

import vn.funix.FX18409.java.asm02.services.CustomerService;
import vn.funix.FX18409.java.asm02.services.UserInterfaceService;

public class ProgramController {

    private final UserInterfaceService userInterfaceService = new UserInterfaceService();
    private final CustomerService customerService = new CustomerService();
    // This method runs the program
    public void run() {
        int choice = userInterfaceService.displayMenuAndGetChoice();
        handleChoice(choice);
    }

    private void handleChoice(int choice) {
        switch (choice) {
            case 1:
                customerService.addCustomer();
                break;
            case 2:
                System.out.println("Chuc nang 2");
                break;
            case 3:
                System.out.println("Chuc nang 3");
                break;
            case 4:
                System.out.println("Chuc nang 4");
                break;
            case 5:
                System.out.println("Chuc nang 5");
                break;
            case 0:
                System.out.println("Cam on ban da su dung dich vu cua chung toi!");
                break;
        }
    }

}