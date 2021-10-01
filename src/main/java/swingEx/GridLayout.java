package swingEx;
import javax.swing.*;
import java.awt.*;

public class GridLayout {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setBounds(300, 100, 500,500);
        jFrame.setLayout(new java.awt.GridLayout(3,3,10,10));

        jFrame.add(new JButton("1"));
        jFrame.add(new JButton("2"));
        jFrame.add(new JButton("3"));
        jFrame.add(new JButton("4"));
        jFrame.add(new JButton("5"));
        jFrame.add(new JButton("6"));
        jFrame.add(new JButton("7"));
        jFrame.add(new JButton("8"));
        jFrame.add(new JButton("9"));

        jFrame.setVisible(true);

    }
}
