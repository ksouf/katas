import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WordCountTest {

    @Test
    public void oneWordTest() {
        String singleWord = "boom";
        WordCount wordCount = new WordCount();

        assertThat(wordCount.count(singleWord)).isEqualTo("boom 1");
    }

    @Test
    public void oneAnotherWordTest() {
        String singleWord = "bim";
        WordCount wordCount = new WordCount();

        assertThat(wordCount.count(singleWord)).isEqualTo("bim 1");
    }

    @Test
    public void twoWordTest() {
        String singleWord = "boom,boom";
        WordCount wordCount = new WordCount();

        assertThat(wordCount.count(singleWord)).isEqualTo("boom 2");
    }


    @Test
    public void multiWordTest() {
        String singleWord = "boom,bim";
        WordCount wordCount = new WordCount();

        assertThat(wordCount.count(singleWord)).isEqualTo("boom 1\nbim 1");
    }

    @Test
    public void multiWord2Test() {
        String singleWord = "boom,bim,boom,boom";
        WordCount wordCount = new WordCount();

        assertThat(wordCount.count(singleWord)).isEqualTo("boom 3\nbim 1");
    }
}