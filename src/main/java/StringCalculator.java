public class StringCalculator {

    public static int add(String numbers) throws NoNegativeAllowedError {
        String[] numbersTable = formatting(numbers);

        if (numbers.contains("-")) {
            throw new NoNegativeAllowedError(numbersTable);
        }

        int sum = 0;
        for (String aNumber : numbersTable) {
            int number = stringToInt(aNumber);
            if (number <= 1000) {
                sum += number;
            }
        }

        return sum;
    }

    private static String[] formatting(String numbers) {
        String splitter = ",";
        if (!numbers.contains(",") && numbers.contains("\n")) {
            String[] lines = numbers.split("\n");
            splitter = lines[0].replace("/","").replace("[","").replace("]","");
            numbers = "";
            for (int index = 1 ; index < lines.length ; index++) {
                numbers += lines[index];
            }
        }
        numbers = numbers.replace("\n",",");
        numbers = numbers.replace(splitter,",");
        return numbers.split(",");
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
