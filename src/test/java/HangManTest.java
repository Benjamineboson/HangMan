import model.HangMan;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HangManTest {

    private HangMan testObject;

    @Before
    public void init(){
        testObject = new HangMan ("Testar");
    }

    @Test
    public void testNewGame (){
        char[] expected = {'_','_','_','_','_','_'};
        testObject.newGame();
        Assert.assertArrayEquals(expected,testObject.getWordToGuess());
    }

    @Test
    public void testEnterUserLetter (){
        String test = "x";
        testObject.enterUserLetter(test);
        String expected = "[x]";
        Assert.assertEquals(expected,testObject.getGuessedLetters().toString());
    }

}
