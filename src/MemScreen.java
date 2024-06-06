package src;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MemScreen extends JFrame {
    JLabel word, mean, la1, la2;
    JTextField id;
    JPasswordField passwd;
    JPanel printPanel,idPanel,Header,btnPanel;
    JButton btn1, btn2, btn3, bfbtn;
    JTextArea content;

    public MemScreen() {
        super("MemScreen");
        setLayout(new BorderLayout(30,20));
        
        idPanel = new JPanel();
        Header = new JPanel();
        printPanel = new JPanel(new BorderLayout(20,30));

        bfbtn = new JButton("뒤로가기");
        Header.add(bfbtn);
        Header.setLocation(0,0);

        word = new JLabel("단어");
        mean = new JLabel("단어 뜻");
        
        word.setHorizontalAlignment(JLabel.CENTER);
        word.setBorder(BorderFactory.createEmptyBorder(30,0,10,0));
        mean.setHorizontalAlignment(JLabel.CENTER);
        mean.setBorder(BorderFactory.createEmptyBorder(10,0,0,0));

        printPanel.add(word,BorderLayout.CENTER);
        printPanel.add(mean,BorderLayout.SOUTH);

        /*la1 = new JLabel("아이디 : ");
        la2 = new JLabel("비밀번호 : ");
        id = new JTextField(15);
        passwd = new JPasswordField(15);
        passwd.setEchoChar('*'); 

        idPanel.add(la1);
        idPanel.add(id);
        passPanel.add(la2);
        passPanel.add(passwd);*/
        
        btn1 = new JButton("다 외움");
        btn2 = new JButton("뜻 확인");
        btn3 = new JButton("다음 단어");
        btnPanel = new JPanel();
        btnPanel.add(btn1);
        btnPanel.add(btn2);
        btnPanel.add(btn3);
        btnPanel.setBorder(BorderFactory.createEmptyBorder(0,0,50,0));

        bfbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                new MainScreen();
                setVisible(false);
            }
        });

        this.add(Header,BorderLayout.NORTH);
        this.add(printPanel,BorderLayout.CENTER);
        this.add(btnPanel,BorderLayout.SOUTH);
        setSize(300,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args) {
        MemScreen g= new MemScreen();
    }
}