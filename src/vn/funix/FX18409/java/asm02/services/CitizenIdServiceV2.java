package vn.funix.FX18409.java.asm02.services;

import vn.funix.FX18409.java.asm02.utils.BirthPlace;

public class CitizenIdServiceV2  {

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
        return !birthPlace.equals("None");
    }

    private boolean validateAgeAndGender(String citizenId) {
        return true;
    }
    private boolean validateRandomNumber(String citizenId) {
        return true;
    }






}