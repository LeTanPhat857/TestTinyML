package view.mainFrame;

import utils.ImgUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class InputPanel extends JPanel {

    // fields
    final int size = 28;
    Point point = new Point();
    BufferedImage bufferedImage = new BufferedImage(size * 10, size * 10, BufferedImage.TYPE_BYTE_GRAY);

    // constructor
    public InputPanel() {
        // set default
        this.setPreferredSize(new Dimension(size * 10, size * 10));
        this.setBackground(Color.black);
        this.setBorder(
                BorderFactory.createTitledBorder(null, "Input", 2, 2, new Font("Arial", Font.ITALIC, 14), Color.BLUE));

        //
        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent arg) {
                draw(arg.getX(), arg.getY());
            }
        });
    }

    // run test
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());

        InputPanel inputPanel = new InputPanel();
        frame.add(inputPanel);

        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
    }

    public void draw(int x, int y) {
        point = new Point(x, y);

        paintBufferedImage(bufferedImage.getGraphics());

        paintComponents(getGraphics());
    }

    @Override
    public void paintComponents(Graphics g) {
        super.paintComponents(g);
        g.setColor(Color.white);

        int x = (int) point.getX();
        int y = (int) point.getY();

        g.fillRect(x, y, 10, 10);
    }

    public void paintBufferedImage(Graphics g) {
        //
        g.setColor(Color.white);
        int x = (int) point.getX();
        int y = (int) point.getY();
        g.fillRect(x, y, 15, 15);
        //
        g.setColor(Color.lightGray);
        g.fillRect(x + 5, y + 5, 5, 5);
        g.fillRect(x - 5, y - 5, 5, 5);
    }

    public void clear() {
        this.repaint();
    }

    public BufferedImage getBufferedImage() {
        return ImgUtils.scaleImage(this.bufferedImage, 28, 28);
    }

    public void resetBufferedImage() {
        this.bufferedImage = new BufferedImage(size * 10, size * 10, BufferedImage.TYPE_BYTE_GRAY);
    }
}
