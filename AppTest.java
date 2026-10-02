import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class AppTest {

    @Test 
    public void testGuessTooLow(){
        Game game = new Game();

        boolean result = game.isValidGuess(-1);

        Assertions.assertEquals(false, result);
    }

    @Test 
    public void testGuessTooHigh(){
        Game game = new Game();

        boolean result = game.isValidGuess(1001);
        
        Assertions.assertEquals(false, result);
    }

    @Test
    public void testGuessEven(){
        Game game = new Game();

        boolean result = game.isValidGuess(500);
        
        Assertions.assertEquals(false, result);
    }
    
    @Test
    public void testGuessValid(){
        Game game = new Game();

        boolean result = game.isValidGuess(3);
        
        Assertions.assertEquals(true, result);
    }
}
