public class Game {
    private String numeral;
    private int year;
    private String location;
    private String winner;
    private String loser;
    private String score;

    // constructor
    public Game(String numeral, int year, String location, String winner, String loser, String score) {
        this.numeral = numeral;
        this.year = year;
        this.location = location;
        this.winner = winner;
        this.loser = loser;
        this.score = score;
    }

    public String getNumeral() {
        return numeral;
    }
    public int getYear() {
        return year;
    }
    public String getLocation() {
        return location;
    }
    public String getWinner() {
        return winner;
    }
    public String getLoser() {
        return loser;
    }
    public String getScore() {
        return score;
    }

    public void setNumeral(String n) {
        numeral = n;
    }
    public void setYear(int y) {
        year = y;
    }
    public void setLocation(String l) {
        location = l;
    }
    public void setWinner(String w) {
        winner = w;
    }
    public void setLoser(String l) {
        loser = l;
    }
    public void setScore(String s) {
        score = s;
    }

    public String toString() {
        return "\nSuperbowl " + numeral + ": " + winner + " defeated " + loser + "\nScore: " + score + "\nYear: " + year + "\nLocation: " + location + "\n";
    }
}
