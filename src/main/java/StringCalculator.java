public class StringCalculator {

    public static int add(String numbers) {
        if (numbers.equals("") || numbers.equals(",")) {
            return 0;
        }

        String[] numbersTable = numbers.split(",");

        if (numbersTable.length == 1) {
            return stringToInt(numbers);
        }
        return stringToInt(numbersTable[0])+stringToInt(numbersTable[1]);
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
