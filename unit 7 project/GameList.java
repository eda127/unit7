import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class GameList { 
    File file = new File("placeholder");
    Scanner text = new Scanner(file);
    private ArrayList<Game> superBowls;
    

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
            String stadium = line.substring(loserPos+1, stadiumPos);
            
            int cityPos = line.indexOf(",", stadiumPos+1);
            String city = line.substring(stadiumPos+2, cityPos);
                
            /* useless?
            int nothing3 = line.indexOf(",", cityPos+1);
                //DEBUGGING
                System.out.println("  NOTHIG3: " + nothing3);
                pause();
            
            int peoplePos = line.indexOf(",", nothing3+1);
            String people = line.substring(cityPos+1, peoplePos);
                //DEBUGGING
                System.out.println("  PEOPLE: " + people);
                pause();
            
            int refPos = line.indexOf(",", peoplePos);
            String ref = line.substring(peoplePos+1, refPos);
                //DEBUGGING
                System.out.println("  REF: " + ref);
                pause(); */
            
            Game newGame = new Game(numeral, year, city, winner, loser, score); 
            superBowls.add(newGame);
            System.out.println(newGame);
            
        }
    }

    public int numWins(String team) {
        int wins = 0;
        for (Game game : superBowls) {
            if (game.getWinner().equals(team)) wins++;
        }
        return wins;
    }

    public void sortByYear() {
        // This will sort the superBowls variable in chronological order by year.
    }

    public void sortByWinningTeam() {
        // This will sort the superBowls variable in alphabetical order by winning team.

    }

    public void sortByPointDifferential() {
        // This will sort the superBowls variable in numeric order from largest point 
        // differential to smallest point differential.

    }





    //DEBUGGING
    public static void pause() {
        Scanner pause = new Scanner(System.in);
        System.out.println("  Press enter to continue");
        pause.nextLine();
    }


}