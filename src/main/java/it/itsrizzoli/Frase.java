package it.itsrizzoli;

public class Frase {
    int letterCount;
    int  wordsCount;
    String replacedString;

    public Frase(int letterCount, int wordsCount, String replacedString) {
        this.letterCount = letterCount;
        this.wordsCount = wordsCount;
        this.replacedString = replacedString;
    }

    public int getLetterCount() {
        return letterCount;
    }

    public void setLetterCount(int letterCount) {
        this.letterCount = letterCount;
    }

    public int getWordsCount() {
        return wordsCount;
    }

    public void setWordsCount(int wordsCount) {
        this.wordsCount = wordsCount;
    }

    public String getReplacedString() {
        return replacedString;
    }

    public void setReplacedString(String replacedString) {
        this.replacedString = replacedString;
    }
}
