package vn.funix.FX18409.java.asm01;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class AuthenticationService {

    private static final Random RANDOM = new Random();
    private static Scanner sc = new Scanner(System.in);

    private static int generateAuthenticationCode() {
        return 100 + RANDOM.nextInt(900);
    }

    private static int getConfirmationCode(int authenticationCode) {
        int confirmationCode = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.println("Nhap ma xac thuc: "  + authenticationCode);
                confirmationCode = sc.nextInt();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Ma xac thuc khong dung. Vui long thu lai." );
                sc.next(); // consume the invalid input
            }
        }
        return confirmationCode;
    }

    private static void validateConfirmationCode(int authenticationCode) {
        int confirmationCode = getConfirmationCode(authenticationCode);
        while (confirmationCode != authenticationCode) {
            System.out.println("Ma xac thuc khong dung. Vui long thu lai." );
            confirmationCode = getConfirmationCode(authenticationCode);
        }
    }

    public static void authenticate() {
        int authenticationCode = generateAuthenticationCode();
        validateConfirmationCode(authenticationCode);
    }
}