public class Hangman {

    private int tries = 12;
    private String view;
    private String used;
    private String word;

    public Hangman() {
    }

    public void start(String word) {
        this.word = word;
        used = "AEIOU";
        updateView();
    }

    public int tries() {
        return tries;
    }

    public int length() {
        return word.length();
    }

    public String used() {
        return used;
    }

    public String view() {
        return view;
    }

    public String solution() {
        return word;
    }

    public boolean tryChar(char c) {
        used += c;
        boolean matched = isMatched(c);
        if (matched) {
            updateView();
        }
        if (!matched) {
            tries -= 1;
        }
        return matched;
    }

    private void updateView() {
        view = word.replaceAll("[^" + used + "]", "_");
    }

    private boolean isMatched(char c) {
        return word.indexOf(c) > -1;
    }

    public boolean win() {
        return true;
    }

    public boolean gameOver() {
        return tries == 0;
    }
}
