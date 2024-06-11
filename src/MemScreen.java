package src;

//import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
//import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//import words.*;

public class MemScreen extends JFrame implements ActionListener{
    JLabel word, mean, la1, la2;
    JTextField id;
    JPasswordField passwd;
    JPanel printPanel,idPanel,Header,btnPanel;
    JButton btn1, btn2, btn3, bfbtn;
    JTextArea content;

    static int i =0;

    public MemScreen() {
        super("MemScreen");
        setLayout(new BorderLayout(30,20));
        
        idPanel = new JPanel();
        Header = new JPanel(new FlowLayout(FlowLayout.LEFT));
        printPanel = new JPanel(new BorderLayout(0,0));

        bfbtn = new JButton("암기 종료");
        Header.add(bfbtn);
        Header.setBorder(BorderFactory.createEmptyBorder(0,0,100,0));

        word = new JLabel("단어");
        mean = new JLabel("단어 뜻");
        mean.setVisible(false);
        
        word.setHorizontalAlignment(JLabel.CENTER);
        mean.setHorizontalAlignment(JLabel.CENTER);

        printPanel.add(word,BorderLayout.CENTER);
        printPanel.add(mean,BorderLayout.SOUTH);
        
        btn1 = new JButton("다 외움");
        btn2 = new JButton("뜻 확인");
        btn3 = new JButton("다음 단어");

        btn1.setPreferredSize(new Dimension(100,40));
        btn2.setPreferredSize(new Dimension(100,40));
        btn3.setPreferredSize(new Dimension(100,40));

        btnPanel = new JPanel();
        btnPanel.add(btn1);
        btnPanel.add(btn2);
        btnPanel.add(btn3);
        btnPanel.setBorder(BorderFactory.createEmptyBorder(100,0,100,0));

        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        bfbtn.addActionListener(this);

        this.add(Header,BorderLayout.NORTH);
        this.add(printPanel,BorderLayout.CENTER);
        this.add(btnPanel,BorderLayout.SOUTH);

        bfbtn.setFont(new Font("나눔고딕", Font.BOLD,15));
        word.setFont(new Font("나눔고딕", Font.BOLD,15));
        mean.setFont(new Font("나눔고딕", Font.BOLD,15));
        btn1.setFont(new Font("나눔고딕", Font.BOLD,15));
        btn2.setFont(new Font("나눔고딕", Font.BOLD,15));
        btn3.setFont(new Font("나눔고딕", Font.BOLD,15));

        setSize(350,550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args) {
        new MemScreen();
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource()==btn1){
            //String w = wordlist.wordview(1, i);
            //System.out.println(w);
            //word.setText("ok next");
            mean.setVisible(false);
            //i++;
        }
        else if (e.getSource()==btn3){
            //String w = wordlist.wordview(1, i);
            //System.out.println(w);
            //word.setText("next");
            mean.setVisible(false);
            //i++;
        }
        else if(e.getSource() == btn2){
            mean.setVisible(true);
        }
        else if(e.getSource() == bfbtn){
            new MainScreen();
            this.setVisible(false);
        }
    }
}