package virtual.friend;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: SG0897546
 * Date: 3/3/2016
 * Time: 12:48 PM
 */
public class RandomNumberStub extends RandomNumberGenerator {

    private int randomNumber;

    public RandomNumberStub(int randomNumber) {
        this.randomNumber = randomNumber;
    }

    protected int generateRandomNumber(){
        return randomNumber;
    }


}
