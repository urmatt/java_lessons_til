package swingEx;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameEx {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setBounds(300, 100, 700, 500);

        JButton clickMeButton = new JButton("CLick me");
        JButton otherButton = new JButton("Other Button");
        clickMeButton.addActionListener(e -> clickMeButton.setText("Dont touch me"));

        frame.add(clickMeButton);
        frame.add(otherButton);
        //frame.setLayout(new GridLayout(3, 3));
        frame.setVisible(true);
    }
}
