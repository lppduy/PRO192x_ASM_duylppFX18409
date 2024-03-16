package vn.funix.FX18409.java.asm02.services;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class AuthenticationService {

    private static final String ALPHANUMERIC_CHARACTERS =  "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private final Random RANDOM = new Random();
    private Scanner sc = new Scanner(System.in);

    public void authenticate() {
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.println("Chon che do bao mat: ");
                System.out.println("1. EASY");
                System.out.println("2. HARD");
                int mode = sc.nextInt();
                if (mode == 1) {
                    String authenticationCode = generateAuthenticationCode();
                    validateConfirmationCode(authenticationCode);
                    validInput = true;
                } else if (mode == 2) {
                    String authenticationCode = generateHardAuthenticationCode();
                    validateConfirmationCode(authenticationCode);
                    validInput = true;
                } else {
                    System.out.println("Che do khong hop le. Vui long thu lai.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Nhap sai. Vui long nhap so 1 hoac 2.");
                sc.next(); // consume the invalid input
            }
        }
    }

    private String generateAuthenticationCode() {
        return String.valueOf(100 + RANDOM.nextInt(900));
    }

    private String generateHardAuthenticationCode() {
        StringBuilder securityCode = new StringBuilder(6);
        for (int i = 0; i < 6; i++) {
            int index = RANDOM.nextInt(ALPHANUMERIC_CHARACTERS.length());
            char randomChar = ALPHANUMERIC_CHARACTERS.charAt(index);
            securityCode.append(randomChar);
        }
        return securityCode.toString();
    }

    private String getConfirmationCode(String authenticationCode) {
        String confirmationCode = "";
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.println("Nhap ma xac thuc: "  + authenticationCode);
                confirmationCode = sc.next();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Ma xac thuc khong dung. Vui long thu lai." );
                sc.next(); // consume the invalid input
            }
        }
        return confirmationCode;
    }

    private void validateConfirmationCode(String authenticationCode) {
        String confirmationCode = getConfirmationCode(authenticationCode);
        while (!confirmationCode.equals(authenticationCode)) {
            System.out.println("Ma xac thuc khong dung. Vui long thu lai." );
            confirmationCode = getConfirmationCode(authenticationCode);
        }
    }

}