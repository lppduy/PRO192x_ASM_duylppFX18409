package vn.funix.FX18409.java.asm01.model;

import java.util.HashMap;
import java.util.Map;

public class BirthPlace {
    private static final Map<String, String> CITY_CODES = new HashMap<>();

    static {
        CITY_CODES.put("001", "Ha Noi");
        CITY_CODES.put("002", "Ha Giang");
        CITY_CODES.put("004", "Cao Bang");
        CITY_CODES.put("006", "Bac Kan");
        CITY_CODES.put("008", "Tuyen Quang");
        CITY_CODES.put("010", "Lao Cai");
        CITY_CODES.put("011", "Dien Bien");
        CITY_CODES.put("012", "Lai Chau");
        CITY_CODES.put("014", "Son La");
        CITY_CODES.put("015", "Yen Bai");
        CITY_CODES.put("017", "Hoa Binh");
        CITY_CODES.put("019", "Thai Nguyen");
        CITY_CODES.put("020", "Lang Son");
        CITY_CODES.put("022", "Quang Ninh");
        CITY_CODES.put("024", "Bac Giang");
        CITY_CODES.put("025", "Phu Tho");
        CITY_CODES.put("027", "Vinh Phuc");
        CITY_CODES.put("030", "Hai Duong");
        CITY_CODES.put("031", "Hai Phong");
        CITY_CODES.put("032", "Ho Chi Minh");
        CITY_CODES.put("033", "Hung Yen");
        CITY_CODES.put("034", "Thai Binh");
        CITY_CODES.put("035", "Ha Nam");
        CITY_CODES.put("036", "Nam Dinh");
        CITY_CODES.put("037", "Ninh Binh");
        CITY_CODES.put("038", "Thanh Hoa");
        CITY_CODES.put("040", "Nghe An");
        CITY_CODES.put("042", "Ha Tinh");
        CITY_CODES.put("044", "Quang Binh");
        CITY_CODES.put("045", "Quang Tri");
        CITY_CODES.put("046", "Thua Thien Hue");
        CITY_CODES.put("048", "Da Nang");
        CITY_CODES.put("049", "Quang Nam");
        CITY_CODES.put("051", "Quang Ngai");
        CITY_CODES.put("052", "Binh Dinh");
        CITY_CODES.put("054", "Phu Yen");
        CITY_CODES.put("056", "Khanh Hoa");
        CITY_CODES.put("058", "Ninh Thuan");
        CITY_CODES.put("060", "Binh Thuan");
        CITY_CODES.put("062", "Kon Tum");
        CITY_CODES.put("064", "Gia Lai");
        CITY_CODES.put("066", "Dak Lak");
        CITY_CODES.put("067", "Dak Nong");
        CITY_CODES.put("068", "Lam Dong");
        CITY_CODES.put("070", "Binh Phuoc");
        CITY_CODES.put("072", "Tay Ninh");
        CITY_CODES.put("074", "Binh Duong");
        CITY_CODES.put("075", "Dong Nai");
        CITY_CODES.put("077", "Ba Ria - Vung Tau");
        CITY_CODES.put("079", "Long An");
        CITY_CODES.put("080", "Dong Thap");
        CITY_CODES.put("082", "An Giang");
        CITY_CODES.put("083", "Kien Giang");
        CITY_CODES.put("084", "Can Tho");
        CITY_CODES.put("086", "Ben Tre");
        CITY_CODES.put("087", "Vinh Long");
        CITY_CODES.put("089", "Tra Vinh");
        CITY_CODES.put("091", "Soc Trang");
        CITY_CODES.put("092", "Bac Lieu");
        CITY_CODES.put("093", "Hau Giang");
        CITY_CODES.put("094", "Ca Mau");
        CITY_CODES.put("095", "Bac Lieu");
        CITY_CODES.put("096", "Ca Mau");
    }

    public static String getBirthPlace(String citizenId) {
        String birthPlaceCode = "";
        if(citizenId.length() == 12) {
            birthPlaceCode = citizenId.substring(0, 3);
        }

        return CITY_CODES.getOrDefault(birthPlaceCode, "None");
    }
}