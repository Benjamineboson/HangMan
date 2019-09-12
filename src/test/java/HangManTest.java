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
        Assert.assertArrayEquals(expected,testObject.newGame());
    }

   @Test
    public void testEnterUserLetter (){
        String test = "x";
        String expected = testObject.enterUserLetter(test);
        Assert.assertEquals(expected,testObject.getGuessedLetters().toString());
    }


    @Test
    public void test_Word_To_Guess_Content(){
        String expected = "";
        String actual = testObject.wordToGuessContent();
        Assert.assertEquals(expected,actual);
    }

}
