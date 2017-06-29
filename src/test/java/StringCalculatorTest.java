import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    @Test
    public void should_return_zero_for_an_empty_string() throws Exception {
        String numbers = "";

        int result = StringCalculator.add(numbers);

        assertThat(result).isEqualTo(0);
    }

    @Test
    public void should_return_one_for_one_as_string() throws Exception {
        String numbers = "1";

        int result = StringCalculator.add(numbers);

        assertThat(result).isEqualTo(1);
    }

    @Test
    public void should_return_ten_when_passed_ten_as_string() throws Exception {
        String numbers = "10";

        int result = StringCalculator.add(numbers);

        assertThat(result).isEqualTo(10);
    }

    @Test
    public void should_return_fifty_when_passed_fifty_as_string() throws Exception {
        String numbers = "50";

        int result = StringCalculator.add(numbers);

        assertThat(result).isEqualTo(50);
    }

    @Test
    public void should_return_zero_when_passed_comma() throws Exception {
        String numbers = ",";

        int result = StringCalculator.add(numbers);

        assertThat(result).isEqualTo(0);
    }

    @Test
    public void should_return_one_when_passed_one_and_zero() throws Exception {
        String numbers = "1,0";

        int result = StringCalculator.add(numbers);

        assertThat(result).isEqualTo(1);
    }

    @Test
    public void should_return_one_when_passed_zero_and_one() throws Exception {
        String numbers = "0,1";

        int result = StringCalculator.add(numbers);

        assertThat(result).isEqualTo(1);
    }
}