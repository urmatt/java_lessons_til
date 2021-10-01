package swingEx;

import javax.swing.*;
import java.awt.*;

public class CreateCustomElement {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setLayout(new GridLayout(3, 3));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setBounds(0, 0, 200, 200);

        for (int i = 0; i < 9; i++) {
            XOButton xoButton = new XOButton();
            xoButton.setListener(value -> {
                System.out.println(value);
            });
            frame.add(xoButton);
        }

        frame.setVisible(true);
    }
}
