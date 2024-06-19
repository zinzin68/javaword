package MyWord;

//import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StartScreen extends JFrame {
    private JLabel Title,cloud;
    private RoundedButton start;
    private JPanel title, button;
    

    public StartScreen() {
        super("MyWord");
        setLayout(new BorderLayout());
        this.getContentPane().setBackground(Color.WHITE);
        setLayout(new BorderLayout(30,20));
        ImageIcon icon = new ImageIcon("MyWord/icon.png");
        setIconImage(icon.getImage());

        cloud = new JLabel();
        title = new JPanel();

        Image img = icon.getImage();
        Image upimg = img.getScaledInstance(150,66,Image.SCALE_SMOOTH);
        ImageIcon upicon = new ImageIcon(upimg);
        
        cloud.setBackground(Color.WHITE);
        title.setBackground(Color.WHITE);
        button = new JPanel();
        button.setBackground(Color.WHITE);

        start = new RoundedButton("START",new Color(255,215,179));
        Title = new JLabel("단어장");

        cloud.setIcon(upicon);
        cloud.setHorizontalAlignment(JLabel.CENTER);

        cloud.setBorder(BorderFactory.createEmptyBorder(100,0,0,0));
        title.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        button.setBorder(BorderFactory.createEmptyBorder(0,0,150,0));
        
        start.setBackground(Color.white);
        start.setOpaque(false);
        start.setBorder(null);
        start.setPreferredSize(new Dimension(200,50));
        
        button.add(start);
        title.add(Title);
        this.add(cloud,BorderLayout.NORTH);
        this.add(title,BorderLayout.CENTER);
        this.add(button,BorderLayout.SOUTH);
        
        start.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                new MainScreen();
                setVisible(false);
            }
        });

        Title.setFont(new Font("한컴 말랑말랑 Bold", Font.BOLD,25));
        start.setFont(new Font("한컴 말랑말랑 Bold", Font.BOLD,25));

        setSize(350,550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args) {
        new StartScreen();
    }

    public class RoundedButton extends JButton {
        Color c;
        public RoundedButton() { super(); decorate(); } 
        public RoundedButton(String text , Color color) { super(text); c=color; decorate(); } 
        public RoundedButton(Action action) { super(action); decorate(); } 
        public RoundedButton(Icon icon) { super(icon); decorate(); } 
        public RoundedButton(String text, Icon icon) { super(text, icon); decorate(); } 
        protected void decorate() { setBorderPainted(false); setOpaque(false); }
        @Override 
        protected void paintComponent(Graphics g) {
           Color o=new Color(0,0,0); //글자색 결정
           int width = getWidth(); 
           int height = getHeight(); 
           Graphics2D graphics = (Graphics2D) g; 
           graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 
           if (getModel().isArmed()) { graphics.setColor(c.darker()); } 
           else if (getModel().isRollover()) { graphics.setColor(c.brighter()); } 
           else { graphics.setColor(c); } 
           graphics.fillRoundRect(0, 0, width, height, 30, 30); 
           FontMetrics fontMetrics = graphics.getFontMetrics(); 
           Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds(); 
           int textX = (width - stringBounds.width) / 2; 
           int textY = (height - stringBounds.height) / 2 + fontMetrics.getAscent(); 
           graphics.setColor(o); 
           graphics.setFont(getFont()); 
           graphics.drawString(getText(), textX, textY); 
           graphics.dispose(); 
           super.paintComponent(g); 
           }
        }
}