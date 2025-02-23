import java.awt.event.*;
import javax.swing.*;
import java.io.File;


public class GUI {

    public void runGUI() throws Exception {
        File file = new File("placeholder"); //change placeholder to the file location of superBowls.txt
        GameList list = new GameList(file);


        JFrame f=new JFrame("Title");
        final JTextField tf=new JTextField();
        tf.setBounds(50,50, 130,30);     // .setBounds(x, y, width, height);
        
        // button 1 finds the amount of wins from a team
        JButton b1=new JButton("Number of wins from this team");
        b1.setBounds(200,50,230,30);
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String teamName = tf.getText(); //gets the string typed into the text area
                System.out.println("The " + teamName + " has " + list.numWins(teamName) + " super bowl wins.");
            }
        });
        
        // button 2 orders the list by winning team
        JButton b2=new JButton("Order by winning team");
        b2.setBounds(50,100,200,30);
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                list.sortByWinningTeam();
                for (Game game : list.superBowls) {
                    System.out.println(game);
                }
            }
        });

        // button 3 orders the list by year played
        JButton b3=new JButton("Order by year");
        b3.setBounds(50,150,200,30);
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                list.sortByYear();
                for (Game game : list.superBowls) {
                    System.out.println(game);
                }
            }
        });

        // button 4 orders by biggest to smallest point difference
        JButton b4=new JButton("Order by point difference");
        b4.setBounds(50,200,200,30);
        b4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                list.sortByPointDifferential();
                for (Game game : list.superBowls) {
                    System.out.println(game);
                }
            }
        });
        


        f.add(tf);
        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.add(b4);
        f.setSize(800,600);
        f.setLayout(null);
        f.setVisible(true);
    }




    public static void main(String[] args) throws Exception {
        GUI gui = new GUI();
        gui.runGUI();
    }
}