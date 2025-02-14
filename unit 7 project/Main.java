import java.util.Scanner;
import java.io.File;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        File file = new File("C:\\Users\\student\\.vscode\\.vscode\\unit 7 project\\SuperBowlData.txt");
        Scanner text = new Scanner(file);

        GameList newList1 = new GameList(file);
        System.out.println(newList1);
    }
}
