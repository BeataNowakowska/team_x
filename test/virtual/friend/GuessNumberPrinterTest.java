package virtual.friend;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: SG0897546
 * Date: 3/2/2016
 * Time: 11:02 AM
 */
public class GuessNumberPrinterTest {

    SystemConsoleStub stub;
    GuessNumberPrinter guessNumberPrinter;

    @Before
    public void before(){
        stub = new SystemConsoleStub();
        guessNumberPrinter = new GuessNumberPrinter(stub) {
            protected int generateRandomNumber(){
                return 23;
            }
        };
    }

    @Test
    public void testNext() throws Exception {
        stub.addUserAction("22");
        stub.addUserAction("24");
        stub.addUserAction("23");
        guessNumberPrinter.next();
        Assert.assertEquals("Pomyslalem jakos liczbe z zakresu 0 - 100.", stub.getProgramResponseAtt(0));
        Assert.assertEquals("Jaka liczbe pomyslalem?", stub.getProgramResponseAtt(1));
        Assert.assertEquals("Podales zbyt mala liczbe", stub.getProgramResponseAtt(2));
        Assert.assertEquals("Jaka liczbe pomyslalem?", stub.getProgramResponseAtt(3));
        Assert.assertEquals("Podales zbyt duza liczbe", stub.getProgramResponseAtt(4));
        Assert.assertEquals("Jaka liczbe pomyslalem?", stub.getProgramResponseAtt(5));
        Assert.assertEquals("Zgadles pomyslalme liczbe 23", stub.getProgramResponseAtt(6));
    }
}