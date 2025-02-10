import java.util.ArrayList;
import java.util.*;
import java.util.Scanner;
import java.io.File;

public class GameList {
    Scanner text = new Scanner(System.in);
    File file = new File("C:\\Users\\student\\.vscode\\.vscode\\unit 7 project\\SuperBowlData.txt");
    
    private ArrayList<Game> superBowls = new ArrayList<Game>();
    
    public GameList() throws Exception {
        while (text.hasNextLine()) {
            String line = text.nextLine();
            //I,"January 15, 1967",Green Bay Packers,35–10,Kansas City Chiefs,Los Angeles Memorial Coliseum,"Los Angeles, California","61,946",Norm Schachter
            int numeralPos = line.indexOf(",");
            String numeral = line.substring(0, numeralPos);
            
            int nothing = line.indexOf(",", numeralPos + 1);

            int datePos = line.indexOf(",", nothing);
            String date = line.substring(nothing+2, datePos-1);
            
            int winnerPos = line.indexOf(",", datePos + 1);
            String winner = line.substring(datePos+1, winnerPos);
            
            int scorePos = line.indexOf(",", winnerPos + 1);
            String score = line.substring(scorePos+1, winnerPos);
            
            int loserPos = line.indexOf(",", scorePos+1);
            String loser = line.substring(scorePos+1, loserPos);
            
            int stadiumPos = line.indexOf(",", loserPos+1);
            String stadium = line.substring(loserPos+1, stadiumPos);
            
            int cityPos = line.indexOf(",", stadiumPos);
            String city = line.substring(stadiumPos+1, cityPos);
            
            int peoplePos = line.indexOf(",", cityPos);
            String people = line.substring(cityPos+1, peoplePos);
            
            int refPos = line.indexOf(",", peoplePos);
            String ref = line.substring(peoplePos+1, refPos);
            //Game,Date,Winning team,Score,Losing team,Venue,City,Attendance,Referee

            
        }
    }
}