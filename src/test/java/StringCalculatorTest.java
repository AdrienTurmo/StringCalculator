import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    @Test
    public void should_return_zero_for_an_empty_string() throws Exception {
        String numbers = "";

        int result = StringCalculator.add(numbers);

        assertThat(result).isEqualTo(0);
    }
}