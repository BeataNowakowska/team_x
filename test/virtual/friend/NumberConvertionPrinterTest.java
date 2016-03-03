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
    RandomNumberStub numberGenerator;
    NumberConvertionPrinter numberConvertionPrinter;
    private static final int RANDOM_NUMBER = 23;
    private static final String RANDOM_NUMBER_BINARY = "10111";

    @Before
    public void before(){
        stub = new SystemConsoleStub();
        numberGenerator = new RandomNumberStub(RANDOM_NUMBER);
        numberConvertionPrinter = new NumberConvertionPrinter(stub, numberGenerator);
    }

    @Test
    public void generateRandomNumber() {
        int result = numberConvertionPrinter.generateRandomNumber();
        Assert.assertEquals(result, RANDOM_NUMBER);
    }

    @Test
    public void shouldConvertToBinary() {

        int resultNumber = numberConvertionPrinter.generateRandomNumber();
        String result = numberConvertionPrinter.convertDecimalToBinary(resultNumber);

        Assert.assertEquals(result, RANDOM_NUMBER_BINARY);
    }

    @Test
    public void shouldShowRandomBinaryNumberWrongAnswer(){

        stub.addUserAction("17");
        numberConvertionPrinter.next();
        Assert.assertEquals("Skonwertuj liczbe binarna " + RANDOM_NUMBER_BINARY + " do postaci dziesietnej", stub.getProgramResponseAtt(0));
        Assert.assertEquals("Zla odpowiedz", stub.getProgramResponseAtt(1));
        Assert.assertEquals("Poprawna odpowiedz to " + RANDOM_NUMBER, stub.getProgramResponseAtt(2));
    }

    @Test
    public void shouldShowRandomBinaryNumberCorrectAnswer(){

        stub.addUserAction("" + RANDOM_NUMBER);
        numberConvertionPrinter.next();
        Assert.assertEquals("Skonwertuj liczbe binarna " + RANDOM_NUMBER_BINARY + " do postaci dziesietnej", stub.getProgramResponseAtt(0));
        Assert.assertEquals("Gratulacje, poprawna odpowiedz!", stub.getProgramResponseAtt(1));
    }
}