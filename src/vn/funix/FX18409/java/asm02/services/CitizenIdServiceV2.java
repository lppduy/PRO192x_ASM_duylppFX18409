package vn.funix.FX18409.java.asm02.services;

import vn.funix.FX18409.java.asm02.utils.BirthPlace;

import java.util.Arrays;
import java.util.List;

import static vn.funix.FX18409.java.asm02.services.CitizenIdService.INVALID_BIRTH_PLACE;

public class CitizenIdServiceV2  {  //  This class is for ASM02

    public boolean validateCitizenId(String citizenId) {
        return validateIdFormat(citizenId) &&
                validateBirthplace(citizenId) &&
                validateAgeAndGender(citizenId) &&
                validateRandomNumber(citizenId);
    }

    private boolean validateIdFormat(String id) {
        // Check if Id.length = 12 character.
        if(id.length() != 12) return false;

        // Check if Id is Number or notNumber.
        for (int i = 0; i < id.length(); i++) {
            try {
                Integer.parseInt(String.valueOf(id.charAt(i)));
            } catch (NumberFormatException e) {
                return false;
            }
        }

        return true;
    }

    private boolean validateBirthplace(String citizenId) {
        String birthPlace = BirthPlace.getBirthPlace(citizenId);
        return !birthPlace.equals(INVALID_BIRTH_PLACE);
    }

    private boolean validateAgeAndGender(String citizenId) {
        String genderCodeStr = "";
        genderCodeStr +=  citizenId.charAt(3);
        int genderCode = Integer.parseInt(genderCodeStr);

        String birthYearCode = "";
        birthYearCode += citizenId.charAt(4);
        birthYearCode += citizenId.charAt(5);
        int birthYear = Integer.parseInt(birthYearCode);

        // Determine the gender
        List<Integer> validGenderCodes = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        boolean isValidGender = validGenderCodes.contains(genderCode);

        // Determine the birth year
        if (genderCode == 0 || genderCode == 1) birthYear += 1900;
        else if (genderCode == 2 || genderCode == 3) birthYear += 2000;
        else if (genderCode == 4 || genderCode == 5) birthYear += 2100;
        else if (genderCode == 6 || genderCode == 7) birthYear += 2200;
        else if (genderCode == 8 || genderCode == 9) birthYear += 2300;

        // Calculate the age
        int currentYear = java.time.Year.now().getValue();
        int age = currentYear - birthYear;

        // Validate the age and gender
        // For example, let's say the age should be between 18 and 150, and the gender should be valid
        return age >= 18 && age <= 150 && isValidGender;
    }

    /**
     * This method validates the last 6 digits of the citizenId to check if they form a valid random number.
     * A valid random number is defined as a number that is not a fixed string like "000000" or "123456".
     * This rule is self-imposed as the requirement did not clearly define what constitutes a valid random number.
     */
    private boolean validateRandomNumber(String citizenId) {
        String randomNumber = citizenId.substring(citizenId.length() - 6);
        return !randomNumber.equals("000000") && !randomNumber.equals("123456");
    }

}