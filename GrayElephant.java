import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;

public class GrayElephant extends JPanel {

    private TexturePaint createElephantTexture() {
        BufferedImage texture = new BufferedImage(6, 6, BufferedImage.TYPE_INT_RGB);
        Graphics2D tg = texture.createGraphics();
        tg.setColor(new Color(145, 145, 145));
        tg.fillRect(0, 0, 6, 6);
        tg.setColor(new Color(130, 130, 130));
        tg.drawLine(0, 0, 6, 6);
        tg.drawLine(6, 0, 0, 6);
        tg.dispose();
        return new TexturePaint(texture, new Rectangle(6, 6));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.WHITE);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        TexturePaint elephantTexture = createElephantTexture();

        // Head & Neck
        GeneralPath headNeck = new GeneralPath();
        headNeck.moveTo(200, 150);
        headNeck.curveTo(180, 130, 160, 140, 150, 160);
        headNeck.lineTo(140, 200);
        headNeck.curveTo(160, 210, 190, 220, 220, 210);
        headNeck.closePath();
        g2d.setPaint(elephantTexture);
        g2d.fill(headNeck);
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(3));
        g2d.draw(headNeck);

        // Trunk
        GeneralPath trunk = new GeneralPath();
        trunk.moveTo(150, 160);
        trunk.curveTo(130, 170, 120, 200, 120, 250);
        trunk.curveTo(125, 380, 140, 400, 160, 360);
        g2d.setPaint(elephantTexture);
        g2d.fill(trunk);
        g2d.setColor(Color.BLACK);
        g2d.draw(trunk);

        // Ear
        GeneralPath ear = new GeneralPath();
        ear.moveTo(200, 150);
        ear.curveTo(220, 130, 260, 150, 260, 180);
        ear.curveTo(250, 200, 220, 170, 200, 150);
        g2d.setPaint(elephantTexture);
        g2d.fill(ear);
        g2d.setColor(Color.BLACK);
        g2d.draw(ear);

        // Body with gradient for volume
        GradientPaint bodyGradient = new GradientPaint(210, 180, new Color(170, 170, 170),
                410, 300, new Color(120, 120, 120));
        Ellipse2D body = new Ellipse2D.Double(210, 180, 200, 120);
        g2d.setPaint(bodyGradient);
        g2d.fill(body);
        g2d.setColor(Color.BLACK);
        g2d.draw(body);

        // Legs
        drawLeg(g2d, 240, 285, 240, 380);
        drawLeg(g2d, 280, 300, 280, 390);
        drawLeg(g2d, 350, 300, 350, 390);
        drawLeg(g2d, 390, 285, 390, 380);

        // Eye
        g2d.setColor(Color.BLACK);
        g2d.fillOval(175, 165, 8, 8);

        // Tail (a bit to the back)
        g2d.drawLine(160, 180, 150, 165);

        // Optional: soft shading
        g2d.setColor(new Color(120, 120, 120, 60));
        g2d.setStroke(new BasicStroke(4));
        g2d.draw(new Ellipse2D.Double(215, 185, 190, 110));
    }

    private void drawLeg(Graphics2D g2d, int x1, int y1, int x2, int y2) {
        g2d.setPaint(createElephantTexture());
        g2d.fillRect(x1 - 10, y1, 20, y2 - y1);
        g2d.setColor(Color.BLACK);
        g2d.drawRect(x1 - 10, y1, 20, y2 - y1);
        g2d.drawLine(x2, y2, x2 - 20, y2 + 5);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Textured Gray Elephant");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);
        frame.add(new GrayElephant());
        frame.setVisible(true);
    }
}
