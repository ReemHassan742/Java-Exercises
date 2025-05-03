import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

public class OceanWavesWithFish {

    public static void main(String[] args) {
        if (GraphicsEnvironment.isHeadless())
            return;
        JFrame frame = new JFrame("Fish Swimming Slowly Above Waves");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new OceanPanel());
        frame.pack();
        frame.setVisible(true);
    }
}

class OceanPanel extends JPanel implements ActionListener {
    private Timer timer = new Timer(1000 / 30, this);
    private float fishY, fishDirection = -0.8f, waveOffset = 0, fishAngle = 0, headMovement = 0;
    private int fishX, fishXDirection = -1, FISH_SIZE = 130;
    private boolean fishFlipped = false;
    private int waveBaseY = 450;

    public OceanPanel() {
        setPreferredSize(new Dimension(1200, 700));
        setBackground(new Color(240, 248, 255));
        fishX = getWidth() * 3 / 4;
        fishY = waveBaseY - 120;
        timer.start();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setColor(new Color(0, 0, 0, 200));
        for (int i = 0; i < 10; i++) {
            int waveY = waveBaseY - i * 10;
            int[] xPoints = new int[200];
            int[] yPoints = new int[200];
            for (int j = 0; j < 200; j++) {
                float t = (float) j / 199;
                xPoints[j] = getWidth() + (int) (t * (getWidth() / 4 - getWidth()));
                yPoints[j] = waveY + (int) (Math.sin(t * 4 * Math.PI * 3.0f + waveOffset + i * 0.3f) * 10);
            }
            g2d.drawPolyline(xPoints, yPoints, 200);
        }

        int currentFishY = (int) (fishY + headMovement);
        AffineTransform old = g2d.getTransform();
        g2d.rotate(Math.toRadians(fishAngle), fishX, currentFishY);

        GradientPaint gp = new GradientPaint(
                fishX - FISH_SIZE / 2, currentFishY, fishFlipped ? new Color(255, 140, 0) : new Color(50, 150, 50),
                fishX + FISH_SIZE / 2, currentFishY, fishFlipped ? new Color(50, 150, 50) : new Color(255, 140, 0));
        g2d.setPaint(gp);

        GeneralPath body = new GeneralPath();
        int bodyWidth = (int) (FISH_SIZE * 0.5f);
        int bodyLength = FISH_SIZE;

        if (!fishFlipped) {
            body.moveTo(fishX - bodyLength / 2, currentFishY);
            body.curveTo(
                    fishX - bodyLength / 3, currentFishY - bodyWidth / 2,
                    fishX + bodyLength / 3, currentFishY - bodyWidth / 3,
                    fishX + bodyLength / 2, currentFishY);
            body.curveTo(
                    fishX + bodyLength / 3, currentFishY + bodyWidth / 3,
                    fishX - bodyLength / 3, currentFishY + bodyWidth / 2,
                    fishX - bodyLength / 2, currentFishY);
        } else {
            body.moveTo(fishX + bodyLength / 2, currentFishY);
            body.curveTo(
                    fishX + bodyLength / 3, currentFishY - bodyWidth / 2,
                    fishX - bodyLength / 3, currentFishY - bodyWidth / 3,
                    fishX - bodyLength / 2, currentFishY);
            body.curveTo(
                    fishX - bodyLength / 3, currentFishY + bodyWidth / 3,
                    fishX + bodyLength / 3, currentFishY + bodyWidth / 2,
                    fishX + bodyLength / 2, currentFishY);
        }
        g2d.fill(body);

        int tailSize = (int) (FISH_SIZE * 0.2);
        int[] tailXPoints = fishFlipped
                ? new int[] { fishX + bodyLength / 2, fishX + bodyLength / 2 + tailSize,
                        fishX + bodyLength / 2 + tailSize }
                : new int[] { fishX - bodyLength / 2, fishX - bodyLength / 2 - tailSize,
                        fishX - bodyLength / 2 - tailSize };
        int[] tailYPoints = new int[] { currentFishY, currentFishY - tailSize / 2, currentFishY + tailSize / 2 };
        g2d.fillPolygon(tailXPoints, tailYPoints, 3);

        g2d.setTransform(old);
    }

    public void actionPerformed(ActionEvent e) {
        fishY += fishDirection * 0.5f;
        headMovement = (float) (Math.sin(System.currentTimeMillis() * 0.006) * 8);

        fishAngle = (fishDirection * 5) + (headMovement * 0.5f);
        int targetY = waveBaseY - 120 + (int) (Math.sin(waveOffset * 1.2) * 20);
        fishDirection += (targetY - fishY) * 0.01f;
        fishDirection = Math.max(-2, Math.min(4, fishDirection));

        fishX += fishXDirection * 2;

        if (fishX < getWidth() / 4 + 50) {
            fishXDirection = 1;
            fishFlipped = false;
        } else if (fishX > getWidth() - 50) {
            fishXDirection = -1;
            fishFlipped = true;
        }

        waveOffset += 0.05f;
        repaint();
    }
}