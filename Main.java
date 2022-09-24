import java.util.Scanner;
public class Main {
    static String[] operations = {"+", "-", "/", "*"};
    static int number1;
    static int number2;
    static boolean isRoman = false;
    static boolean isArabic = false;

    static String operation;
    static String result;
    static int intResult;

    public static void main(String[] args) {
        System.out.println("Введите выражение");
        Scanner scanner = new Scanner(System.in);
        System.out.println(calc(scanner.nextLine()));
    }

    public static String calc(String input) {
        int operationIndex = -1;
        for (int i = 0; i < operations.length; i++) {
            if (input.contains(operations[i])) {
                operationIndex = i;
                break;
            }
        }
        //Если не нашли арифметического действия, завершаем программу
        if (operationIndex == -1) {
            System.out.println("Здравствуйте! ");
        }
        String[] split = input.split("[+-/*]");
        String stringNum1 = split[0].trim();
        String stringNum2 = split[1].trim();
        if (split.length > 2) { throw new RuntimeException("т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор");}
        if (Converter.isRoman(stringNum1) && Converter.isRoman(stringNum2)) {
            isRoman = true;
            number1 = Converter.RomanToNumber(stringNum1);
            number2 = Converter.RomanToNumber(stringNum2);
        } else if (Converter.isArabic(stringNum1) && Converter.isArabic(stringNum2)){
            isArabic = true;
            number1 = Integer.parseInt(stringNum1);
            number2 = Integer.parseInt(stringNum2);
        } else throw new RuntimeException("Используются разные системы исчисления");

        switch (operations[operationIndex]) {
            case "+":
                intResult = number1 + number2;
                break;
            case "-":
                intResult = number1 - number2;
                break;
            case "*":
                intResult = number1 * number2;
                break;
            case "/":
                try {
                    intResult = number1 / number2;
                } catch (Exception e) {
                    System.out.println("Нельзя делить на ноль");
                    break;
                }
                break;
            default:
                throw new IllegalArgumentException("Неверный знак операции");
        }

        if(isRoman) {
            if (intResult < 0) { throw new RuntimeException("В римской системе нет отрицательных чисел"); }
            if (intResult == 0) {throw new RuntimeException("В римской системе нет нуля");}
            result = Converter.ArabicToRoman(intResult);
        } else {
            result = String.valueOf(intResult);
        }
        return result;
    }
}
