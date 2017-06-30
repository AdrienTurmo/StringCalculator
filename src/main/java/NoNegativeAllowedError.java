public class NoNegativeAllowedError extends Exception{

    private String negativeNumbers = "";
    
    public NoNegativeAllowedError(String[] faultyNumbers) {
        for (String number : faultyNumbers) {
            if (number.contains("-")) {
                negativeNumbers+=number;
            }
        }
    }

    public String getMessage() {
        return negativeNumbers;
    }
}
