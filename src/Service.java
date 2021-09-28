import java.util.Arrays;
import java.util.Scanner;

public class Service {

    public static String[] readFromConsole() {
        String[] array = new String[3];
        Scanner scanner = new Scanner(System.in);
        array[0] = scanner.next();
        array[1] = scanner.next();
        array[2] = scanner.next();
        scanner.close();
        return array;
    }

    // true - арабские, false - римские

    public static boolean check(String[] array) throws Exception {
        String[] roman = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "XI", "X"};
        String[] arabic = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        String first = array[0];
        String second = array[2];
        if (Arrays.asList(roman).contains(first) && Arrays.asList(roman).contains(second)) {
            return false;
        } else if (Arrays.asList(arabic).contains(first) && Arrays.asList(arabic).contains(second)) {
            return true;
        } else {
            throw new Exception("Некорректные данные на входе");
        }
    }

    public static String calculate(boolean isArabic, String[] expression) throws Exception {
        int result;
        int first;
        int second;

        if (isArabic) {
            first = Integer.parseInt(expression[0]);
            second = Integer.parseInt(expression[2]);
        } else {
            first = Converter.romanToArabic(expression[0]);
            second = Converter.romanToArabic(expression[2]);
        }

        switch (expression[1]) {
            case ("+"):
                result = first+second;
                break;
            case ("-"):
                result = first-second;
                break;
            case ("*"):
                result = first*second;
                break;
            case ("/"):
                result = first/second;
                break;
            default:
                throw new Exception("Некорректный ввод действия");
        }
        if (isArabic) return Integer.toString(result);
        else return Converter.arabicToRoman(result);
    }

}