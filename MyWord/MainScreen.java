package MyWord;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class MainScreen extends JFrame implements ActionListener {
    JLabel today, word, mean;    
    JPanel printPanel,listPanel, Header;
    RoundedButton list[], exitbtn;
    JScrollPane listOfword;
    Color listc[];

    int cnt,f,n;
    Random rnd = new Random();
    static int select;
    String todayword, todaymean;
    
    public void filecnt(){
        String dir_path = "./words"; 
        cnt = 0;

        File dir = new File(dir_path);
        File[] list = dir.listFiles();

        for (int i=0 ; i<list.length ; i++) cnt++;
    }

    public String getwlist(){
        filecnt();
        if (cnt >=0) {
            do{
                f = rnd.nextInt()%cnt;
            }while(f<=0);
        }        
        wordlist.getFile(f);
        String[] w = wordlist.wordView();
        n = rnd.nextInt(w.length);
        return w[n];
    }
    public String getmlist(){
        wordlist.getFile(f);
        String[] m = wordlist.meanView();
        return m[n];
    }

    public MainScreen() {
        super("MyWord");
        setLayout(new BorderLayout(10,10));
        this.getContentPane().setBackground(Color.WHITE);
        ImageIcon icon = new ImageIcon("MyWord/icon.png");
        setIconImage(icon.getImage());

        listPanel = new JPanel();
        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));
        listPanel.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));
        listPanel.setBackground(Color.WHITE);

        printPanel = new JPanel(new BorderLayout(10,10));
        printPanel.setBackground(Color.WHITE);

        Header = new JPanel(new BorderLayout(0,0));
        Header.setBackground(Color.WHITE);
        exitbtn = new RoundedButton("종료",Color.white,new Color (192,0,0));
        exitbtn.addActionListener(this);

        Header.add(exitbtn, BorderLayout.WEST);
        Header.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        Header.add(printPanel,BorderLayout.SOUTH);

        todayword = getwlist();
        todaymean = getmlist();
        today = new JLabel("랜덤 단어");
        word = new JLabel(todayword);
        mean = new JLabel(todaymean);
        
        today.setHorizontalAlignment(JLabel.CENTER);
        word.setHorizontalAlignment(JLabel.CENTER);
        mean.setHorizontalAlignment(JLabel.CENTER);

        printPanel.add(today,BorderLayout.NORTH);
        printPanel.add(word,BorderLayout.CENTER);
        printPanel.add(mean,BorderLayout.SOUTH);

        printPanel.setBorder(BorderFactory.createEmptyBorder(10,0,20,0));

        listc = new Color[3];
        listc[0] = new Color (255,215,179);
        listc[1] = new Color (153,220,225);
        listc[2] = new Color (224,175,205);

        list = new RoundedButton[cnt];

        for (int i =0 ; i < cnt ; i++){
            list[i] = new RoundedButton("단어장 "+(i+1), listc[i%3],new Color (0,0,0));
            list[i].setPreferredSize(new Dimension(300,60));
            list[i].setMaximumSize(new Dimension(150,60));
            list[i].setMinimumSize(new Dimension(100,60));
            list[i].setAlignmentX(Component.CENTER_ALIGNMENT);
            
            listPanel.add(list[i]);
            listPanel.add(Box.createRigidArea(new Dimension(0,40)));
            list[i].setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN,15));
            list[i].setBackground(Color.white);
            list[i].setBorder(null);

            list[i].addActionListener(this);
        }        

        listOfword = new JScrollPane(listPanel);
        listOfword.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        listOfword.setBorder(null);
           // 스크롤 생김

        this.add(Header,BorderLayout.NORTH);
        this.add(listOfword,BorderLayout.CENTER);

        exitbtn.setFont(new Font("한컴 말랑말랑 Bold",Font.PLAIN,15));
        exitbtn.setForeground(Color.RED);
        today.setFont(new Font("한컴 말랑말랑 Bold",Font.PLAIN,15));
        word.setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN,20));
        mean.setFont(new Font("한컴 말랑말랑 Bold", Font.PLAIN,15));
        
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

    @Override
    public void actionPerformed(ActionEvent e){
        for (int i =0 ; i<cnt ; i++){
            if (e.getSource()==list[i]){
                select = i+1;
                new MemScreen();
                setVisible(false);
            }
        }
        if (e.getSource() == exitbtn){
            System.exit(0);
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
