package vn.funix.FX18409.java.asm02.controllers;

import vn.funix.FX18409.java.asm02.services.AuthenticationService;
import vn.funix.FX18409.java.asm02.services.CitizenIdService;
import vn.funix.FX18409.java.asm02.services.UserInterfaceService;

public class ProgramController {

    private UserInterfaceService userInterfaceService = new UserInterfaceService();
    private AuthenticationService authenticationService = new AuthenticationService();
    private CitizenIdService citizenIdService = new CitizenIdService();

    // This method runs the program
    public void run() {
        int choice = userInterfaceService.displayMenuAndGetChoice();
        handleChoice(choice);
    }

    private void handleChoice(int choice) {
        switch (choice) {
            case 1:
                System.out.println("Chuc nang 1");
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