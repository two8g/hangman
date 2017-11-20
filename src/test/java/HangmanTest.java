import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HangmanTest {
    private Hangman hangman;

    @Before
    public void setUp() throws Exception {
        hangman = new Hangman();
    }

    @Test
    public void should_game_start() {
        //give
        String word = "WORD";
        //when
        hangman.start(word);
        //then
        Assert.assertEquals(12, hangman.tries());
        Assert.assertEquals(4, hangman.length());
        Assert.assertEquals("AEIOU", hangman.used());
        Assert.assertEquals("_O__", hangman.view());
        Assert.assertEquals(word, hangman.solution());
    }

    @Test
    public void should_game_start_2() {
        //give
        String word = "HELLO";
        //when
        hangman.start(word);
        //then
        Assert.assertEquals(12, hangman.tries());
        Assert.assertEquals(5, hangman.length());
        Assert.assertEquals("AEIOU", hangman.used());
        Assert.assertEquals("_E__O", hangman.view());
        Assert.assertEquals(word, hangman.solution());
    }

    @Test
    public void should_try_correct() {
        //give
        String word = "WORD";
        hangman.start(word);
        //when
        boolean correct = hangman.tryChar('W');
        //then
        Assert.assertTrue(correct);
        Assert.assertEquals(12, hangman.tries());
        Assert.assertEquals("AEIOUW", hangman.used());
        Assert.assertEquals("WO__", hangman.view());
    }

    @Test
    public void should_try_incorrect() {
        //give
        String word = "WORD";
        hangman.start(word);
        //when
        boolean incorrect = hangman.tryChar('A');
        //then
        Assert.assertFalse(incorrect);
        Assert.assertEquals(11, hangman.tries());
        Assert.assertEquals("AEIOUA", hangman.used());
        Assert.assertEquals("_O__", hangman.view());
    }

    @Test
    public void should_win() {
        //give
        String word = "WORD";
        hangman.start(word);
        //when
        hangman.tryChar('W');
        hangman.tryChar('D');
        hangman.tryChar('R');
        //then
        Assert.assertTrue(hangman.win());
        Assert.assertEquals(12, hangman.tries());
        Assert.assertEquals("AEIOUWDR", hangman.used());
        Assert.assertEquals(word, hangman.view());
    }

    @Test
    public void should_game_over() {
        //give
        String word = "WORD";
        hangman.start(word);
        //when
        for (int i = 0; i < 12; i++) {
            hangman.tryChar('A');
        }
        //then
        Assert.assertTrue(hangman.gameOver());
        Assert.assertEquals(0, hangman.tries());
    }
}
