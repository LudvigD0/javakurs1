
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


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
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;

public class Game extends JFrame implements KeyListener {

    Gamepanel panel;

    ArrayList<Character> typedCharacters = new ArrayList<>();

    public Game() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        
        this.setTitle("Game Input Test");
        this.setSize(screenSize.width, screenSize.height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addKeyListener(this);

        panel = new Gamepanel();
        this.add(panel);




        new Thread(() -> {
            long lastTime = System.nanoTime();

            while (true) {
                long now = System.nanoTime();
                double delta = (now - lastTime) / 1_000_000_000.0;
                lastTime = now;

                panel.textPosX += 0;
                panel.repaint();

                try {
                    Thread.sleep(2);
                } catch (Exception e) {}
            }
        }).start();


        this.setVisible(true);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        char c = e.getKeyChar();
        int typedCode = e.getKeyCode();
        
        if (typedCode == KeyEvent.VK_BACK_SPACE && e.isControlDown()) {
            if (typedCharacters.isEmpty() == false) {
                if (typedCharacters.getLast() == ' ') {
                    typedCharacters.removeLast();
                } else {
                    for (int i = typedCharacters.size()-1; i >= 0; i--) {
                        if (typedCharacters.get(i) == ' ') {
                            break;
                        } else {
                            typedCharacters.removeLast();
                        }
                    }
                }
            }
        } else if (typedCode == KeyEvent.VK_BACK_SPACE || c == '\b') {
            if (typedCharacters.isEmpty() == false) {
                typedCharacters.removeLast();
            }
        } else {
            if (c != KeyEvent.CHAR_UNDEFINED &&
                c != '\b' &&
                c != '\n' &&
                c != '\t' &&
                c != 127 &&
                c >= 32) 
                {
                    
                typedCharacters.add(e.getKeyChar());

                }
        }

        System.out.println(typedCharacters.toString());

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

    private Font interFont;

    public Gamepanel() {
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


        g.setFont(interFont);
        Color[] colors = { Color.decode("#ffffff") };
        String text = "Hello c world lalalalallalalalalallalalalal";

        
        int panelW = getWidth();
        int panelH = getHeight();

        g.setColor(Color.decode("#242424"));
        g.fillRect(0,0,panelW,panelH);

        int tracking = 2;
        FontMetrics fm = g2.getFontMetrics();

        int totalWidth = 0;
        for (int i = 0; i < text.length(); i++) {
            totalWidth += fm.charWidth(text.charAt(i));
            if (i < text.length() - 1) {
                totalWidth += tracking;
            }
        }


        int startX = (panelW - totalWidth) / 2;
        int baseLineY = (panelH - fontSize) / 2;
        int currentX = startX;
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            g.setColor(colors[i % colors.length]); 

            int textWidth = g.getFontMetrics().stringWidth(text);
      
            g.drawString(String.valueOf(c), currentX, baseLineY);

            // move X position based on the width of the character
            currentX += g.getFontMetrics().charWidth(c) + 2;
        }

        
    }
}
















/* public class Test {
    private static volatile String lastInput = null;


    public static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) throws Exception {
        String[] listOfWords = {"tjenare","elliot", "jag", "test"};
        

        Random rand = new Random();
        
        Thread inputThread = new Thread(() -> {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                String input = scanner.nextLine();
                lastInput = input;
            }
        });

        inputThread.start();
        

        while (true) {
            clear();
            System.out.println("Frame: " + System.currentTimeMillis());
            //String randomWord = listOfWords[rand.nextInt(listOfWords.length)];
            //System.out.println(randomWord);
            System.out.println("Current word " + listOfWords[0]);
           
            System.out.println("Print " + lastInput);

            Thread.sleep(200);
        }
    }
} */



/*  Scanner input = new Scanner(System.in);
            String ch = input.nextLine();
            System.out.println(ch); */