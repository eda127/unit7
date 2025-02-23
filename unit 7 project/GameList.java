import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class GameList { 
    File file = new File("placeholder"); //change placeholder to the file location of superBowls.txt
    Scanner text = new Scanner(file);
    public ArrayList<Game> superBowls;
    

    // constructor
    public GameList(File file) throws Exception {
        superBowls = new ArrayList<Game>();
        //skipping the first line
        String line = text.nextLine();

        while (text.hasNextLine()) {
            //Formatting->
            //I,"January 15, 1967",Green Bay Packers,35–10,Kansas City Chiefs,Los Angeles Memorial Coliseum,"Los Angeles, California","61,946",Norm Schachter
            line = text.nextLine();

            int numeralPos = line.indexOf(",");
            String numeral = line.substring(0, numeralPos);
            
            int nothing = line.indexOf(",", numeralPos + 1);
                
            int datePos = line.indexOf(",", nothing + 1);
            int year = Integer.valueOf(line.substring(nothing+2, datePos-1));
                
            int winnerPos = line.indexOf(",", datePos + 1);
            String winner = line.substring(datePos+1, winnerPos);
                
            int scorePos = line.indexOf(",", winnerPos + 1);
            String score = line.substring(winnerPos+1, scorePos);
                
            int loserPos = line.indexOf(",", scorePos+1);
            String loser = line.substring(scorePos+1, loserPos);
                
            int stadiumPos = line.indexOf(",", loserPos+1);
            
            int cityPos = line.indexOf(",", stadiumPos+1);
            String city = line.substring(stadiumPos+2, cityPos);
                         
            Game newGame = new Game(numeral, year, city, winner, loser, score); 
            superBowls.add(newGame);
            
        }
    }

    //gets # of wins a team has
    public int numWins(String team) {
        int wins = 0;
        for (Game game : superBowls) {
            if (game.getWinner().equals(team)) wins++;
        }
        return wins;
    }

    //sorts the list by year played
    public void sortByYear() {
            for (int i = 0; i < superBowls.size() -1; i++) {
            Game currentGame = superBowls.get(i);
            int minIndex = i;
            int minYear = currentGame.getYear();

            for (int j = i+1; j < superBowls.size(); j++) {
                Game nextGame = superBowls.get(j);
                if (nextGame.getYear() < minYear) {
                    minYear = nextGame.getYear();
                    minIndex = j;
                }
            }

            //swapping
            Game temp = superBowls.get(i);
            superBowls.set(i, superBowls.get(minIndex));
            superBowls.set(minIndex, temp);
            
        }
    }


    //sorts list alp
    public void sortByWinningTeam() {
        for (int i = 0; i < superBowls.size() -1; i++) {
            Game currentGame = superBowls.get(i);
            String currentGameWinner = currentGame.getWinner();
            int mostWins = numWins(currentGameWinner);
            int mostWinsIndex = i;

            for (int j = i+1; j < superBowls.size(); j++) {
                Game nextGame = superBowls.get(j);
                String nextGameWinner = nextGame.getWinner();
                int nextGameWins = numWins(nextGameWinner);

                if (nextGameWins > mostWins) {
                    mostWinsIndex = j;
                    mostWins = nextGameWins;
                    currentGameWinner = nextGameWinner;
                }
                // if they have same numWins, the first in the alphabet is first
                // mostWinsIndex is now the one that comes first alphabetically
                else if (nextGameWins == mostWins) {
                    if (nextGameWinner.compareTo(currentGameWinner) < 0) {
                        mostWinsIndex = j;
                        currentGameWinner = nextGameWinner;
                    }
                } 
            }

            // swapping
            Game temp = superBowls.get(i);
            superBowls.set(i, superBowls.get(mostWinsIndex));
            superBowls.set(mostWinsIndex, temp);
        }
    }

    public void sortByPointDifferential() {
        for (int i = 0; i < superBowls.size() -1; i++) {
            Game currentGame = superBowls.get(i);
            int biggestDifferenceIndex = i;
            
            String totalPoints = currentGame.getScore();
            int winnerScore = Integer.valueOf(totalPoints.substring(0, totalPoints.indexOf("–")));
            int loserScore = Integer.valueOf(totalPoints.substring(totalPoints.indexOf("–")+1, totalPoints.length()));
            int pointDifference = winnerScore - loserScore;

            for (int j = i+1; j < superBowls.size(); j++) {
                Game nextGame = superBowls.get(j);

                String nextTotalPoints = nextGame.getScore();
                int nextWinnerScore = Integer.valueOf(nextTotalPoints.substring(0, nextTotalPoints.indexOf("–")));
                int nextLoserScore = Integer.valueOf(nextTotalPoints.substring(nextTotalPoints.indexOf("–")+1, nextTotalPoints.length()));
                int nextPointDifference = nextWinnerScore - nextLoserScore;

                if (pointDifference < nextPointDifference) {
                    biggestDifferenceIndex = j;
                    pointDifference = nextPointDifference;
                }                
                
            }
            // swapping
            Game temp = superBowls.get(i);
            superBowls.set(i, superBowls.get(biggestDifferenceIndex));
            superBowls.set(biggestDifferenceIndex, temp);
        }
    }


}