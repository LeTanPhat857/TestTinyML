package view.mainFrame;

import javax.swing.*;
import java.awt.*;

public class OutputPanel extends JPanel {

    // fields
    final int size = 28;
    String outputString;

    // constructor
    public OutputPanel() {
        // set default
        this.setPreferredSize(new Dimension(size * 10, size * 10));
        this.setBackground(Color.black);
        this.setBorder(
                BorderFactory.createTitledBorder(null, "Output", 2, 2, new Font("Arial", Font.ITALIC, 14), Color.BLUE));
    }

    // run test
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());

        OutputPanel outputPanel = new OutputPanel();
        frame.add(outputPanel);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    // methods
    public void drawNumber(int number) {
        this.outputString = String.valueOf(number);
        this.paintComponents(getGraphics());
        this.outputString = "";
    }

    @Override
    public void paintComponents(Graphics g) {
        super.paintComponents(g);
        g.setColor(Color.white);
        g.setFont(new Font("Arial", Font.BOLD, this.getHeight()));
        g.drawString(outputString, 9 * this.getInsets().left, this.getHeight() - 2 * this.getInsets().top);
    }

    public void clear() {
        this.repaint();
    }
}
