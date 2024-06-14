package src;
//import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.Random;

//import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
//import javax.swing.JTextArea;
import javax.swing.JTextField;
import src.wordlist;

public class MainScreen extends JFrame {
    JLabel word, mean, la1, la2;
    JTextField id;
    JPasswordField passwd;
    JPanel printPanel,listPanel,btnPanel1,btnPanel2;
    JButton btn1, btn2, btn3;
    JButton list1, list2, list3, list4;
    JScrollPane wordlist;
    wordlist wl = new wordlist();

    static int cnt,f,n;
    Random rnd = new Random();
    static int select;
    
    public void filecnt(){
        String dir_path = "./words"; 
        int cnt = 0;

        File dir = new File(dir_path);
        File[] list = dir.listFiles();

        for (int i=0 ; i<list.length ; i++) cnt++;
        this.cnt = cnt;
    }

    public String getwlist(){
        f = rnd.nextInt(2);
        wl.getFile(f+1);
        String[] w = wl.wordView();
        n = rnd.nextInt(w.length);
        return w[n];

    }
    public String getmlist(){
        wl.getFile(f+1);
        String[] m = wl.meanView();
        return m[n];
    }

    public MainScreen() {
        super("Main Screen");
        setLayout(new BorderLayout(10,20));

        listPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,300,50));
        printPanel = new JPanel(new BorderLayout(30,30));

        String todayword = getwlist();
        String todaymean = getmlist();
        word = new JLabel(todayword);
        mean = new JLabel(todaymean);
        
        word.setHorizontalAlignment(JLabel.CENTER);
        mean.setHorizontalAlignment(JLabel.CENTER);

        printPanel.add(word,BorderLayout.CENTER);
        printPanel.add(mean,BorderLayout.SOUTH);

        list1 = new JButton("단어장 1");
        list2 = new JButton("단어장 2");
        list3 = new JButton("단어장 3");
        list4 = new JButton("단어장 4");

        list1.setPreferredSize(new Dimension(200,50));
        list2.setPreferredSize(new Dimension(200,50));
        list3.setPreferredSize(new Dimension(200,50));
        list4.setPreferredSize(new Dimension(200,50));
       
        listPanel.add(list1);
        listPanel.add(list2);
        listPanel.add(list3);
        listPanel.add(list4);

        wordlist = new JScrollPane(listPanel,JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
           // 스크롤 생김

        this.add(printPanel,BorderLayout.NORTH);
        this.add(listPanel,BorderLayout.CENTER);

        list1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                select = 1;
                new MemScreen();
                setVisible(false);
            }
        });
        list2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                select = 2;
                new MemScreen();
                setVisible(false);
            }
        });
        list3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                select = 3;
                new MemScreen();
                setVisible(false);
            }
        });
        list4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                select = 4;
                new MemScreen();
                setVisible(false);
            }
        });

        word.setFont(new Font("나눔고딕", Font.BOLD,15));
        mean.setFont(new Font("나눔고딕", Font.BOLD,15));
        list1.setFont(new Font("나눔고딕", Font.BOLD,15));
        list2.setFont(new Font("나눔고딕", Font.BOLD,15));
        list3.setFont(new Font("나눔고딕", Font.BOLD,15));
        list4.setFont(new Font("나눔고딕", Font.BOLD,15));
        
        setSize(350,550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public int setList(){
        return select;
    }

    public static void main(String[] args) {
        new MainScreen();
    }
}