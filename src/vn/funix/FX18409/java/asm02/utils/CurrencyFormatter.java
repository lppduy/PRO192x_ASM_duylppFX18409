package vn.funix.FX18409.java.asm02.utils;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyFormatter {
    public static String format(double amount) {
        Locale local = new Locale("en", "US");
        String pattern = "###,###.##";
        DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getNumberInstance(local);

        decimalFormat.applyPattern(pattern);

        return decimalFormat.format(amount) + "₫";
    }
}