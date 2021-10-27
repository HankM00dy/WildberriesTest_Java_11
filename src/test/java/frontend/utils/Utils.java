package frontend.utils;

public class Utils {

    public Utils() {

    }

    public static String getLettersOnly(String value) {
        String result = value.replaceAll("[^a-zA-Zа-яА-Я]", "");
        return result;
    }

    public static String getDigitsOnly(String value) {
        String result = value.replaceAll("[^\\d]", "");
        return result;
    }

    public static String toUpperCaseFirstLetter(String value) {
        return value.length() > 1 ? value.substring(0, 1).toUpperCase() + value.substring(1) : value.toUpperCase();
    }

    public static String getPhoneFormattedRussian(String phone, boolean hasPlus, boolean hasBracket, boolean hasDash) {
        String result = "";
        phone = phone.replaceAll("[\\D]", "");
        if (hasPlus) {
            result = "+";
        }
        result = result + phone.substring(0, 1) + " ";
        if (hasBracket) {
            result = result + "(" + phone.substring(1, 4) + ") ";
        } else {
            result = result + phone.substring(1, 4) + " ";
        }
        if (hasDash) {
            result = result + phone.substring(4, 7) + "-" + phone.substring(7, 9) + "-" + phone.substring(9, 11);
        } else {
            result = result + phone.substring(4, 7) + " " + phone.substring(7, 9) + " " + phone.substring(9, 11);
        }
        return result;
    }
}
