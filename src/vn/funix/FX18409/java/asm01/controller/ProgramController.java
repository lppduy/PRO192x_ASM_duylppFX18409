package vn.funix.FX18409.java.asm01.controller;

import vn.funix.FX18409.java.asm01.service.UserInterfaceService;
import vn.funix.FX18409.java.asm01.service.AuthenticationService;
import vn.funix.FX18409.java.asm01.service.CitizenIdService;

public class ProgramController {

    private UserInterfaceService userInterfaceService = new UserInterfaceService();
    private AuthenticationService authenticationService = new AuthenticationService();
    private CitizenIdService citizenIdService = new CitizenIdService();

    // This method runs the program
    public void run() {
        // This method runs the program
        int choice = userInterfaceService.displayMenuAndGetChoice();

        // If the user chooses option 1, authenticate the user and process the citizen ID
        if (choice == 1) {
            authenticationService.authenticate();
            citizenIdService.processCitizenId();
        }
    }

}