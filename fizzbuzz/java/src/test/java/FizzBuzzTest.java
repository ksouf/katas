import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static com.tngtech.java.junit.dataprovider.DataProviders.$;
import static com.tngtech.java.junit.dataprovider.DataProviders.$$;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(DataProviderRunner.class)
public class FizzBuzzTest {

    private FizzBuzz fizzBuzz;

    @Before
    public void setup() {
        fizzBuzz = new FizzBuzz();
    }

    @DataProvider
    public static Object[][] provideSameValue() {
        return $$($(1, "1"), $(2, "2"), $(4, "4"));
    }

    @Test
    @UseDataProvider("provideSameValue")
    public void should_return_the_same_value(int input, String output) throws Exception {
        assertThat(fizzBuzz.process(input)).isEqualToIgnoringWhitespace(output);
    }

    @DataProvider
    public static Object[][] provideFizz() {
        return $$($(3), $(6));
    }

    @Test
    @UseDataProvider("provideFizz")
    public void should_return_fizz(int input) throws Exception {
        assertThat(fizzBuzz.process(input)).isEqualToIgnoringWhitespace("fizz");
    }

    @DataProvider
    public static Object[][] provideBuzz() {
        return $$($(10), $(5));
    }

    @Test
    @UseDataProvider("provideBuzz")
    public void should_return_buzz(int input) throws Exception {
        assertThat(fizzBuzz.process(input)).isEqualToIgnoringWhitespace("buzz");
    }

    @DataProvider
    public static Object[][] provideFizzBuzz() {
        return $$($(15), $(30));
    }

    @Test
    @UseDataProvider("provideFizzBuzz")
    public void should_return_fizz_buzz(int input) throws Exception {
        assertThat(fizzBuzz.process(input)).isEqualToIgnoringWhitespace("fizzbuzz");
    }
}