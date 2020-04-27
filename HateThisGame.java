package HateThisGame;

import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import javax.swing.*;
//implementing public class
public class HateThisGame extends JPanel {
//declaring instance variables
    int x, y;
    
    private Graphics dbg; //private variable type call graphic 

    Image bg; // create variable call bg from the standard libraries image

    public class AL extends KeyAdapter { //AL inherits from  KeyAdapter
        public void keyPressed(KeyEvent e) {//Implementing keyPressed method  which take keyEvent as an argument by calling it e.
            int keyCode = e.getKeyCode();

            if (keyCode == e.VK_LEFT) {
                if (x <= 8)
                    x = 8;
                else
                    x += -5;
            }
            if (keyCode == e.VK_RIGHT) {
                if (x >= 235)
                    x = 235;
                else
                    x += +5;
            }
            if (keyCode == e.VK_UP) {
                if (y <= 18)
                    y = 18;
                else
                    y += -5;
            }
            if (keyCode == e.VK_DOWN) {
                if (y >= 235)
                    y = 235;
                else
                    y += +5;
            }
        }

        public void keyReleased(KeyEvent e) {//implementing keyReleased
        }
    }

    public HateThisGame() throws Exception {
        // Load background images
        
        bg = Toolkit.getDefaultToolkit().createImage("/Users/B-Soft/Documents/Classes/JavaClass2020/Project/HateThisGame/IHateThisGame.png");

        setFocusable(true);

        // Game properties
        addKeyListener(new AL());
        x = 150;
        y = 150;

        ActionListener al = new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                repaint();
            }
        };
        Timer timer = new Timer(50,al);
        timer.start();
    }

    public void paintComponent(Graphics g) {
        g.drawImage(bg, 0, 0, null);
    }
//Setting up the game window 
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    JFrame f = new JFrame("I Hate This Game");
                    f.setSize(1280, 635);
                    f.setResizable(false);
                    f.setVisible(true);
                    f.setBackground(Color.GRAY);
                    f.setContentPane(new HateThisGame());
                    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}