package mypackage;
import java.util.Random;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class NumberGenerator extends JFrame implements ActionListener {
    JLabel background; // Declare JLabel for background
    JLabel l1, l2, l3;
    JTextField t;
    JButton b;
    int num;
    int count;
    boolean correctGuess;

    NumberGenerator() {
        super("NUMBER GUESSER");

        // Load the background image
        ImageIcon backgroundImage = new ImageIcon("guesser_bg.jpg"); // Change "background.jpg" to your image file path
        background = new JLabel(backgroundImage);
        background.setBounds(0, 0, backgroundImage.getIconWidth(), backgroundImage.getIconHeight());
        add(background); // Add background JLabel to the JFrame

        l1 = new JLabel("WELCOME TO NUMBER GUESSER GAME!");
        l1.setForeground(Color.WHITE); // Set text color to contrast with the background
        l1.setBounds(100, 50, 800, 100);
        l2 = new JLabel("Enter your number: ");
        l2.setForeground(Color.WHITE); // Set text color to contrast with the background
        l2.setBounds(100, 250, 150, 50);
        t = new JTextField();
        t.setBounds(300, 250, 650, 50);
        b = new JButton("GO");
        b.setBounds(400, 400, 100, 100);
        l3 = new JLabel(" ");
        l3.setForeground(Color.WHITE); // Set text color to contrast with the background
        l3.setBounds(200, 600, 400, 50);
        
        // Add components to the background JLabel
        background.add(l1);
        background.add(l2);
        background.add(l3);
        background.add(t);
        background.add(b);
        
        // Set layout of JFrame to null layout
        setLayout(null);
        
        setSize(backgroundImage.getIconWidth(), backgroundImage.getIconHeight()); // Set frame size based on the image size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame on the screen
        setVisible(true);
        
        b.addActionListener(this);
        Random ram = new Random();
        num = ram.nextInt(100); // Generate random number once
        count = 1; // Initialize count to 1
        correctGuess = false; // Initialize correctGuess to false
    }

    public void actionPerformed(ActionEvent ae) {
        String s = t.getText();
        if (s.isEmpty()) {
            l3.setText("Please Enter your value");
            return; // Exit actionPerformed if text field is empty
        }

        if (!s.matches("\\d+")) {
            l3.setText("Please Enter a valid integer");
            t.setText("");
            return; // Exit actionPerformed if input is not a valid integer
        }

        int enter = Integer.parseInt(s);

        if (count <= 10 && !correctGuess) {
            if (enter == num) {
                l3.setText("Good guess");
                correctGuess = true;
            } else if (enter < num) {
                l3.setText("Enter a greater one");
            } else if (enter > num) {
                l3.setText("Enter a smaller one");
            }

            if (!correctGuess && count >= 10) {
                l3.setText("You've run out of attempts. The correct number was: " + num);
            }

            t.setText("");
            count++;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new NumberGenerator();
            frame.setVisible(true);
            System.out.println("JFrame is visible.");
        });
    }

}

