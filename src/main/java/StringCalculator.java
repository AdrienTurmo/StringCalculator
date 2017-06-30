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
        numbers = checkForSeparator(numbers);
        numbers = numbers.replace("\n",",");
        return numbers.split(",");
    }

    private static String checkForSeparator(String numbers) {
        if (!numbers.contains(",") && numbers.contains("\n")) {

            String[] lines = numbers.split("\n");
            String[] splitters = lines[0].replace("/","").replace("]","").replace("[",",").split(",");

            numbers = reformNumbers(lines);

            numbers = replaceSplittersByComma(numbers, splitters);
        }
        return numbers;
    }

    private static String replaceSplittersByComma(String numbers, String[] splitters) {
        if (splitters.length == 1) {
            numbers = numbers.replace(splitters[0],",");
        }
        for (int index = 1 ; index < splitters.length ; index++) {
            numbers = numbers.replace(splitters[index], ",");
        }
        return numbers;
    }

    private static String reformNumbers(String[] lines) {
        String numbers = "";
        for (int index = 1 ; index < lines.length ; index++) {
            numbers += lines[index];
        }
        return numbers;
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
