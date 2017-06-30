import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

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
    public void should_return_ten_when_passing_ten_as_string() throws Exception {
        String numbers = "10";

        int result = StringCalculator.add(numbers);

        assertThat(result).isEqualTo(10);
    }

    @Test
    public void should_return_fifty_when_passing_fifty_as_string() throws Exception {
        String numbers = "50";

        int result = StringCalculator.add(numbers);

        assertThat(result).isEqualTo(50);
    }

    @Test
    public void should_return_one_when_passing_one_and_zero() throws Exception {
        String numbers = "1,0";

        int result = StringCalculator.add(numbers);

        assertThat(result).isEqualTo(1);
    }

    @Test
    public void should_return_one_when_passing_zero_and_one() throws Exception {
        String numbers = "0,1";

        int result = StringCalculator.add(numbers);

        assertThat(result).isEqualTo(1);
    }

    @Test
    public void should_return_two_when_passing_one_and_one() throws Exception {
        String numbers = "1,1";

        int result = StringCalculator.add(numbers);

        assertThat(result).isEqualTo(2);
    }

    @Test
    public void should_return_three_when_passing_one_one_and_one() throws Exception {
        String numbers = "1,1,1";

        int result = StringCalculator.add(numbers);

        assertThat(result).isEqualTo(3);

    }

    @Test
    public void should_return_six_when_passing_one_two_and_three_with_a_new_line() throws Exception {
        String numbers = "1\n2,3";

        int result = StringCalculator.add(numbers);

        assertThat(result).isEqualTo(6);
    }

    @Test
    public void should_return_two_when_passing_one_and_one_with_a_semicolon() throws Exception {
        String numbers = "//;\n1;1";

        int result = StringCalculator.add(numbers);

        assertThat(result).isEqualTo(2);
    }

    @Test(expected = NoNegativeAllowedError.class)
    public void should_return_a_negative_not_allowed_error() throws Exception {
        String numbers = "-1";

        StringCalculator.add(numbers);
    }

    @Test
    public void should_return_a_negative_not_allowed_error_and_return_concerned_numbers() throws Exception {
        String numbers = "-2";
        try {
            StringCalculator.add(numbers);
        } catch (NoNegativeAllowedError e) {
            assertThat(e.getMessage()).isEqualTo("-2");
        }
    }

    @Test
    public void should_return_a_negative_not_allowed_error_and_return_all_negative_numbers() throws Exception {
        String numbers = "-2,3,-5,-6";
        try {
            StringCalculator.add(numbers);
        } catch (NoNegativeAllowedError e) {
            assertThat(e.getMessage()).isEqualTo("-2,-5,-6");
        }
    }
}