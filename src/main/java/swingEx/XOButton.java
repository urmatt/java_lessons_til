package swingEx;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class XOButton extends JComponent {

    private int value = 0;
    private XOListener listener;

    public XOButton() {
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
//                System.out.println("click");
                value = value == 1 ? 2 : 1;
                notifyListener();
                repaint();
            }

            @Override
            public void mousePressed(MouseEvent e) {
//                System.out.println("press");

            }

            @Override
            public void mouseReleased(MouseEvent e) {
//                System.out.println("release");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
//                System.out.println("entered");
            }

            @Override
            public void mouseExited(MouseEvent e) {
//                System.out.println("exit");
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (value == 1)
            drawX(g);
        else if (value == 2)
            drawO(g);
    }

    private void drawO(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(3));
        g2.drawOval(0, 0, getWidth() - 1, getHeight() - 1);
        g2.setStroke(new BasicStroke(1));
    }

    private void drawX(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(3));
        g2.drawLine(0, 0, getWidth() - 1, getHeight() - 1);
        g2.drawLine(getWidth() - 1, 0, 0, getHeight() - 1);
        g2.setStroke(new BasicStroke(1));
    }

    private void printlnPosition() {
        System.out.println(getX());
        System.out.println(getY());
        System.out.println(getWidth());
        System.out.println(getHeight());
    }

    public void setValue(int value) {
        this.value = value;
        notifyListener();
        repaint();
    }

    private void notifyListener() {
        if (listener != null)
            listener.onValueChanged(this.value);
    }

    public int getValue() {
        return value;
    }

    public void setListener(XOListener listener) {
        this.listener = listener;
    }
}
