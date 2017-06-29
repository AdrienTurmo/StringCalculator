public class StringCalculator {

    public static int add(String numbers) {
        if (numbers.equals("") || numbers.equals(",")) {
            return 0;
        }

        String[] numbersTable = numbers.split(",");

        if (numbersTable.length == 1) {
            return stringToInt(numbers);
        }
        if (numbersTable[0].equals("0")) {
            return stringToInt(numbersTable[1]);
        }
        if (numbersTable[1].equals("0")) {
            return stringToInt(numbersTable[0]);
        }
        return 0;
    }

    private static int stringToInt(String number) {
        char[] digits = number.toCharArray();
        int intNumber = 0;
        int powerOfTen = 1;
        for (int index = digits.length - 1; index >= 0; index--, powerOfTen *= 10) {
            intNumber += Character.getNumericValue(digits[index]) * powerOfTen;
        }

        return intNumber;
    }
}
