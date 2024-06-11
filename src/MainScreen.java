package src;
//import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
//import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MainScreen extends JFrame {
    JLabel word, mean, la1, la2;
    JTextField id;
    JPasswordField passwd;
    JPanel printPanel,listPanel,btnPanel1,btnPanel2;
    JButton btn1, btn2, btn3;
    JButton list1, list2;
    JScrollPane wordlist;

    public MainScreen() {
        super("Main Screen");
        setLayout(new BorderLayout(10,20));
        
        listPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,300,50));
        printPanel = new JPanel(new BorderLayout(30,30));

        word = new JLabel("오늘의 단어");
        mean = new JLabel("단어 뜻");
        
        word.setHorizontalAlignment(JLabel.CENTER);
        mean.setHorizontalAlignment(JLabel.CENTER);

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
        

        list1 = new JButton("단어장 1");
        list2 = new JButton("단어장 2");

        list1.setPreferredSize(new Dimension(200,50));
        list2.setPreferredSize(new Dimension(200,50));

        //btnPanel1 = new JPanel();
        //btnPanel1.add(list1);
        //btnPanel2 = new JPanel();
        //btnPanel2.add(list2);
        
        listPanel.add(list1);
        listPanel.add(list2);

        wordlist = new JScrollPane(listPanel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
           // 스크롤 생김

        this.add(printPanel,BorderLayout.NORTH);
        this.add(listPanel,BorderLayout.CENTER);

        list1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                new MemScreen();
                setVisible(false);
            }
        });
        list2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                new MemScreen();
                setVisible(false);
            }
        });

        word.setFont(new Font("나눔고딕", Font.BOLD,15));
        mean.setFont(new Font("나눔고딕", Font.BOLD,15));
        list1.setFont(new Font("나눔고딕", Font.BOLD,15));
        list2.setFont(new Font("나눔고딕", Font.BOLD,15));
        
        setSize(350,550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args) {
        new MainScreen();
    }
}