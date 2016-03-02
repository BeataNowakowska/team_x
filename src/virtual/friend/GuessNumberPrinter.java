package virtual.friend;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: SG0897546
 * Date: 3/2/2016
 * Time: 10:15 AM
 */
public class GuessNumberPrinter extends FunctionalityRunner {

    public GuessNumberPrinter(ConsoleBox box) {
        super(box);
    }

    @Override
    public void next() {

        int number = generateRandomNumber();

        console.write("Pomyslalem jakos liczbe z zakresu 0 - 100.");

        while(true) {
            console.write("Jaka liczbe pomyslalem?");
            String answer = console.readline();

            if ("q".equals(answer)) {
                break;
            }

            int guessedNumber = Integer.parseInt(answer);

            if (number == guessedNumber) {
                console.write("Zgadles pomyslalme liczbe " + number);
                break;
            } else if (number > guessedNumber) {
                console.write("Podales zbyt mala liczbe");
            } else {
                console.write("Podales zbyt duza liczbe");
            }
        }
    }

    protected int generateRandomNumber(){
        Random random = new Random();
        return random.nextInt(100);
    }


}
