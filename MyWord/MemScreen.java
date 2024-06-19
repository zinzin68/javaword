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
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class MemScreen extends JFrame implements ActionListener{
    JLabel word, mean, now, total;
    JPanel printPanel,idPanel,Header,btnPanel;
    RoundedButton btn1, btn2, btn3, bfbtn;
    MainScreen ms = new MainScreen();
    String[] w, m;
    String nowi, stotal;
    Color listc[];

    static int i =0;

    public MemScreen() {
        super("MyWord");
        ms.setVisible(false);
        this.getContentPane().setBackground(Color.WHITE);
        setLayout(new BorderLayout(30,20));
        ImageIcon icon = new ImageIcon("MyWord/icon.png");
        this.setIconImage(icon.getImage());

        i=0;
        int x = ms.setList();
        wordlist.getFile(x);
        w = wordlist.wordView();
        m = wordlist.meanView();
        
        idPanel = new JPanel();
        Header = new JPanel(new BorderLayout(0,0));
        printPanel = new JPanel(new BorderLayout(0,0));
        
        idPanel.setBackground(Color.WHITE);
        Header.setBackground(Color.WHITE);
        printPanel.setBackground(Color.WHITE);

        bfbtn = new RoundedButton("암기 종료",new Color(255,255,255),new Color (192,0,0));
        Header.add(bfbtn,BorderLayout.WEST);
        Header.setBorder(BorderFactory.createEmptyBorder(0,0,80,0));

        word = new JLabel(w[0]);
        mean = new JLabel(m[0]);
        nowi = String.valueOf(i+1);
        stotal = String.valueOf(w.length);

        now = new JLabel(nowi+"/"+stotal);
        Header.add(now,BorderLayout.SOUTH);
        now.setHorizontalAlignment(JLabel.CENTER);

        mean.setVisible(false);
        
        word.setHorizontalAlignment(JLabel.CENTER);
        mean.setHorizontalAlignment(JLabel.CENTER);

        printPanel.add(word,BorderLayout.CENTER);
        printPanel.add(mean,BorderLayout.SOUTH);
        
        listc = new Color[3];
        listc[0] = new Color (255,215,179);
        listc[1] = new Color (153,220,225);
        listc[2] = new Color (224,175,205);

        btn1 = new RoundedButton("이전 단어", listc[0] , Color.BLACK);
        btn2 = new RoundedButton("뜻 확인", listc[1],Color.BLACK);
        btn3 = new RoundedButton("다음 단어", listc[2] ,Color.BLACK);

        btn1.setPreferredSize(new Dimension(100,40));
        btn2.setPreferredSize(new Dimension(100,40));
        btn3.setPreferredSize(new Dimension(100,40));

        btnPanel = new JPanel();
        btnPanel.setBackground(Color.WHITE);
        btnPanel.add(btn1);
        btnPanel.add(btn2);
        btnPanel.add(btn3);
        btnPanel.setBorder(BorderFactory.createEmptyBorder(100,0,100,0));

        btn1.setBackground(Color.white);
        btn2.setBackground(Color.white);
        btn3.setBackground(Color.white);
        bfbtn.setBackground(Color.white);

        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        bfbtn.addActionListener(this);

        this.add(Header,BorderLayout.NORTH);
        this.add(printPanel,BorderLayout.CENTER);
        this.add(btnPanel,BorderLayout.SOUTH);

        bfbtn.setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN,15));
        word.setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN,20));
        mean.setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN,20));
        btn1.setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN,15));
        btn2.setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN,15));
        btn3.setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN,15));
        now.setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN,15));

        setSize(350,550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    /*public void memCon(){
        int option = JOptionPane.showConfirmDialog(this, "마지막 단어입니다","",JOptionPane.YES_NO_OPTION );
        if(option == 0) i=0;
        else if (option == 1){
            new MainScreen();
            this.setVisible(false);
        }
    }*/

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
            String[] options={"처음으로","끝내기"};

            if (i==w.length-1) {
                int option = JOptionPane.showOptionDialog(this, "마지막 단어입니다 \n 처음으로 돌아갈까요?","",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, null, options, options[0] );
                if(option == JOptionPane.YES_OPTION ) i=-1;
                else if (option == JOptionPane.NO_OPTION){
                    new MainScreen();
                    this.setVisible(false);
                }
            }

            if (i>=-1)i++;
            nowi = String.valueOf(i+1);
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
    public class RoundedButton extends JButton {
        Color c;//버튼 색
        Color o;//글자 색
        public RoundedButton() { super(); decorate(); } 
        public RoundedButton(String text , Color color, Color textcolor) { super(text); c=color; o = textcolor; decorate(); } 
        public RoundedButton(Action action) { super(action); decorate(); } 
        public RoundedButton(Icon icon) { super(icon); decorate(); } 
        public RoundedButton(String text, Icon icon) { super(text, icon); decorate(); } 
        protected void decorate() { setBorderPainted(false); setOpaque(false); }
        @Override 
        protected void paintComponent(Graphics g) {
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