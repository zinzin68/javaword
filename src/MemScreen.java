package src;

//import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import src.MainScreen;
import src.wordlist;

public class MemScreen extends JFrame implements ActionListener{
    JLabel word, mean, now, total;
    JPasswordField passwd;
    JPanel printPanel,idPanel,Header,btnPanel;
    JButton btn1, btn2, btn3, bfbtn;
    JTextArea content;
    MainScreen ms = new MainScreen();
    wordlist wl = new wordlist();
    String[] w, m;
    String nowi, stotal;

    static int i =0;

    public MemScreen() {
        super("MemScreen");
        ms.setVisible(false);

        int x = ms.setList();
        wl.getFile(x);
        w = wl.wordView();
        m = wl.meanView();

        setLayout(new BorderLayout(30,20));
        
        idPanel = new JPanel();
        Header = new JPanel(new FlowLayout(FlowLayout.LEFT));
        printPanel = new JPanel(new BorderLayout(0,0));

        bfbtn = new JButton("암기 종료");
        Header.add(bfbtn);
        Header.setBorder(BorderFactory.createEmptyBorder(0,0,100,0));

        word = new JLabel(w[0]);
        mean = new JLabel(m[0]);
        nowi = String.valueOf(i);
        stotal = String.valueOf(w.length);
        now = new JLabel((nowi+1)+"/"+stotal);

        mean.setVisible(false);
        
        word.setHorizontalAlignment(JLabel.CENTER);
        mean.setHorizontalAlignment(JLabel.CENTER);
        now.setHorizontalAlignment(JLabel.CENTER);

        printPanel.add(word,BorderLayout.CENTER);
        printPanel.add(mean,BorderLayout.SOUTH);
        printPanel.add(now,BorderLayout.NORTH);
        
        btn1 = new JButton("이전 단어");
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

    public void memCon(){
        int option = JOptionPane.showConfirmDialog(this, "마지막 단어입니다","",JOptionPane.YES_NO_OPTION );
        if(option == 0) i=0;
        else if (option == 1){
            new MainScreen();
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new MemScreen();
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource()==btn1){
            if (i >= 1) i--;
            nowi = String.valueOf(i+1);
            now.setText(nowi+"/"+stotal);
            String setM = m[i];
            String setW = w[i];
            word.setText(setW);
            mean.setText(setM);
            mean.setVisible(false); 
        }
        else if (e.getSource()==btn3){
            if (i>=w.length) memCon();
            if (i>=0)i++;
            nowi = String.valueOf(i);
            now.setText(nowi+"/"+stotal);
            String setM = m[i];
            String setW = w[i];
            word.setText(setW);
            mean.setText(setM);
            mean.setVisible(false);
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