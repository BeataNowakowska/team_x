package virtual.friend;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: SG0897546
 * Date: 3/3/2016
 * Time: 12:44 PM
 */
public class RandomNumberGenerator {

    protected int generateRandomNumber(){
        Random random = new Random();
        return random.nextInt(100);
    }
}
