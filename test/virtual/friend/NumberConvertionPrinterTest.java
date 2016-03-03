package virtual.friend;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: SG0897546
 * Date: 3/3/2016
 * Time: 11:52 AM
 */
public class NumberConvertionPrinterTest  {

    SystemConsoleStub stub;
    NumberConvertionPrinter numberConvertionPrinter;

    @Before
    public void before(){
        stub = new SystemConsoleStub();
        numberConvertionPrinter = new NumberConvertionPrinter(stub) {
            protected int generateRandomNumber() {
                return 23;
            }
        };
    }

    @Test
    public void generateRandomNumber() {
        int result = numberConvertionPrinter.generateRandomNumber();
        Assert.assertEquals(result, 23);
    }

    @Test
    public void shouldConvertToBinary() {

        int resultNumber = numberConvertionPrinter.generateRandomNumber();
        String result = numberConvertionPrinter.convertDecimalToBinary(resultNumber);

        Assert.assertEquals(result, "10111");
    }

    @Test
    public void shouldShowRandomBinaryNumberWrongAnswer(){

        stub.addUserAction("17");
        numberConvertionPrinter.next();
        Assert.assertEquals("Skonwertuj liczbe binarna 10111 do postaci dziesietnej", stub.getProgramResponseAtt(0));
        Assert.assertEquals("Zla odpowiedz", stub.getProgramResponseAtt(1));
        Assert.assertEquals("Poprawna odpowiedz to 23", stub.getProgramResponseAtt(2));
    }

    @Test
    public void shouldShowRandomBinaryNumberCorrectAnswer(){

        stub.addUserAction("23");
        numberConvertionPrinter.next();
        Assert.assertEquals("Skonwertuj liczbe binarna 10111 do postaci dziesietnej", stub.getProgramResponseAtt(0));
        Assert.assertEquals("Gratulacje, poprawna odpowiedz!", stub.getProgramResponseAtt(1));
    }
}