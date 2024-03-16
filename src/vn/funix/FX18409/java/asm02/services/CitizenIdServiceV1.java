package vn.funix.FX18409.java.asm02.services;

import vn.funix.FX18409.java.asm01.model.BirthPlace;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CitizenIdServiceV1 extends CitizenIdService { //  This class is for ASM01

    public void processCitizenId() {
        String citizenId = getValidCitizenId();
        if (citizenId != null) {
            handleCitizenIdFunctions(citizenId);
        }
    }

    private String getValidCitizenId() {
        Scanner sc = new Scanner(System.in);
        String citizenId;
        String birthPlace;
        boolean citizenIdNumberCheck;
        do {
            System.out.print("Vui long nhap CCCD:  ");
            citizenId = sc.next();
            birthPlace = BirthPlace.getBirthPlace(citizenId);
            citizenIdNumberCheck = checkCitizenIdNumber(citizenId);

            if (citizenId.length() != CITIZEN_ID_LENGTH || birthPlace.equals(INVALID_BIRTH_PLACE) || !citizenIdNumberCheck) {
                System.out.print("So CCCD khong hop le. Vui long nhap lai hoac 'No' de thoat: ");
                String input = sc.next();
                if (input.equalsIgnoreCase("No")) {
                    return null;
                }
            }
        } while (citizenId.length() != CITIZEN_ID_LENGTH || birthPlace.equals(INVALID_BIRTH_PLACE) || !citizenIdNumberCheck);

        return citizenId;
    }

    private void handleCitizenIdFunctions(String citizenId) {
        Scanner sc = new Scanner(System.in);
        int citizenIdFunctionCode = -1; // Initialize to a default value
        do {
            try {
                System.out.println("     | 1. Kiem tra noi sinh");
                System.out.println("     | 2. Kiem tra tuoi, gioi tinh");
                System.out.println("     | 3. Kiem tra so ngau nhien");
                System.out.println("     | 0. Thoat");
                System.out.print("Chuc nang:  ");
                citizenIdFunctionCode = sc.nextInt();

                // Check if the function code is valid
                if (citizenIdFunctionCode < 0 || citizenIdFunctionCode > 3) {
                    System.out.println("Nhap chuc nang khong chinh xac, vui long nhap lai!");
                } else {
                    switch (citizenIdFunctionCode) {
                        case 1:
                            System.out.println("Noi sinh: " +BirthPlace.getBirthPlace(citizenId));
                            break;
                        case 2:
                            checkAgeAndGender(citizenId);
                            break;
                        case 3:
                            checkRandomNumber(citizenId);
                            break;
                        case 0:
                            break;
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Nhap sai. Vui long nhap so tu 0 den 3.");
                sc.next(); // consume the invalid input
            }
        } while (citizenIdFunctionCode != 0);
    }

    // This method checks if the citizen ID is a number
    private boolean checkCitizenIdNumber(String citizenId) {
        boolean isValid = true;
        for (int i = 0; i < citizenId.length(); i++) {
            String s = "";
            s += citizenId.charAt(i);
            try {
                Integer.parseInt(s);
                isValid = true;
            } catch (NumberFormatException e) {
                isValid = false;
                break;
            }
        }
        return isValid;
    }

    private void checkAgeAndGender(String citizenId) {
        String genderCodeStr = "";
        genderCodeStr +=  citizenId.charAt(3);
        int genderCode = Integer.parseInt(genderCodeStr);
        String gender = "";

        String ageCode = "";
        ageCode += citizenId.charAt(4);
        ageCode += citizenId.charAt(5);
        int age = Integer.parseInt(ageCode);

        // Determine the gender
        if (genderCode == 0 || genderCode == 2 || genderCode == 4 || genderCode == 6 || genderCode == 8) gender = "Nam";
        else gender = "Nu";

        // Determine the age
        if (genderCode == 0 || genderCode == 1) age += 1900;
        else if (genderCode == 2 || genderCode == 3) age += 2000;
        else if (genderCode == 4 || genderCode == 5) age += 2100;
        else if (genderCode == 6 || genderCode == 7) age += 2200;
        else if (genderCode == 8 || genderCode == 9) age += 2300;

        System.out.println("Gioi tinh: " + gender + " | " + age);
    }

    private void checkRandomNumber(String citizenId) {
        String randomNumberStr = "";
        for (int i = 6 ; i <= 11; i++) {
            randomNumberStr += citizenId.charAt(i);
        }
        System.out.println("So ngau nhien: " + randomNumberStr);
    }

}