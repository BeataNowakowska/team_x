package virtual.friend;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class QuotesCreatorTest {

    private QuotesCreator creator;
    private String frame = "";

    @Before
    public void setUp() throws Exception {
        creator = new QuotesCreator();
        StringBuilder sb = new StringBuilder();
        for (int i=0; i< QuotesCreator.FRAMESIZE; i++) {
            sb.append(QuotesCreator.SEPARATOR);
        }
        frame =  sb.toString();
    }

    @Test
    public void createQuote() {
        //given
        String quote = "Hello world, guys...";
        String author = "John Kowalski";

        //when
        String result = creator.createQuote(quote, author);

        //then
        Assert.assertEquals(frame + "\n" + quote + "\n       " + author + "\n" + frame, result);
    }


    @Test
    public void createQuoteWithLongerAuthor() {
        //given
        String quote = "Hello world";
        String author = "John Kowalski";

        //when
        String result = creator.createQuote(quote, author);

        //then
        Assert.assertEquals(frame + "\n" + quote + "\n" + author + "\n" + frame, result);
    }

}