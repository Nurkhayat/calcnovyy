import java.util.Arrays;

class Converter {
    //1. Преобразовать в арабские  String -> int   "V" ==> 5  (RomanToNumber)
    // 2. Произвести действие с int
    //3. Преобразовать обратно в арабские -> int -> String

    static String[] romansToTen = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
    static int[] ArabicToTen = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    public static int RomanToNumber(String roman) { //ИЗУЧИТЬ ИСКЛЮЧЕНИЯ
        try {
            if (roman.equals("I"))
                return 1;
            else if (roman.equals("II"))
                return 2;
            else if (roman.equals("III"))
                return 3;
            else if (roman.equals("IV"))
                return 4;
            else if (roman.equals("V"))
                return 5;
            else if (roman.equals("VI"))
                return 6;
            else if (roman.equals("VII"))
                return 7;
            else if (roman.equals("VIII"))
                return 8;
            else if (roman.equals("IX"))
                return 9;
            else if (roman.equals("X"))
                return 10;
        } catch (Exception e) {
            System.out.println("Введите число от I до X");
        }
        return -1;
    }

    public static String ArabicToRoman(int ArabicNum) {
        String[] roman = {"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV",
                "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};

        final String s = roman[ArabicNum];
        return s;
    }

    public static boolean isRoman(String input) {
        for (String x : romansToTen) {
            if (x.equals(input)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isArabic(String input) {
        if (Arrays.asList(romansToTen).contains(input)) {throw new RuntimeException("Используются разные системы исчисления");}
        int intArabic = Integer.parseInt(input);
            if (intArabic >= 1 && intArabic <= 10) {
                for (int x : ArabicToTen) {
                    if (x == intArabic) {
                        return true;
                    }
                }
            } else {
                throw new RuntimeException("Некорректное число. Введите число от 1 до 10"); }
            return false;
        }

}
