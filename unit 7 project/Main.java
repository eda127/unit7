import java.util.Scanner;
import java.io.File;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        File file = new File("placeholder");
        Scanner text = new Scanner(file);

        GameList newList1 = new GameList(file);
        System.out.println(newList1);
    }
}