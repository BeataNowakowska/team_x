package virtual.friend;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: SG0897546
 * Date: 3/3/2016
 * Time: 11:52 AM
 */
public class NumberConvertionPrinter extends FunctionalityRunner {

    int randomNumber = 0;
    String convertedRandomNumber;

    public NumberConvertionPrinter(ConsoleBox box) {
        super(box);
    }

    @Override
    public void next() {
        int resultRandomNumber = generateRandomNumber();
        convertDecimalToBinary(resultRandomNumber);
        console.write("Skonwertuj liczbe binarna " + convertedRandomNumber + " do postaci dziesietnej");

        String answer = console.readline();

        if ("q".equals(answer)) {
            return;
        }

        int guessedNumber = Integer.parseInt(answer);

        if (resultRandomNumber != guessedNumber) {
            console.write("Zla odpowiedz");
            console.write("Poprawna odpowiedz to " + resultRandomNumber);
        } else {
            console.write("Gratulacje, poprawna odpowiedz!");
        }
    }

    protected int generateRandomNumber(){
        Random random = new Random();
        randomNumber = random.nextInt(100);
        return randomNumber;
    }

    protected String convertDecimalToBinary(int number){
        convertedRandomNumber = Integer.toString(number, 2);
        return convertedRandomNumber;
    }


}
