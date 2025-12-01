import javax.swing.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.awt.Graphics2D;
import java.awt.Toolkit;

public class Game extends JFrame implements KeyListener {

    private final Gamepanel panel;
    private final TypingLogic logic;

    public Game() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        
        this.setTitle("Touchtyping game");
        this.setSize(screenSize.width, screenSize.height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addKeyListener(this);

        logic = new TypingLogic();
        panel = new Gamepanel(logic);

        this.add(panel);



        int delayMs = 16;
        new javax.swing.Timer(delayMs, e -> {
            panel.textPosX += 2;
            panel.repaint();
        }).start();


        this.setVisible(true);
    }

    

    @Override
    public void keyPressed(KeyEvent e) {
        logic.handleKeyPressed(e);
        panel.repaint();
    }

    
    @Override public void keyReleased(KeyEvent e) { }

    @Override public void keyTyped(KeyEvent e) { }

    public static void main(String[] args) {
        new Game();
    }
}



class Gamepanel extends JPanel {
    double textPosX = 0;
    int fontSize = 40;

    private final TypingLogic logic;
    private Font interFont;

    public Gamepanel(TypingLogic logic) {
        this.logic = logic;

        try {
            InputStream interSrc = getClass().getResourceAsStream("/fonts/Kanit-SemiBold.ttf");

            if (interSrc == null) {
                System.err.println("Could no find /fonts/Kanit-SemiBold.ttf");
                interFont = new Font("SansSerif", Font.BOLD, fontSize);  
            } else {
                interFont = Font.createFont(Font.TRUETYPE_FONT, interSrc).deriveFont((float)fontSize);
                System.out.println("Loaded font: " + interFont.getFontName() + " / " + interFont.getFamily());
            }

        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
            interFont = new Font("SansSerif", Font.BOLD, fontSize);
        }
    }
    

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(
            java.awt.RenderingHints.KEY_TEXT_ANTIALIASING,
            java.awt.RenderingHints.VALUE_TEXT_ANTIALIAS_ON
        );

        Color light = Color.decode("#dfdfdf");
        Color dark = Color.decode("#242424");
        Color red = Color.decode("#ff5454");

        g.setFont(interFont);
        Color[] colors = { light };
        
        String text = "Hello world, looking amazing";

        
        int panelW = getWidth();
        int panelH = getHeight();


        g.setColor(dark);
        g.fillRect(0, 0, panelW, panelH); // Fill background

        int tracking = 2;
        FontMetrics fm = g2.getFontMetrics();

        int totalWidth = 0;
        for (int i = 0; i < text.length(); i++) {
            totalWidth += fm.charWidth(text.charAt(i));
            if (i < text.length() - 1) {
                totalWidth += tracking;
            }
        }

        for (int i = 0; i < logic.toBeTypedList.subList(0, 20).size(); i++) {
            totalWidth += fm.charWidth(logic.toBeTypedList.get(i));

        }


        int startX = (panelW - totalWidth) / 2;
        int baseLineY = (panelH - fontSize) / 2;
        int currentX = startX;
        for (int i = 0; i < logic.toBeTypedList.subList(0, 20).size(); i++) {
            char c = logic.toBeTypedList.get(i);

            if (!logic.progress.isEmpty() && logic.progress.get(i)) {
                g.setColor(red); 

            } else {
                g.setColor(light);
            }


      
            g.drawString(String.valueOf(c), currentX, baseLineY);

            // move X position based on the width of the character
            currentX += g.getFontMetrics().charWidth(c) + 2;
        }
//            int textWidth = g.getFontMetrics().stringWidth(text);




        
    }
}

