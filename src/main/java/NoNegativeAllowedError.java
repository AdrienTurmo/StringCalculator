public class NoNegativeAllowedError extends Exception{

    private String negativeNumbers = "";
    
    public NoNegativeAllowedError(String[] faultyNumbers) {
        for (String number : faultyNumbers) {
            if (number.contains("-")) {
                negativeNumbers += number+",";
            }
        }
        negativeNumbers = negativeNumbers.substring(0,negativeNumbers.length()-1);
    }

    public String getMessage() {
        return negativeNumbers;
    }
}
