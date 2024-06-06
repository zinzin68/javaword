package src;
//import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
//import javax.swing.JPasswordField;
//import javax.swing.JScrollPane;
//import javax.swing.JTextArea;
//import javax.swing.JTextField;

public class StartScreen extends JFrame {
    JLabel Title;
    JButton start;
    JPanel title, button;

    public StartScreen() {
        super("Start Screen");
        setLayout(new BorderLayout(10,20));
        //this.getContentPane().setBackground(Color.yellow);

        title = new JPanel();
        button = new JPanel();

        start = new JButton("Start");
        Title = new JLabel("단어장~");
        title.setBorder(BorderFactory.createEmptyBorder(50,0,0,0));
        button.setBorder(BorderFactory.createEmptyBorder(0,0,30,0));

        button.add(start);
        title.add(Title);

        this.add(title,BorderLayout.CENTER);
        this.add(button,BorderLayout.SOUTH);
        
        start.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                new MainScreen();
                setVisible(false);
            }
        });
        
        setSize(300,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args) {
        new StartScreen();
    }
}