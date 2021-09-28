public class Main {

    public static void main(String[] args) throws Exception {

        String[] expression = Service.readFromConsole(); // получили с консоли данные
        boolean isArabic = Service.check(expression); // проверяем
        String result = Service.calculate(isArabic, expression);
        System.out.println(result);
    }
}
